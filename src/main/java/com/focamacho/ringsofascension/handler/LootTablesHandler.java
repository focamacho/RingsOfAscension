package com.focamacho.ringsofascension.handler;

import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.init.ModItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class LootTablesHandler {

    public static void init() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if(ConfigRingsOfAscension.ringDungeonChests && id.equals(new Identifier("minecraft", "chests/simple_dungeon"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringMineshaftChests && id.equals(new Identifier("minecraft", "chests/abandoned_mineshaft"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringBuriedTreasureChests && id.equals(new Identifier("minecraft", "chests/buried_treasure"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringPyramidChests && id.equals(new Identifier("minecraft", "chests/desert_pyramid"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringEndCityChests && id.equals(new Identifier("minecraft", "chests/end_city_treasure"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringIglooChests && id.equals(new Identifier("minecraft", "chests/igloo_chest"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringJungleChests && id.equals(new Identifier("minecraft", "chests/jungle_temple"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringNetherChests && id.equals(new Identifier("minecraft", "chests/nether_bridge"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringPillagerChests && id.equals(new Identifier("minecraft", "chests/pillager_outpost"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringShipwreckChests && id.equals(new Identifier("minecraft", "chests/shipwreck_treasure"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringBonusChests && id.equals(new Identifier("minecraft", "chests/spawn_bonus_chest"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringStrongholdChests && id.equals(new Identifier("minecraft", "chests/stronghold_library"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringWoodlandChests && id.equals(new Identifier("minecraft", "chests/woodland_mansion"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringToolsmithChests && id.equals(new Identifier("minecraft", "chests/village/village_toolsmith"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringWeaponsmithChests && id.equals(new Identifier("minecraft", "chests/village/village_weaponsmith"))) {
                supplier.withPool(getLootPool());
            } else if(ConfigRingsOfAscension.ringArmorerChests && id.equals(new Identifier("minecraft", "chests/village/village_armorer"))) {
                supplier.withPool(getLootPool());
            }
        });
    }

    private static LootPool getLootPool() {
        FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder()
                .withRolls(UniformLootTableRange.between((float)ConfigRingsOfAscension.ringMinLoot, (float)ConfigRingsOfAscension.ringMaxLoot));

        ModItems.allRings.forEach(ring -> {
            builder.withEntry(ItemEntry.builder(ring).setWeight(getWeightFromTier(ring.getTier())));
        });

        return builder.build();
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
        }
        return 20;
    }

}
