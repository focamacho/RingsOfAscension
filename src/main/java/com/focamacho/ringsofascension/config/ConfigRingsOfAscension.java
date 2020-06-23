package com.focamacho.ringsofascension.config;

import com.moandjiezana.toml.Toml;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ConfigRingsOfAscension {
    
    public static int ringUndyingCooldown;
    public static int ringHealthHearts;

    public static boolean ringFireResistance;
    public static boolean ringInvisibility;
    public static boolean ringRegeneration;
    public static boolean ringSlowFalling;
    public static boolean ringStrength;
    public static boolean ringWaterBreathing;
    public static boolean ringSpeed;
    public static boolean ringNightVision;
    public static boolean ringJumpBoost;
    public static boolean ringMining;
    public static boolean ringLuck;
    public static boolean ringDolphin;
    public static boolean ringMagnetism;
    public static boolean ringFlight;
    public static boolean ringPoisonResistance;
    public static boolean ringHungerless;
    public static boolean ringGrowth;
    public static boolean ringKnockbackResistance;
    public static boolean ringHealth;
    public static boolean ringSponge;
    public static boolean ringExperience;
    public static boolean ringWaterWalking;
    public static boolean ringWither;
    public static boolean ringUndying;
    public static boolean ringSlowResistance;

    public static int ringAmplifierFireResistance;
    public static int ringAmplifierInvisibility;
    public static int ringAmplifierRegeneration;
    public static int ringAmplifierSlowFalling;
    public static int ringAmplifierStrength;
    public static int ringAmplifierWaterBreathing;
    public static int ringAmplifierSpeed;
    public static int ringAmplifierNightVision;
    public static int ringAmplifierJumpBoost;
    public static int ringAmplifierMining;
    public static int ringAmplifierLuck;
    public static int ringAmplifierDolphin;

    public static int ringTierFireResistance;
    public static int ringTierInvisibility;
    public static int ringTierRegeneration;
    public static int ringTierSlowFalling;
    public static int ringTierStrength;
    public static int ringTierWaterBreathing;
    public static int ringTierSpeed;
    public static int ringTierNightVision;
    public static int ringTierJumpBoost;
    public static int ringTierMining;
    public static int ringTierLuck;
    public static int ringTierDolphin;
    public static int ringTierMagnetism;
    public static int ringTierFlight;
    public static int ringTierPoisonResistance;
    public static int ringTierHungerless;
    public static int ringTierGrowth;
    public static int ringTierKnockbackResistance;
    public static int ringTierHealth;
    public static int ringTierSponge;
    public static int ringTierExperience;
    public static int ringTierWaterWalking;
    public static int ringTierWither;
    public static int ringTierUndying;
    public static int ringTierSlowResistance;

    public static int ringMinLoot;
    public static int ringMaxLoot;

    public static boolean ringDungeonChests;
    public static boolean ringMineshaftChests;
    public static boolean ringPyramidChests;
    public static boolean ringBuriedTreasureChests;
    public static boolean ringEndCityChests;
    public static boolean ringIglooChests;
    public static boolean ringJungleChests;
    public static boolean ringNetherChests;
    public static boolean ringPillagerChests;
    public static boolean ringShipwreckChests;
    public static boolean ringBonusChests;
    public static boolean ringStrongholdChests;
    public static boolean ringWoodlandChests;
    public static boolean ringToolsmithChests;
    public static boolean ringWeaponsmithChests;
    public static boolean ringArmorerChests;

    public static void init() {
        File configFile = new File(FabricLoader.getInstance().getConfigDirectory(), "ringsofascension.toml");

        if(!configFile.exists()) {
            try {
                configFile.createNewFile();
                setDefaultConfigs(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toml toml = new Toml().read(configFile);

        String category = "\"Rings of Ascension\"";
        ringUndyingCooldown = getInteger(category, "ringUndyingCooldown", toml);
        ringHealthHearts = getInteger(category, "ringHealthHearts", toml);

        category = "\"Enable/Disable Rings\"";
        ringFireResistance = getBoolean(category, "ringFireResistance", toml);
        ringInvisibility = getBoolean(category, "ringInvisibility", toml);
        ringRegeneration = getBoolean(category, "ringRegeneration", toml);
        ringSlowFalling = getBoolean(category, "ringSlowFalling", toml);
        ringStrength = getBoolean(category, "ringStrength", toml);
        ringWaterBreathing = getBoolean(category, "ringWaterBreathing", toml);
        ringSpeed = getBoolean(category, "ringSpeed", toml);
        ringNightVision = getBoolean(category, "ringNightVision", toml);
        ringJumpBoost = getBoolean(category, "ringJumpBoost", toml);
        ringMining = getBoolean(category, "ringMining", toml);
        ringLuck = getBoolean(category, "ringLuck", toml);
        ringDolphin = getBoolean(category, "ringDolphin", toml);
        ringMagnetism = getBoolean(category, "ringMagnetism", toml);
        ringFlight = getBoolean(category, "ringFlight", toml);
        ringPoisonResistance = getBoolean(category, "ringPoisonResistance", toml);
        ringHungerless = getBoolean(category, "ringHungerless", toml);
        ringGrowth = getBoolean(category, "ringGrowth", toml);
        ringKnockbackResistance = getBoolean(category, "ringKnockbackResistance", toml);
        ringHealth = getBoolean(category, "ringHealth", toml);
        ringSponge = getBoolean(category, "ringSponge", toml);
        ringExperience = getBoolean(category, "ringExperience", toml);
        ringWaterWalking = getBoolean(category, "ringWaterWalking", toml);
        ringWither = getBoolean(category, "ringWither", toml);
        ringUndying = getBoolean(category, "ringUndying", toml);
        ringSlowResistance = getBoolean(category, "ringSlowResistance", toml);

        category = "\"Rings Amplifier\".Amplifiers";
        ringAmplifierFireResistance = getInteger(category, "ringAmplifierFireResistance", toml);
        ringAmplifierInvisibility = getInteger(category, "ringAmplifierInvisibility", toml);
        ringAmplifierRegeneration = getInteger(category, "ringAmplifierRegeneration", toml);
        ringAmplifierSlowFalling = getInteger(category, "ringAmplifierSlowFalling", toml);
        ringAmplifierStrength = getInteger(category, "ringAmplifierStrength", toml);
        ringAmplifierWaterBreathing = getInteger(category, "ringAmplifierWaterBreathing", toml);
        ringAmplifierSpeed = getInteger(category, "ringAmplifierSpeed", toml);
        ringAmplifierNightVision = getInteger(category, "ringAmplifierNightVision", toml);
        ringAmplifierJumpBoost = getInteger(category, "ringAmplifierJumpBoost", toml);
        ringAmplifierMining = getInteger(category, "ringAmplifierMining", toml);
        ringAmplifierLuck = getInteger(category, "ringAmplifierLuck", toml);
        ringAmplifierDolphin = getInteger(category, "ringAmplifierDolphin", toml);

        category = "\"Rings Tier\".Tiers";
        ringTierFireResistance = getInteger(category, "ringTierFireResistance", toml);
        ringTierInvisibility = getInteger(category, "ringTierInvisibility", toml);
        ringTierRegeneration = getInteger(category, "ringTierRegeneration", toml);
        ringTierSlowFalling = getInteger(category, "ringTierSlowFalling", toml);
        ringTierStrength = getInteger(category, "ringTierStrength", toml);
        ringTierWaterBreathing = getInteger(category, "ringTierWaterBreathing", toml);
        ringTierSpeed = getInteger(category, "ringTierSpeed", toml);
        ringTierNightVision = getInteger(category, "ringTierNightVision", toml);
        ringTierJumpBoost = getInteger(category, "ringTierJumpBoost", toml);
        ringTierMining = getInteger(category, "ringTierMining", toml);
        ringTierLuck = getInteger(category, "ringTierLuck", toml);
        ringTierDolphin = getInteger(category, "ringTierDolphin", toml);
        ringTierMagnetism = getInteger(category, "ringTierMagnetism", toml);
        ringTierFlight = getInteger(category, "ringTierFlight", toml);
        ringTierPoisonResistance = getInteger(category, "ringTierPoisonResistance", toml);
        ringTierHungerless = getInteger(category, "ringTierHungerless", toml);
        ringTierGrowth = getInteger(category, "ringTierGrowth", toml);
        ringTierKnockbackResistance = getInteger(category, "ringTierKnockbackResistance", toml);
        ringTierHealth = getInteger(category, "ringTierHealth", toml);
        ringTierSponge = getInteger(category, "ringTierSponge", toml);
        ringTierExperience = getInteger(category, "ringTierExperience", toml);
        ringTierWaterWalking = getInteger(category, "ringTierWaterWalking", toml);
        ringTierWither = getInteger(category, "ringTierWither", toml);
        ringTierUndying = getInteger(category, "ringTierUndying", toml);
        ringTierSlowResistance = getInteger(category, "ringTierSlowResistance", toml);

        category = "\"Rings Loot\"";
        ringMinLoot = getInteger(category, "ringMinLoot", toml);
        ringMaxLoot = getInteger(category, "ringMaxLoot", toml);

        category = "\"Rings Loot Chests\"";
        ringDungeonChests = getBoolean(category, "ringDungeonChests", toml);
        ringMineshaftChests = getBoolean(category, "ringMineshaftChests", toml);
        ringPyramidChests = getBoolean(category, "ringPyramidChests", toml);
        ringBuriedTreasureChests = getBoolean(category, "ringBuriedTreasureChests", toml);
        ringEndCityChests = getBoolean(category, "ringEndCityChests", toml);
        ringIglooChests = getBoolean(category, "ringIglooChests", toml);
        ringJungleChests = getBoolean(category, "ringJungleChests", toml);
        ringNetherChests = getBoolean(category, "ringNetherChests", toml);
        ringPillagerChests = getBoolean(category, "ringPillagerChests", toml);
        ringShipwreckChests = getBoolean(category, "ringShipwreckChests", toml);
        ringBonusChests = getBoolean(category, "ringBonusChests", toml);
        ringStrongholdChests = getBoolean(category, "ringStrongholdChests", toml);
        ringWoodlandChests = getBoolean(category, "ringWoodlandChests", toml);
        ringToolsmithChests = getBoolean(category, "ringToolsmithChests", toml);
        ringWeaponsmithChests = getBoolean(category, "ringWeaponsmithChests", toml);
        ringArmorerChests = getBoolean(category, "ringArmorerChests", toml);
    }

    private static int getInteger(String category, String key, Toml toml) {
        return toml.getLong(category + "." + key).intValue();
    }

    private static boolean getBoolean(String category, String key, Toml toml) {
        return toml.getBoolean(category + "." + key);
    }
    
    private static void setDefaultConfigs(File file) throws IOException {
        Files.write(file.toPath(), ("[\"Rings of Ascension\"]\n" +
                "\t#The amount of hearts that Max Health's ring gives you.\n" +
                "\t#Range: 0 ~ 400\n" +
                "\tringHealthHearts = 10\n" +
                "\t#The cooldown in seconds of the Ring of Undying\n" +
                "\t#Range: > 0\n" +
                "\tringUndyingCooldown = 600\n" +
                "\n" +
                "[\"Enable/Disable Rings\"]\n" +
                "\tringWaterWalking = true\n" +
                "\tringMagnetism = true\n" +
                "\tringSponge = true\n" +
                "\tringNightVision = true\n" +
                "\tringRegeneration = true\n" +
                "\tringPoisonResistance = true\n" +
                "\tringStrength = true\n" +
                "\tringGrowth = true\n" +
                "\tringInvisibility = true\n" +
                "\tringWaterBreathing = true\n" +
                "\tringWither = true\n" +
                "\tringDolphin = true\n" +
                "\tringKnockbackResistance = true\n" +
                "\tringHungerless = true\n" +
                "\tringFireResistance = true\n" +
                "\tringExperience = true\n" +
                "\tringMining = true\n" +
                "\tringHealth = true\n" +
                "\tringSlowResistance = true\n" +
                "\tringJumpBoost = true\n" +
                "\tringLuck = true\n" +
                "\tringSpeed = true\n" +
                "\tringUndying = true\n" +
                "\tringSlowFalling = true\n" +
                "\tringFlight = true\n" +
                "\n" +
                "[\"Rings Amplifier\"]\n" +
                "\n" +
                "\t#Sets the amplifier of the effect given by the ring. Example:\n" +
                "\t#0 = Fire Resistance I\n" +
                "\t#1 = Fire Resistance II\n" +
                "\t[\"Rings Amplifier\".Amplifiers]\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierSlowFalling = 0\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierJumpBoost = 0\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierDolphin = 0\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierInvisibility = 0\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierWaterBreathing = 1\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierLuck = 1\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierRegeneration = 0\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierFireResistance = 1\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierStrength = 0\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierMining = 1\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierSpeed = 0\n" +
                "\t\t#Range: 0 ~ 255\n" +
                "\t\tringAmplifierNightVision = 0\n" +
                "\n" +
                "[\"Rings Tier\"]\n" +
                "\n" +
                "\t#Sets the Tier of the rings. Higher tier rings are more difficult to find.\n" +
                "\t#0 = Common\n" +
                "\t#1 = Rare\n" +
                "\t#2 = Epic\n" +
                "\t#3 = Legendary\n" +
                "\t[\"Rings Tier\".Tiers]\n" +
                "\t\tringTierWaterBreathing = 0\n" +
                "\t\tringTierKnockbackResistance = 0\n" +
                "\t\tringTierNightVision = 0\n" +
                "\t\tringTierPoisonResistance = 1\n" +
                "\t\tringTierSlowFalling = 0\n" +
                "\t\tringTierMagnetism = 2\n" +
                "\t\tringTierSponge = 1\n" +
                "\t\tringTierSpeed = 1\n" +
                "\t\tringTierWither = 1\n" +
                "\t\tringTierHealth = 3\n" +
                "\t\tringTierLuck = 2\n" +
                "\t\tringTierRegeneration = 1\n" +
                "\t\tringTierDolphin = 1\n" +
                "\t\tringTierWaterWalking = 0\n" +
                "\t\tringTierInvisibility = 1\n" +
                "\t\tringTierGrowth = 2\n" +
                "\t\tringTierMining = 2\n" +
                "\t\tringTierUndying = 3\n" +
                "\t\tringTierFireResistance = 0\n" +
                "\t\tringTierStrength = 1\n" +
                "\t\tringTierHungerless = 3\n" +
                "\t\tringTierJumpBoost = 0\n" +
                "\t\tringTierSlowResistance = 1\n" +
                "\t\tringTierFlight = 3\n" +
                "\t\tringTierExperience = 0\n" +
                "\n" +
                "[\"Rings Loot\"]\n" +
                "\t#The maximum number of rings that can be found inside a single chest.\n" +
                "\tringMaxLoot = 1\n" +
                "\t#The minimum number of rings that can be found inside a single chest.\n" +
                "\tringMinLoot = 0\n" +
                "\n" +
                "[\"Rings Loot Chests\"]\n" +
                "\t#Generate rings in woodland mansion chests\n" +
                "\tringWoodlandChests = true\n" +
                "\t#Generate rings in village toolsmith chests\n" +
                "\tringToolsmithChests = true\n" +
                "\t#Generate rings in dungeon chests\n" +
                "\tringDungeonChests = true\n" +
                "\t#Generate rings in pillager outpost chests\n" +
                "\tringPillagerChests = true\n" +
                "\t#Generate rings in village armorer chests\n" +
                "\tringArmorerChests = true\n" +
                "\t#Generate rings in abandoned mineshaft chests\n" +
                "\tringMineshaftChests = true\n" +
                "\t#Generate rings in desert pyramid chests\n" +
                "\tringPyramidChests = true\n" +
                "\t#Generate rings in end city chests\n" +
                "\tringEndCityChests = true\n" +
                "\t#Generate rings in stronghold library chests\n" +
                "\tringStrongholdChests = true\n" +
                "\t#Generate rings in village weaponsmith chests\n" +
                "\tringWeaponsmithChests = true\n" +
                "\t#Generate rings in buried treasure chests\n" +
                "\tringBuriedTreasureChests = true\n" +
                "\t#Generate rings in igloo chests\n" +
                "\tringIglooChests = true\n" +
                "\t#Generate rings in nether bridge chests\n" +
                "\tringNetherChests = true\n" +
                "\t#Generate rings in spawn bonus chests\n" +
                "\tringBonusChests = true\n" +
                "\t#Generate rings in shipwreck treasure chests\n" +
                "\tringShipwreckChests = true\n" +
                "\t#Generate rings in jungle temple chests\n" +
                "\tringJungleChests = true\n" +
                "\n").getBytes());
    }

}
