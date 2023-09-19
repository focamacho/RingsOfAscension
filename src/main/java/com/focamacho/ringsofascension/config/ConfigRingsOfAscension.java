package com.focamacho.ringsofascension.config;

import com.focamacho.sealconfig.relocated.blue.endless.jankson.api.annotation.Comment;

public class ConfigRingsOfAscension {

    @Comment("General configs")
    public RingsOfAscension general = new RingsOfAscension();

    @Comment("Enable/Disable Rings")
    public EnableRings enableRings = new EnableRings();

    @Comment("Sets the amplifier of the effect given by the ring. Example: 0 = Fire Resistance I; 1 = Fire Resistance II")
    public Amplifiers amplifiers = new Amplifiers();

    public static class RingsOfAscension {
        @Comment("The cooldown in seconds of the Ring of Undying")
        public int ringUndyingCooldown = 600;

        @Comment("The amount of hearts that Ring of Max Health gives you.")
        public int ringHealthHearts = 10;
    }

    public static class EnableRings {
        public boolean ringFireResistance = true;
        public boolean ringInvisibility = true;
        public boolean ringRegeneration = true;
        public boolean ringSlowFalling = true;
        public boolean ringStrength = true;
        public boolean ringWaterBreathing = true;
        public boolean ringSpeed = true;
        public boolean ringNightVision = true;
        public boolean ringJumpBoost = true;
        public boolean ringMining = true;
        public boolean ringLuck = true;
        public boolean ringDolphin = true;
        public boolean ringMagnetism = true;
        public boolean ringFlight = true;
        public boolean ringPoisonResistance = true;
        public boolean ringHungerless = true;
        public boolean ringGrowth = true;
        public boolean ringKnockbackResistance = true;
        public boolean ringHealth = true;
        public boolean ringSponge = true;
        public boolean ringLavaSponge = true;
        public boolean ringExperience = true;
        public boolean ringWaterWalking = true;
        public boolean ringWither = true;
        public boolean ringUndying = true;
        public boolean ringSlowResistance = true;
        public boolean ringSteadfastSteps = true;
    }

    public static class Amplifiers {
        public int ringAmplifierFireResistance = 1;
        public int ringAmplifierInvisibility = 0;
        public int ringAmplifierRegeneration = 0;
        public int ringAmplifierSlowFalling = 0;
        public int ringAmplifierStrength = 0;
        public int ringAmplifierWaterBreathing = 1;
        public int ringAmplifierSpeed = 0;
        public int ringAmplifierNightVision = 0;
        public int ringAmplifierJumpBoost = 0;
        public int ringAmplifierMining = 1;
        public int ringAmplifierLuck = 1;
        public int ringAmplifierDolphin = 0;
    }

}
