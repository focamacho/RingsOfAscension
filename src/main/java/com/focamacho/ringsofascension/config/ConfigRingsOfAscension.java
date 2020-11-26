package com.focamacho.ringsofascension.config;

import com.focamacho.ringsofascension.RingsOfAscension;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigRingsOfAscension {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final General GENERAL = new General(BUILDER);
    public static final ForgeConfigSpec spec = BUILDER.build();

    //Config Values
    public static ForgeConfigSpec.IntValue configRingUndyingCooldown;
    public static ForgeConfigSpec.IntValue configRingHealthHearts;

    public static ForgeConfigSpec.BooleanValue configRingFireResistance;
    public static ForgeConfigSpec.BooleanValue configRingInvisibility;
    public static ForgeConfigSpec.BooleanValue configRingRegeneration;
    public static ForgeConfigSpec.BooleanValue configRingSlowFalling;
    public static ForgeConfigSpec.BooleanValue configRingStrength;
    public static ForgeConfigSpec.BooleanValue configRingWaterBreathing;
    public static ForgeConfigSpec.BooleanValue configRingSpeed;
    public static ForgeConfigSpec.BooleanValue configRingNightVision;
    public static ForgeConfigSpec.BooleanValue configRingJumpBoost;
    public static ForgeConfigSpec.BooleanValue configRingMining;
    public static ForgeConfigSpec.BooleanValue configRingLuck;
    public static ForgeConfigSpec.BooleanValue configRingDolphin;
    public static ForgeConfigSpec.BooleanValue configRingMagnetism;
    public static ForgeConfigSpec.BooleanValue configRingFlight;
    public static ForgeConfigSpec.BooleanValue configRingPoisonResistance;
    public static ForgeConfigSpec.BooleanValue configRingHungerless;
    public static ForgeConfigSpec.BooleanValue configRingGrowth;
    public static ForgeConfigSpec.BooleanValue configRingKnockbackResistance;
    public static ForgeConfigSpec.BooleanValue configRingHealth;
    public static ForgeConfigSpec.BooleanValue configRingSponge;
    public static ForgeConfigSpec.BooleanValue configRingExperience;
    public static ForgeConfigSpec.BooleanValue configRingWaterWalking;
    public static ForgeConfigSpec.BooleanValue configRingWither;
    public static ForgeConfigSpec.BooleanValue configRingUndying;
    public static ForgeConfigSpec.BooleanValue configRingSlowResistance;

    public static ForgeConfigSpec.ConfigValue<String> configRingLocationFireResistance;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationInvisibility;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationRegeneration;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationSlowFalling;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationStrength;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationWaterBreathing;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationSpeed;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationNightVision;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationJumpBoost;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationMining;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationLuck;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationDolphin;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationMagnetism;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationFlight;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationPoisonResistance;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationHungerless;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationGrowth;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationKnockbackResistance;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationHealth;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationSponge;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationExperience;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationWaterWalking;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationWither;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationUndying;
    public static ForgeConfigSpec.ConfigValue<String> configRingLocationSlowResistance;

    public static ForgeConfigSpec.IntValue configRingAmplifierFireResistance;
    public static ForgeConfigSpec.IntValue configRingAmplifierInvisibility;
    public static ForgeConfigSpec.IntValue configRingAmplifierRegeneration;
    public static ForgeConfigSpec.IntValue configRingAmplifierSlowFalling;
    public static ForgeConfigSpec.IntValue configRingAmplifierStrength;
    public static ForgeConfigSpec.IntValue configRingAmplifierWaterBreathing;
    public static ForgeConfigSpec.IntValue configRingAmplifierSpeed;
    public static ForgeConfigSpec.IntValue configRingAmplifierNightVision;
    public static ForgeConfigSpec.IntValue configRingAmplifierJumpBoost;
    public static ForgeConfigSpec.IntValue configRingAmplifierMining;
    public static ForgeConfigSpec.IntValue configRingAmplifierLuck;
    public static ForgeConfigSpec.IntValue configRingAmplifierDolphin;

    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierFireResistance;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierInvisibility;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierRegeneration;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierSlowFalling;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierStrength;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierWaterBreathing;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierSpeed;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierNightVision;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierJumpBoost;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierMining;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierLuck;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierDolphin;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierMagnetism;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierFlight;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierPoisonResistance;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierHungerless;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierGrowth;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierKnockbackResistance;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierHealth;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierSponge;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierExperience;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierWaterWalking;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierWither;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierUndying;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingTierSlowResistance;

    public static ForgeConfigSpec.ConfigValue<Integer> configRingMinLoot;
    public static ForgeConfigSpec.ConfigValue<Integer> configRingMaxLoot;

    public static class General {
        public General(final ForgeConfigSpec.Builder builder) {
            builder.push("Rings of Ascension");
            configRingUndyingCooldown = builder
                    .comment("The cooldown in seconds of the Ring of Undying")
                    .translation(RingsOfAscension.MODID + ".config.ringUndyingCooldown")
                    .defineInRange("ringUndyingCooldown", 600, 0, Integer.MAX_VALUE);
            configRingHealthHearts = builder
                    .comment("The amount of hearts that Max Health's ring gives you.")
                    .translation(RingsOfAscension.MODID + ".config.ringHealthHearts")
                    .defineInRange("ringHealthHearts", 10, 0, 400);
            builder.pop();

            builder.push("Enable/Disable Rings");
            configRingFireResistance = builder.define("ringFireResistance", true);
            configRingInvisibility = builder.define("ringInvisibility", true);
            configRingRegeneration = builder.define("ringRegeneration", true);
            configRingSlowFalling = builder.define("ringSlowFalling", true);
            configRingStrength = builder.define("ringStrength", true);
            configRingWaterBreathing = builder.define("ringWaterBreathing", true);
            configRingSpeed = builder.define("ringSpeed", true);
            configRingNightVision = builder.define("ringNightVision", true);
            configRingJumpBoost = builder.define("ringJumpBoost", true);
            configRingMining = builder.define("ringMining", true);
            configRingLuck = builder.define("ringLuck", true);
            configRingDolphin = builder.define("ringDolphin", true);
            configRingMagnetism = builder.define("ringMagnetism", true);
            configRingFlight = builder.define("ringFlight", true);
            configRingPoisonResistance = builder.define("ringPoisonResistance", true);
            configRingHungerless = builder.define("ringHungerless", true);
            configRingGrowth = builder.define("ringGrowth", true);
            configRingKnockbackResistance = builder.define("ringKnockbackResistance", true);
            configRingHealth = builder.define("ringHealth", true);
            configRingSponge = builder.define("ringSponge", true);
            configRingExperience = builder.define("ringExperience", true);
            configRingWaterWalking = builder.define("ringWaterWalking", true);
            configRingWither = builder.define("ringWither", true);
            configRingUndying = builder.define("ringUndying", true);
            configRingSlowResistance = builder.define("ringSlowResistance", true);
            builder.pop();
            
            builder.push("Rings Amplifier").comment("Sets the amplifier of the effect given by the ring. Example:\n" +
                                                    "0 = Fire Resistance I\n" +
                                                    "1 = Fire Resistance II").push("Amplifiers");
            configRingAmplifierFireResistance = builder.defineInRange("ringAmplifierFireResistance", 1, 0, 255);
            configRingAmplifierInvisibility = builder.defineInRange("ringAmplifierInvisibility", 0, 0, 255);
            configRingAmplifierRegeneration = builder.defineInRange("ringAmplifierRegeneration", 0, 0, 255);
            configRingAmplifierSlowFalling = builder.defineInRange("ringAmplifierSlowFalling", 0, 0, 255);
            configRingAmplifierStrength = builder.defineInRange("ringAmplifierStrength", 0, 0, 255);
            configRingAmplifierWaterBreathing = builder.defineInRange("ringAmplifierWaterBreathing", 1, 0, 255);
            configRingAmplifierSpeed = builder.defineInRange("ringAmplifierSpeed", 0, 0, 255);
            configRingAmplifierNightVision = builder.defineInRange("ringAmplifierNightVision", 0, 0, 255);
            configRingAmplifierJumpBoost = builder.defineInRange("ringAmplifierJumpBoost", 0, 0, 255);
            configRingAmplifierMining = builder.defineInRange("ringAmplifierMining", 1, 0, 255);
            configRingAmplifierLuck = builder.defineInRange("ringAmplifierLuck", 1, 0, 255);
            configRingAmplifierDolphin = builder.defineInRange("ringAmplifierDolphin", 0, 0, 255);
            builder.pop(2);

            builder.push("Rings Tier").comment("Sets the Tier of the rings. Higher tier rings are more difficult to find.\n" +
                                                "0 = Common\n" +
                                                "1 = Rare\n" +
                                                "2 = Epic\n" +
                                                "3 = Legendary\n" +
                                                "4 = Mythic").push("Tiers");
            configRingTierFireResistance = builder.defineInRange("ringTierFireResistance", 0, 0, 4);
            configRingTierInvisibility = builder.defineInRange("ringTierInvisibility", 1, 0, 4);
            configRingTierRegeneration = builder.defineInRange("ringTierRegeneration", 3, 0, 4);
            configRingTierSlowFalling = builder.defineInRange("ringTierSlowFalling", 0, 0, 4);
            configRingTierStrength = builder.defineInRange("ringTierStrength", 2, 0, 4);
            configRingTierWaterBreathing = builder.defineInRange("ringTierWaterBreathing", 0, 0, 4);
            configRingTierSpeed = builder.defineInRange("ringTierSpeed", 1, 0, 4);
            configRingTierNightVision = builder.defineInRange("ringTierNightVision", 0, 0, 4);
            configRingTierJumpBoost = builder.defineInRange("ringTierJumpBoost", 0, 0, 4);
            configRingTierMining = builder.defineInRange("ringTierMining", 2, 0, 4);
            configRingTierLuck = builder.defineInRange("ringTierLuck", 3, 0, 4);
            configRingTierDolphin = builder.defineInRange("ringTierDolphin", 1, 0, 4);
            configRingTierMagnetism = builder.defineInRange("ringTierMagnetism", 2, 0, 4);
            configRingTierFlight = builder.defineInRange("ringTierFlight", 4, 0, 4);
            configRingTierPoisonResistance = builder.defineInRange("ringTierPoisonResistance", 2, 0, 4);
            configRingTierHungerless = builder.defineInRange("ringTierHungerless", 3, 0, 4);
            configRingTierGrowth = builder.defineInRange("ringTierGrowth", 2, 0, 4);
            configRingTierKnockbackResistance = builder.defineInRange("ringTierKnockbackResistance", 0, 0, 4);
            configRingTierHealth = builder.defineInRange("ringTierHealth", 3, 0, 4);
            configRingTierSponge = builder.defineInRange("ringTierSponge", 1, 0, 4);
            configRingTierExperience = builder.defineInRange("ringTierExperience", 0, 0, 4);
            configRingTierWaterWalking = builder.defineInRange("ringTierWaterWalking", 0, 0, 4);
            configRingTierWither = builder.defineInRange("ringTierWither", 1, 0, 4);
            configRingTierUndying = builder.defineInRange("ringTierUndying", 4, 0, 4);
            configRingTierSlowResistance = builder.defineInRange("ringTierSlowResistance", 1, 0, 4);
            builder.pop(2);

            builder.push("Rings Loot");
            configRingMinLoot = builder.comment("The minimum number of rings that can be found inside a single chest. Values below 0 decrease the chance of the rings appearing.").define("ringMinLoot", -5);
            configRingMaxLoot = builder.comment("The maximum number of rings that can be found inside a single chest.").define("ringMaxLoot", 1);
            builder.pop();

            builder.push("Rings Locations");
            configRingLocationFireResistance = builder.define("ringLocationFireResistance", "minecraft:chests/nether_bridge;minecraft:chests/ruined_portal;minecraft:chests/bastion_treasure");
            configRingLocationInvisibility = builder.define("ringLocationInvisibility", "minecraft:chests/abandoned_mineshaft;minecraft:chests/buried_treasure");
            configRingLocationRegeneration = builder.define("ringLocationRegeneration", "minecraft:chests/stronghold_corridor;minecraft:chests/stronghold_library");
            configRingLocationSlowFalling = builder.define("ringLocationSlowFalling", "minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/end_city_treasure");
            configRingLocationStrength = builder.define("ringLocationStrength", "minecraft:chests/stronghold_library;minecraft:chests/stronghold_corridor;minecraft:chests/stronghold_crossing;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge;minecraft:chests/pillager_outpost");
            configRingLocationWaterBreathing = builder.define("ringLocationWaterBreathing", "minecraft:chests/spawn_bonus_chest;minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small;minecraft:chests/buried_treasure");
            configRingLocationSpeed = builder.define("ringLocationSpeed", "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure");
            configRingLocationNightVision = builder.define("ringLocationNightVision", "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/abandoned_mineshaft");
            configRingLocationJumpBoost = builder.define("ringLocationJumpBoost", "minecraft:chests/end_city_treasure;minecraft:chests/igloo_chest;minecraft:chests/desert_pyramid");
            configRingLocationMining = builder.define("ringLocationMining", "minecraft:chests/simple_dungeon;minecraft:chests/abandoned_mineshaft");
            configRingLocationLuck = builder.define("ringLocationLuck", "minecraft:chests/simple_dungeon;minecraft:chests/jungle_temple");
            configRingLocationDolphin = builder.define("ringLocationDolphin", "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small;minecraft:chests/buried_treasure");
            configRingLocationMagnetism = builder.define("ringLocationMagnetism", "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/ruined_portal");
            configRingLocationFlight = builder.define("ringLocationFlight", "minecraft:chests/end_city_treasure");
            configRingLocationPoisonResistance = builder.define("ringLocationPoisonResistance", "minecraft:chests/jungle_temple;minecraft:chests/end_city_treasure;minecraft:chests/shipwreck_treasure;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge");
            configRingLocationHungerless = builder.define("ringLocationHungerless", "minecraft:chests/village/village_butcher;minecraft:chests/end_city_treasure;minecraft:chests/woodland_mansion");
            configRingLocationGrowth = builder.define("ringLocationGrowth", "minecraft:chests/jungle_temple");
            configRingLocationKnockbackResistance = builder.define("ringLocationKnockbackResistance", "minecraft:chests/end_city_treasure;minecraft:chests/bastion_bridge;minecraft:chests/nether_bridge");
            configRingLocationHealth = builder.define("ringLocationHealth", "minecraft:chests/end_city_treasure;minecraft:chests/bastion_treasure;minecraft:chests/stronghold_library");
            configRingLocationSponge = builder.define("ringLocationSponge", "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small");
            configRingLocationExperience = builder.define("ringLocationExperience", "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/ruined_portal");
            configRingLocationWaterWalking = builder.define("ringLocationWaterWalking", "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small;minecraft:chests/buried_treasure");
            configRingLocationWither = builder.define("ringLocationWither", "minecraft:chests/bastion_treasure");
            configRingLocationUndying = builder.define("ringLocationUndying", "minecraft:chests/woodland_mansion");
            configRingLocationSlowResistance = builder.define("ringLocationSlowResistance", "minecraft:chests/end_city_treasure;minecraft:chests/shipwreck_treasure;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge");
            builder.pop();
        }
    }

}