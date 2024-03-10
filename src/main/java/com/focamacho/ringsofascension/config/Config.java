package com.focamacho.ringsofascension.config;

import com.focamacho.ringsofascension.RingsOfAscension;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final General GENERAL = new General(BUILDER);
    public static final ModConfigSpec spec = BUILDER.build();

    //Config Values
    public static ModConfigSpec.IntValue configRingUndyingCooldown;
    public static ModConfigSpec.IntValue configRingHealthHearts;

    public static ModConfigSpec.BooleanValue configRingFireResistance;
    public static ModConfigSpec.BooleanValue configRingInvisibility;
    public static ModConfigSpec.BooleanValue configRingRegeneration;
    public static ModConfigSpec.BooleanValue configRingSlowFalling;
    public static ModConfigSpec.BooleanValue configRingStrength;
    public static ModConfigSpec.BooleanValue configRingWaterBreathing;
    public static ModConfigSpec.BooleanValue configRingSpeed;
    public static ModConfigSpec.BooleanValue configRingNightVision;
    public static ModConfigSpec.BooleanValue configRingJumpBoost;
    public static ModConfigSpec.BooleanValue configRingMining;
    public static ModConfigSpec.BooleanValue configRingLuck;
    public static ModConfigSpec.BooleanValue configRingDolphin;
    public static ModConfigSpec.BooleanValue configRingMagnetism;
    public static ModConfigSpec.BooleanValue configRingFlight;
    public static ModConfigSpec.BooleanValue configRingPoisonResistance;
    public static ModConfigSpec.BooleanValue configRingHungerless;
    public static ModConfigSpec.BooleanValue configRingGrowth;
    public static ModConfigSpec.BooleanValue configRingKnockbackResistance;
    public static ModConfigSpec.BooleanValue configRingHealth;
    public static ModConfigSpec.BooleanValue configRingSponge;
    public static ModConfigSpec.BooleanValue configRingExperience;
    public static ModConfigSpec.BooleanValue configRingWaterWalking;
    public static ModConfigSpec.BooleanValue configRingWither;
    public static ModConfigSpec.BooleanValue configRingUndying;
    public static ModConfigSpec.BooleanValue configRingSlowResistance;
    public static ModConfigSpec.BooleanValue configRingSteadfastSteps;

    public static ModConfigSpec.IntValue configRingAmplifierFireResistance;
    public static ModConfigSpec.IntValue configRingAmplifierInvisibility;
    public static ModConfigSpec.IntValue configRingAmplifierRegeneration;
    public static ModConfigSpec.IntValue configRingAmplifierSlowFalling;
    public static ModConfigSpec.IntValue configRingAmplifierStrength;
    public static ModConfigSpec.IntValue configRingAmplifierWaterBreathing;
    public static ModConfigSpec.IntValue configRingAmplifierSpeed;
    public static ModConfigSpec.IntValue configRingAmplifierNightVision;
    public static ModConfigSpec.IntValue configRingAmplifierJumpBoost;
    public static ModConfigSpec.IntValue configRingAmplifierMining;
    public static ModConfigSpec.IntValue configRingAmplifierLuck;
    public static ModConfigSpec.IntValue configRingAmplifierDolphin;

    public static class General {
        public General(final ModConfigSpec.Builder builder) {
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
            configRingSteadfastSteps = builder.define("ringSteadfastSteps", true);
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
        }
    }

}