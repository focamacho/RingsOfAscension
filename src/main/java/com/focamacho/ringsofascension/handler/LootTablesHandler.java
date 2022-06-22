package com.focamacho.ringsofascension.handler;

import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import static com.focamacho.ringsofascension.RingsOfAscension.config;

public class LootTablesHandler {

    public static void init() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            LootPool.Builder builder = LootPool.builder()
                    .rolls(UniformLootNumberProvider.create((float)config.loot.ringMinLoot, (float)config.loot.ringMaxLoot));

            boolean add = false;

            for (ItemRingBase ring : ModItems.allRings) {
                if(ring.isEnabled()) {
                    if(ring.locations.contains(id)) {
                        builder.with(ItemEntry.builder(ring).weight(getWeightFromTier(ring.getTier())).build());
                        add = true;
                    }
                }
            }

            if(add) tableBuilder.pool(builder.build());
        });
    }

    private static int getWeightFromTier(int tier) {
        return switch (tier) {
            case 1 -> 15;
            case 2 -> 10;
            case 3 -> 5;
            case 4 -> 1;
            default -> 20;
        };
    }

}
