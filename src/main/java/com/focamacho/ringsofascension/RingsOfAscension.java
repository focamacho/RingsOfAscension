package com.focamacho.ringsofascension;

import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.handler.LootTablesHandler;
import com.focamacho.ringsofascension.init.ModItems;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketSlots;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class RingsOfAscension implements ModInitializer {

	public static final ItemGroup creativeTab = FabricItemGroupBuilder.build(new Identifier("ringsofascension", "rings"), () -> new ItemStack(ModItems.ringGrowth.isEnabled() ? ModItems.ringGrowth : ModItems.allRings.get(0)));

	@Override
	public void onInitialize() {
		AutoConfig.register(ConfigRingsOfAscension.class, Toml4jConfigSerializer::new);

		TrinketSlots.addSlot(SlotGroups.HAND, Slots.RING, new Identifier("trinkets", "textures/item/empty_trinket_slot_ring.png"));
		TrinketSlots.addSlot(SlotGroups.OFFHAND, Slots.RING, new Identifier("trinkets", "textures/item/empty_trinket_slot_ring.png"));

		ModItems.init();
		LootTablesHandler.init();
	}

}
