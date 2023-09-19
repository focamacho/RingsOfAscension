package com.focamacho.ringsofascension;

import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.handler.LootTablesHandler;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.sealconfig.SealConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.File;

public class RingsOfAscension implements ModInitializer {

	private final SealConfig sealConfig = new SealConfig();
	public static ConfigRingsOfAscension config;

	public static final ItemGroup CREATIVE_TAB =  FabricItemGroup.builder(new Identifier("ringsofascension", "creative_tab"))
			.displayName(Text.translatable("itemGroup.ringsofascension"))
			.icon(() -> new ItemStack(ModItems.ringExperience))
			.build();

	@Override
	public void onInitialize() {
		config = sealConfig.getConfig(new File(FabricLoader.getInstance().getConfigDir().toFile(), "ringsofascension.json"), ConfigRingsOfAscension.class);
		ModItems.init();
		LootTablesHandler.init();

		ItemGroupEvents.modifyEntriesEvent(CREATIVE_TAB).register(content ->
				ModItems.allRings.forEach(r -> content.add(new ItemStack(r)))
		);
	}

}
