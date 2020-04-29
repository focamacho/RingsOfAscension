package com.focamacho.ringsofascension.config;

import com.focamacho.ringsofascension.RingsOfAscension;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigRingsOfAscension {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final General GENERAL = new General(BUILDER);
    public static final ForgeConfigSpec spec = BUILDER.build();

    //Config Values
    public static ForgeConfigSpec.IntValue configRingUndyingCooldown;

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


    public static class General {
        public General(final ForgeConfigSpec.Builder builder) {
            builder.push("Rings of Ascension");
            configRingUndyingCooldown = builder
                    .comment("The cooldown in seconds of the Ring of Undying")
                    .translation(RingsOfAscension.MODID + ".config.ringUndyingCooldown")
                    .defineInRange("ringUndyingCooldown", 300, 0, Integer.MAX_VALUE);
            builder.pop();

            builder.push("Enable/Disable Rings");
            configRingFireResistance = builder.comment("Ring of Fire Resistance").define("ringFireResistance", true);
            configRingInvisibility = builder.comment("Ring of Invisibility").define("ringInvisibility", true);
            configRingRegeneration = builder.comment("Ring of Regeneration").define("ringRegeneration", true);
            configRingSlowFalling = builder.comment("Ring of Slow Falling").define("ringSlowFalling", true);
            configRingStrength = builder.comment("Ring of Strength").define("ringStrength", true);
            configRingWaterBreathing = builder.comment("Ring of Water Breathing").define("ringWaterBreathing", true);
            configRingSpeed = builder.comment("Ring of Speed").define("ringSpeed", true);
            configRingNightVision = builder.comment("Ring of Night Vision").define("ringNightVision", true);
            configRingJumpBoost = builder.comment("Ring of Jump Boost").define("ringJumpBoost", true);
            configRingMining = builder.comment("Ring of Mining").define("ringMining", true);
            configRingLuck = builder.comment("Ring of Luck").define("ringLuck", true);
            configRingDolphin = builder.comment("Ring of Dolphin").define("ringDolphin", true);
            configRingMagnetism = builder.comment("Ring of Magnetism").define("ringMagnetism", true);
            configRingFlight = builder.comment("Ring of Flight").define("ring_flight", true);
            configRingPoisonResistance = builder.comment("Ring of Poison Resistance").define("ringPoisonResistance", true);
            configRingHungerless = builder.comment("Ring of Hungerless").define("ringHungerless", true);
            configRingGrowth = builder.comment("Ring of Growth").define("ringGrowth", true);
            configRingKnockbackResistance = builder.comment("Ring of Knockback Resistance").define("ringKnockbackResistance", true);
            configRingHealth = builder.comment("Ring of Max Health").define("ringHealth", true);
            configRingSponge = builder.comment("Ring of Sponge").define("ringSponge", true);
            configRingExperience = builder.comment("Ring of Experience").define("ringExperience", true);
            configRingWaterWalking = builder.comment("Ring of Water Walking").define("ringWaterWalking", true);
            configRingWither = builder.comment("Ring of Wither").define("ringWither", true);
            configRingUndying = builder.comment("Ring of Undying").define("ringUndying", true);
            configRingSlowResistance = builder.comment("Ring of Slow Resistance").define("ringSlowResistance", true);
            builder.pop();
        }
    }

}