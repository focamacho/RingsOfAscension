package com.focamacho.ringsofascension.config;

import com.focamacho.ringsofascension.RingsOfAscension;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final General GENERAL = new General(BUILDER);
    public static final ForgeConfigSpec spec = BUILDER.build();

    //Config Values
    public static IntValue configRingUndyingCooldown;
    public static IntValue configRingHealthHearts;

    public static BooleanValue configRingFireResistance;
    public static BooleanValue configRingInvisibility;
    public static BooleanValue configRingRegeneration;
    public static BooleanValue configRingSlowFalling;
    public static BooleanValue configRingStrength;
    public static BooleanValue configRingWaterBreathing;
    public static BooleanValue configRingSpeed;
    public static BooleanValue configRingNightVision;
    public static BooleanValue configRingJumpBoost;
    public static BooleanValue configRingMining;
    public static BooleanValue configRingLuck;
    public static BooleanValue configRingDolphin;
    public static BooleanValue configRingMagnetism;
    public static BooleanValue configRingFlight;
    public static BooleanValue configRingPoisonResistance;
    public static BooleanValue configRingHungerless;
    public static BooleanValue configRingGrowth;
    public static BooleanValue configRingKnockbackResistance;
    public static BooleanValue configRingHealth;
    public static BooleanValue configRingSponge;
    public static BooleanValue configRingExperience;
    public static BooleanValue configRingWaterWalking;
    public static BooleanValue configRingWither;
    public static BooleanValue configRingUndying;
    public static BooleanValue configRingSlowResistance;
    public static BooleanValue configRingSteadfastSteps;

    public static IntValue configRingAmplifierFireResistance;
    public static IntValue configRingAmplifierInvisibility;
    public static IntValue configRingAmplifierRegeneration;
    public static IntValue configRingAmplifierSlowFalling;
    public static IntValue configRingAmplifierStrength;
    public static IntValue configRingAmplifierWaterBreathing;
    public static IntValue configRingAmplifierSpeed;
    public static IntValue configRingAmplifierNightVision;
    public static IntValue configRingAmplifierJumpBoost;
    public static IntValue configRingAmplifierMining;
    public static IntValue configRingAmplifierLuck;
    public static IntValue configRingAmplifierDolphin;

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