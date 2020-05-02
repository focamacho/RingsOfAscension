package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.init.ModItems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableEvent {

    @SubscribeEvent
    public void onLoadTable(LootTableLoadEvent event) {
        if(ConfigHolder.ringDungeonChests && event.getName().equals(new ResourceLocation("minecraft", "chests/simple_dungeon"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringMineshaftChests && event.getName().equals(new ResourceLocation("minecraft", "chests/abandoned_mineshaft"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringBuriedTreasureChests && event.getName().equals(new ResourceLocation("minecraft", "chests/buried_treasure"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringPyramidChests && event.getName().equals(new ResourceLocation("minecraft", "chests/desert_pyramid"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringEndCityChests && event.getName().equals(new ResourceLocation("minecraft", "chests/end_city_treasure"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringIglooChests && event.getName().equals(new ResourceLocation("minecraft", "chests/igloo_chest"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringJungleChests && event.getName().equals(new ResourceLocation("minecraft", "chests/jungle_temple"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringNetherChests && event.getName().equals(new ResourceLocation("minecraft", "chests/nether_bridge"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringPillagerChests && event.getName().equals(new ResourceLocation("minecraft", "chests/pillager_outpost"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringShipwreckChests && event.getName().equals(new ResourceLocation("minecraft", "chests/shipwreck_treasure"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringBonusChests && event.getName().equals(new ResourceLocation("minecraft", "chests/spawn_bonus_chest"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringStrongholdChests && event.getName().equals(new ResourceLocation("minecraft", "chests/stronghold_library"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringWoodlandChests && event.getName().equals(new ResourceLocation("minecraft", "chests/woodland_mansion"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringToolsmithChests && event.getName().equals(new ResourceLocation("minecraft", "chests/village/village_toolsmith"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringWeaponsmithChests && event.getName().equals(new ResourceLocation("minecraft", "chests/village/village_weaponsmith"))) {
            event.getTable().addPool(getLootPool());
        }
        if(ConfigHolder.ringArmorerChests && event.getName().equals(new ResourceLocation("minecraft", "chests/village/village_armorer"))) {
            event.getTable().addPool(getLootPool());
        }
    }

    private LootPool getLootPool() {
        LootPool pool = LootPool.builder()
                .rolls(RandomValueRange.func_215837_a(ConfigHolder.ringMinLoot, ConfigHolder.ringMaxLoot))

                //Ring of Fire Resistance
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringFireResistance).weight(getWeightFromTier(ConfigHolder.ringTierFireResistance)))
                //Ring of Dolphin
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringDolphin).weight(getWeightFromTier(ConfigHolder.ringTierDolphin)))
                //Ring of Experience
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringExperience).weight(getWeightFromTier(ConfigHolder.ringTierExperience)))
                //Ring of Flight
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringFlight).weight(getWeightFromTier(ConfigHolder.ringTierFlight)))
                //Ring of Growth
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringGrowth).weight(getWeightFromTier(ConfigHolder.ringTierGrowth)))
                //Ring of Max Health
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringHealth).weight(getWeightFromTier(ConfigHolder.ringTierHealth)))
                //Ring of Hungerless
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringHungerless).weight(getWeightFromTier(ConfigHolder.ringTierHungerless)))
                //Ring of Invisibility
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringInvisibility).weight(getWeightFromTier(ConfigHolder.ringTierInvisibility)))
                //Ring of Jump Boost
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringJumpBoost).weight(getWeightFromTier(ConfigHolder.ringTierJumpBoost)))
                //Ring of Knockback Resistance
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringKnockbackResistance).weight(getWeightFromTier(ConfigHolder.ringTierKnockbackResistance)))
                //Ring of Luck
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringLuck).weight(getWeightFromTier(ConfigHolder.ringTierLuck)))
                //Ring of Magnetism
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringMagnetism).weight(getWeightFromTier(ConfigHolder.ringTierMagnetism)))
                //Ring of Mining
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringMining).weight(getWeightFromTier(ConfigHolder.ringTierMining)))
                //Ring of Night Vision
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringNightVision).weight(getWeightFromTier(ConfigHolder.ringTierNightVision)))
                //Ring of Poison Resistance
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringPoisonResistance).weight(getWeightFromTier(ConfigHolder.ringTierPoisonResistance)))
                //Ring of Regeneration
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringRegeneration).weight(getWeightFromTier(ConfigHolder.ringTierRegeneration)))
                //Ring of Slow Falling
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringSlowFalling).weight(getWeightFromTier(ConfigHolder.ringTierSlowFalling)))
                //Ring of Slowness Resistance
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringSlowResistance).weight(getWeightFromTier(ConfigHolder.ringTierSlowResistance)))
                //Ring of Speed
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringSpeed).weight(getWeightFromTier(ConfigHolder.ringTierSpeed)))
                //Ring of Sponge
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringSponge).weight(getWeightFromTier(ConfigHolder.ringTierSponge)))
                //Ring of Strength
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringStrength).weight(getWeightFromTier(ConfigHolder.ringTierStrength)))
                //Ring of Water Breathing
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringWaterBreathing).weight(getWeightFromTier(ConfigHolder.ringTierWaterBreathing)))
                //Ring of Undying
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringUndying).weight(getWeightFromTier(ConfigHolder.ringTierUndying)))
                //Ring of Water Walking
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringWaterWalking).weight(getWeightFromTier(ConfigHolder.ringTierWaterWalking)))
                //Ring of Wither
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringWither).weight(getWeightFromTier(ConfigHolder.ringTierWither)))
                .build();

        return pool;
    }

    private int getWeightFromTier(int tier) {
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
