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

    public static ForgeConfigSpec.BooleanValue configRingDungeonChests;
    public static ForgeConfigSpec.BooleanValue configRingMineshaftChests;
    public static ForgeConfigSpec.BooleanValue configRingPyramidChests;
    public static ForgeConfigSpec.BooleanValue configRingBuriedTreasureChests;
    public static ForgeConfigSpec.BooleanValue configRingEndCityChests;
    public static ForgeConfigSpec.BooleanValue configRingIglooChests;
    public static ForgeConfigSpec.BooleanValue configRingJungleChests;
    public static ForgeConfigSpec.BooleanValue configRingNetherChests;
    public static ForgeConfigSpec.BooleanValue configRingPillagerChests;
    public static ForgeConfigSpec.BooleanValue configRingShipwreckChests;
    public static ForgeConfigSpec.BooleanValue configRingBonusChests;
    public static ForgeConfigSpec.BooleanValue configRingStrongholdChests;
    public static ForgeConfigSpec.BooleanValue configRingWoodlandChests;
    public static ForgeConfigSpec.BooleanValue configRingToolsmithChests;
    public static ForgeConfigSpec.BooleanValue configRingWeaponsmithChests;
    public static ForgeConfigSpec.BooleanValue configRingArmorerChests;

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
                                                "3 = Legendary").push("Tiers");
            configRingTierFireResistance = builder.define("ringTierFireResistance", 0);
            configRingTierInvisibility = builder.define("ringTierInvisibility", 1);
            configRingTierRegeneration = builder.define("ringTierRegeneration", 1);
            configRingTierSlowFalling = builder.define("ringTierSlowFalling", 0);
            configRingTierStrength = builder.define("ringTierStrength", 1);
            configRingTierWaterBreathing = builder.define("ringTierWaterBreathing", 0);
            configRingTierSpeed = builder.define("ringTierSpeed", 1);
            configRingTierNightVision = builder.define("ringTierNightVision", 0);
            configRingTierJumpBoost = builder.define("ringTierJumpBoost", 0);
            configRingTierMining = builder.define("ringTierMining", 2);
            configRingTierLuck = builder.define("ringTierLuck", 2);
            configRingTierDolphin = builder.define("ringTierDolphin", 1);
            configRingTierMagnetism = builder.define("ringTierMagnetism", 2);
            configRingTierFlight = builder.define("ringTierFlight", 3);
            configRingTierPoisonResistance = builder.define("ringTierPoisonResistance", 1);
            configRingTierHungerless = builder.define("ringTierHungerless", 3);
            configRingTierGrowth = builder.define("ringTierGrowth", 2);
            configRingTierKnockbackResistance = builder.define("ringTierKnockbackResistance", 0);
            configRingTierHealth = builder.define("ringTierHealth", 3);
            configRingTierSponge = builder.define("ringTierSponge", 1);
            configRingTierExperience = builder.define("ringTierExperience", 0);
            configRingTierWaterWalking = builder.define("ringTierWaterWalking", 0);
            configRingTierWither = builder.define("ringTierWither", 1);
            configRingTierUndying = builder.define("ringTierUndying", 3);
            configRingTierSlowResistance = builder.define("ringTierSlowResistance", 1);
            builder.pop(2);

            builder.push("Rings Loot");
            configRingMinLoot = builder.comment("The minimum number of rings that can be found inside a single chest.").define("ringMinLoot", 0);
            configRingMaxLoot = builder.comment("The maximum number of rings that can be found inside a single chest.").define("ringMaxLoot", 1);
            builder.pop();

            builder.push("Rings Loot Chests");
            configRingDungeonChests = builder.comment("Generate rings in dungeon chests").define("ringDungeonChests", true);
            configRingMineshaftChests = builder.comment("Generate rings in abandoned mineshaft chests").define("ringMineshaftChests", true);
            configRingPyramidChests = builder.comment("Generate rings in desert pyramid chests").define("ringPyramidChests", true);
            configRingBuriedTreasureChests = builder.comment("Generate rings in buried treasure chests").define("ringBuriedTreasureChests", true);
            configRingEndCityChests = builder.comment("Generate rings in end city chests").define("ringEndCityChests", true);
            configRingIglooChests = builder.comment("Generate rings in igloo chests").define("ringIglooChests", true);
            configRingJungleChests = builder.comment("Generate rings in jungle temple chests").define("ringJungleChests", true);
            configRingNetherChests = builder.comment("Generate rings in nether bridge chests").define("ringNetherChests", true);
            configRingPillagerChests = builder.comment("Generate rings in pillager outpost chests").define("ringPillagerChests", true);
            configRingShipwreckChests = builder.comment("Generate rings in shipwreck treasure chests").define("ringShipwreckChests", true);
            configRingBonusChests = builder.comment("Generate rings in spawn bonus chests").define("ringBonusChests", true);
            configRingStrongholdChests = builder.comment("Generate rings in stronghold library chests").define("ringStrongholdChests", true);
            configRingWoodlandChests = builder.comment("Generate rings in woodland mansion chests").define("ringWoodlandChests", true);
            configRingToolsmithChests = builder.comment("Generate rings in village toolsmith chests").define("ringToolsmithChests", true);
            configRingWeaponsmithChests = builder.comment("Generate rings in village weaponsmith chests").define("ringWeaponsmithChests", true);
            configRingArmorerChests = builder.comment("Generate rings in village armorer chests").define("ringArmorerChests", true);
            builder.pop();
        }
    }

}