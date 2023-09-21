package com.focamacho.ringsofascension;

import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.data.LootModifier;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.sealconfig.SealConfig;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RingsOfAscension implements ModInitializer {

	public static final String MODID = "ringsofascension";

	private final SealConfig sealConfig = new SealConfig();
	public static ConfigRingsOfAscension config;

	private static final List<LootModifier> LOOT_MODIFIERS = new ArrayList<>();

	@Override
	public void onInitialize() {
		config = sealConfig.getConfig(new File(FabricLoader.getInstance().getConfigDir().toFile(), "ringsofascension.json"), ConfigRingsOfAscension.class);
		ModItems.init();

		// Creative Tab
		Registry.register(Registries.ITEM_GROUP, new Identifier(MODID, "creative_tab"), FabricItemGroup.builder()
				.displayName(Text.translatable("itemGroup.ringsofascension"))
				.icon(() -> new ItemStack(ModItems.ringExperience))
				.entries((context, entries) ->
						ModItems.allRings.forEach(r -> entries.add(new ItemStack(r)))
				)
				.build()
		);

		// Loot Modifiers
		ResourceManagerHelper.get(
				ResourceType.SERVER_DATA
		).registerReloadListener(new SimpleSynchronousResourceReloadListener() {

			@Override
			public void reload(ResourceManager manager) {
				loadModifiers(manager);
			}

			@Override
			public Identifier getFabricId() {
				return new Identifier(MODID, "loot_modifiers");
			}

		});

		// Change Loot Tables to use Loot Modifiers
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if(LOOT_MODIFIERS.isEmpty()) loadModifiers(resourceManager);

			LOOT_MODIFIERS.stream().filter(mod ->
					ArrayUtils.contains(mod.loot_tables, id.toString())
			).forEach(modifier ->
					tableBuilder.pool(
							new LootPool.Builder()
									.conditionally(Arrays.stream(modifier.conditions).collect(Collectors.toList()))
									.with(
											ItemEntry.builder(
													modifier.ring
											)
									)
									.build()
					));

		});

	}

	private void loadModifiers(ResourceManager manager) {
		LOOT_MODIFIERS.clear();

		Gson gson = new GsonBuilder().registerTypeAdapter(
				TypeToken.get(LootCondition.class).getType(),
				LootConditionTypes.createGsonSerializer()
		).registerTypeAdapter(
				TypeToken.get(Item.class).getType(),
				(JsonSerializer<Item>) (src, typeOfSrc, context) -> new JsonPrimitive(Registries.ITEM.getId(src).toString())
		).registerTypeAdapter(
				TypeToken.get(Item.class).getType(),
				(JsonDeserializer<Item>) (json, typeOfT, context) -> {
					String[] identifier = json.getAsString().split(":");
					return Registries.ITEM.get(
							Identifier.of(identifier[0], identifier[1])
					);
				}
		).create();

		Map<Identifier, Resource> resources = manager.findResources("loot_modifiers", (identifier) -> identifier.getPath().endsWith(".json"));
		for (Map.Entry<Identifier, Resource> entry : resources.entrySet()) {
			try(InputStream input = entry.getValue().getInputStream()) {
				LootModifier modifier = gson.fromJson(
						new String(input.readAllBytes(), StandardCharsets.UTF_8),
						LootModifier.class
				);
				LOOT_MODIFIERS.add(modifier);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
