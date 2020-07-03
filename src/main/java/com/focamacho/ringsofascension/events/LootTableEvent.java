package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.init.ModItems;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableEvent {

    @SubscribeEvent
    public void onLoadTable(LootTableLoadEvent event) {
        if(ConfigHolder.ringDungeonChests && event.getName().equals(new ResourceLocation("minecraft", "chests/simple_dungeon"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringMineshaftChests && event.getName().equals(new ResourceLocation("minecraft", "chests/abandoned_mineshaft"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringBuriedTreasureChests && event.getName().equals(new ResourceLocation("minecraft", "chests/buried_treasure"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringPyramidChests && event.getName().equals(new ResourceLocation("minecraft", "chests/desert_pyramid"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringEndCityChests && event.getName().equals(new ResourceLocation("minecraft", "chests/end_city_treasure"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringIglooChests && event.getName().equals(new ResourceLocation("minecraft", "chests/igloo_chest"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringJungleChests && event.getName().equals(new ResourceLocation("minecraft", "chests/jungle_temple"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringNetherChests && event.getName().equals(new ResourceLocation("minecraft", "chests/nether_bridge"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringPillagerChests && event.getName().equals(new ResourceLocation("minecraft", "chests/pillager_outpost"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringShipwreckChests && event.getName().equals(new ResourceLocation("minecraft", "chests/shipwreck_treasure"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringBonusChests && event.getName().equals(new ResourceLocation("minecraft", "chests/spawn_bonus_chest"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringStrongholdChests && event.getName().equals(new ResourceLocation("minecraft", "chests/stronghold_library"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringWoodlandChests && event.getName().equals(new ResourceLocation("minecraft", "chests/woodland_mansion"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringToolsmithChests && event.getName().equals(new ResourceLocation("minecraft", "chests/village/village_toolsmith"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringWeaponsmithChests && event.getName().equals(new ResourceLocation("minecraft", "chests/village/village_weaponsmith"))) {
            event.getTable().addPool(getLootPool());
        } else if(ConfigHolder.ringArmorerChests && event.getName().equals(new ResourceLocation("minecraft", "chests/village/village_armorer"))) {
            event.getTable().addPool(getLootPool());
        }
    }

    private LootPool getLootPool() {
        return LootPool.builder()
                .rolls(RandomValueRange.of(ConfigHolder.ringMinLoot, ConfigHolder.ringMaxLoot))

                //Ring of Fire Resistance
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringFireResistance).weight(ConfigHolder.ringFireResistance ? getWeightFromTier(ConfigHolder.ringTierFireResistance) : 0))
                //Ring of Dolphin
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringDolphin).weight(ConfigHolder.ringDolphin ? getWeightFromTier(ConfigHolder.ringTierDolphin) : 0))
                //Ring of Experience
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringExperience).weight(ConfigHolder.ringExperience ? getWeightFromTier(ConfigHolder.ringTierExperience) : 0))
                //Ring of Flight
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringFlight).weight(ConfigHolder.ringFlight ? getWeightFromTier(ConfigHolder.ringTierFlight) : 0))
                //Ring of Growth
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringGrowth).weight(ConfigHolder.ringGrowth ? getWeightFromTier(ConfigHolder.ringTierGrowth) : 0))
                //Ring of Max Health
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringHealth).weight(ConfigHolder.ringHealth ? getWeightFromTier(ConfigHolder.ringTierHealth) : 0))
                //Ring of Hungerless
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringHungerless).weight(ConfigHolder.ringHungerless ? getWeightFromTier(ConfigHolder.ringTierHungerless) : 0))
                //Ring of Invisibility
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringInvisibility).weight(ConfigHolder.ringInvisibility ? getWeightFromTier(ConfigHolder.ringTierInvisibility) : 0))
                //Ring of Jump Boost
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringJumpBoost).weight(ConfigHolder.ringJumpBoost ? getWeightFromTier(ConfigHolder.ringTierJumpBoost) : 0))
                //Ring of Knockback Resistance
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringKnockbackResistance).weight(ConfigHolder.ringKnockbackResistance ? getWeightFromTier(ConfigHolder.ringTierKnockbackResistance) : 0))
                //Ring of Luck
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringLuck).weight(ConfigHolder.ringLuck ? getWeightFromTier(ConfigHolder.ringTierLuck) : 0))
                //Ring of Magnetism
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringMagnetism).weight(ConfigHolder.ringMagnetism ? getWeightFromTier(ConfigHolder.ringTierMagnetism) : 0))
                //Ring of Mining
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringMining).weight(ConfigHolder.ringMining ? getWeightFromTier(ConfigHolder.ringTierMining) : 0))
                //Ring of Night Vision
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringNightVision).weight(ConfigHolder.ringNightVision ? getWeightFromTier(ConfigHolder.ringTierNightVision) : 0))
                //Ring of Poison Resistance
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringPoisonResistance).weight(ConfigHolder.ringPoisonResistance ? getWeightFromTier(ConfigHolder.ringTierPoisonResistance) : 0))
                //Ring of Regeneration
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringRegeneration).weight(ConfigHolder.ringRegeneration ? getWeightFromTier(ConfigHolder.ringTierRegeneration) : 0))
                //Ring of Slow Falling
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringSlowFalling).weight(ConfigHolder.ringSlowFalling ? getWeightFromTier(ConfigHolder.ringTierSlowFalling) : 0))
                //Ring of Slowness Resistance
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringSlowResistance).weight(ConfigHolder.ringSlowResistance ? getWeightFromTier(ConfigHolder.ringTierSlowResistance) : 0))
                //Ring of Speed
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringSpeed).weight(ConfigHolder.ringSpeed ? getWeightFromTier(ConfigHolder.ringTierSpeed) : 0))
                //Ring of Sponge
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringSponge).weight(ConfigHolder.ringSponge ? getWeightFromTier(ConfigHolder.ringTierSponge) : 0))
                //Ring of Strength
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringStrength).weight(ConfigHolder.ringStrength ? getWeightFromTier(ConfigHolder.ringTierStrength) : 0))
                //Ring of Water Breathing
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringWaterBreathing).weight(ConfigHolder.ringWaterBreathing ? getWeightFromTier(ConfigHolder.ringTierWaterBreathing) : 0))
                //Ring of Undying
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringUndying).weight(ConfigHolder.ringUndying ? getWeightFromTier(ConfigHolder.ringTierUndying) : 0))
                //Ring of Water Walking
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringWaterWalking).weight(ConfigHolder.ringWaterWalking ? getWeightFromTier(ConfigHolder.ringTierWaterWalking) : 0))
                //Ring of Wither
                .addEntry(ItemLootEntry.builder(() -> ModItems.ringWither).weight(ConfigHolder.ringWither ? getWeightFromTier(ConfigHolder.ringTierWither) : 0))

                .name("rings_of_ascension_pool")
                .build();
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
