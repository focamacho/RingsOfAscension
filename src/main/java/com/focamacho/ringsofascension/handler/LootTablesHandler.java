package com.focamacho.ringsofascension.handler;

import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.ItemRingBase;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;

public class LootTablesHandler {

    public static ConfigRingsOfAscension config = AutoConfig.getConfigHolder(ConfigRingsOfAscension.class).getConfig();

    public static void init() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder()
                    .rolls(UniformLootTableRange.between((float)config.loot.ringMinLoot, (float)config.loot.ringMaxLoot));

            boolean add = false;

            for (ItemRingBase ring : ModItems.allRings) {
                if(ring.isEnabled()) {
                    if(ring.locations.contains(id)) {
                        builder.with(ItemEntry.builder(ring).weight(getWeightFromTier(ring.getTier())));
                        add = true;
                    }
                }
            }

            if(add) supplier.withPool(builder.build());
        });
    }

    private static int getWeightFromTier(int tier) {
        switch(tier) {
            case 0:
                return 20;
            case 1:
                return 15;
            case 2:
                return 10;
            case 3:
                return 5;
            case 4:
                return 1;
        }
        return 20;
    }

}
