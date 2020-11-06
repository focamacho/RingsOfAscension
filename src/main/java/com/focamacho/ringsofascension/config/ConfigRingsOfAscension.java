package com.focamacho.ringsofascension.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "ringsofascension")
public class ConfigRingsOfAscension implements ConfigData {

    @Comment("General configs")
    @ConfigEntry.Gui.CollapsibleObject
    public static RingsOfAscension general = new RingsOfAscension();

    @Comment("Enable/Disable Rings")
    @ConfigEntry.Gui.CollapsibleObject
    public static EnableRings enableRings = new EnableRings();

    @Comment("Sets the amplifier of the effect given by the ring. Example: 0 = Fire Resistance I; 1 = Fire Resistance II")
    @ConfigEntry.Gui.CollapsibleObject
    public static Amplifiers amplifiers = new Amplifiers();

    @Comment("Sets the Tier of the rings. Higher tier rings are more difficult to find. 0 = Common; 1 = Rare; 2 = Epic; 3 = Legendary; 4 = Mythic")
    @ConfigEntry.Gui.CollapsibleObject
    public static Tiers tiers = new Tiers();

    @Comment("Rings Loot")
    @ConfigEntry.Gui.CollapsibleObject
    public static LootConfig loot = new LootConfig();

    @Comment("Loot Tables containing the Rings. You can edit it easier on the config file instead of the gui.")
    @ConfigEntry.Gui.CollapsibleObject
    public static LootLocations lootLocations = new LootLocations();

    public static class RingsOfAscension {
        @Comment("The cooldown in seconds of the Ring of Undying")
        public static int ringUndyingCooldown = 600;

        @Comment("The amount of hearts that Ring of Max Health gives you.")
        public static int ringHealthHearts = 10;
    }

    public static class EnableRings {
        public static boolean ringFireResistance = true;
        public static boolean ringInvisibility = true;
        public static boolean ringRegeneration = true;
        public static boolean ringSlowFalling = true;
        public static boolean ringStrength = true;
        public static boolean ringWaterBreathing = true;
        public static boolean ringSpeed = true;
        public static boolean ringNightVision = true;
        public static boolean ringJumpBoost = true;
        public static boolean ringMining = true;
        public static boolean ringLuck = true;
        public static boolean ringDolphin = true;
        public static boolean ringMagnetism = true;
        public static boolean ringFlight = true;
        public static boolean ringPoisonResistance = true;
        public static boolean ringHungerless = true;
        public static boolean ringGrowth = true;
        public static boolean ringKnockbackResistance = true;
        public static boolean ringHealth = true;
        public static boolean ringSponge = true;
        public static boolean ringExperience = true;
        public static boolean ringWaterWalking = true;
        public static boolean ringWither = true;
        public static boolean ringUndying = true;
        public static boolean ringSlowResistance = true;
    }

    public static class Amplifiers {
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierFireResistance = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierInvisibility = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierRegeneration = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierSlowFalling = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierStrength = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierWaterBreathing = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierSpeed = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierNightVision = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierJumpBoost = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierMining = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierLuck = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public static int ringAmplifierDolphin = 0;
    }

    public static class Tiers {
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierFireResistance = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierInvisibility = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierRegeneration = 3;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierSlowFalling = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierStrength = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierWaterBreathing = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierSpeed = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierNightVision = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierJumpBoost = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierMining = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierLuck = 3;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierDolphin = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierMagnetism = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierFlight = 4;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierPoisonResistance = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierHungerless = 3;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierGrowth = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierKnockbackResistance = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierHealth = 3;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierSponge = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierExperience = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierWaterWalking = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierWither = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierUndying = 4;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public static int ringTierSlowResistance = 1;
    }

    public static class LootConfig {
        @Comment("The minimum number of rings that can be found inside a single chest. Values below 0 decrease the chance of the rings appearing.")
        public static int ringMinLoot = -5;
        @Comment("The maximum number of rings that can be found inside a single chest.")
        public static int ringMaxLoot = 1;
    }

    public static class LootLocations {
        public static String ringLocationFireResistance = "minecraft:chests/nether_bridge;minecraft:chests/ruined_portal;minecraft:chests/bastion_treasure";
        public static String ringLocationInvisibility = "minecraft:chests/abandoned_mineshaft;minecraft:chests/buried_treasure";
        public static String ringLocationRegeneration = "minecraft:chests/stronghold_corridor;minecraft:chests/stronghold_library";
        public static String ringLocationSlowFalling = "minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/end_city_treasure";
        public static String ringLocationStrength = "minecraft:chests/stronghold_library;minecraft:chests/stronghold_corridor;minecraft:chests/stronghold_crossing;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge;minecraft:chests/pillager_outpost";
        public static String ringLocationWaterBreathing = "minecraft:chests/spawn_bonus_chest;minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small;minecraft:chests/buried_treasure";
        public static String ringLocationSpeed = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure";
        public static String ringLocationNightVision = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/abandoned_mineshaft";
        public static String ringLocationJumpBoost = "minecraft:chests/end_city_treasure;minecraft:chests/igloo_chest;minecraft:chests/desert_pyramid";
        public static String ringLocationMining = "minecraft:chests/simple_dungeon;minecraft:chests/abandoned_mineshaft";
        public static String ringLocationLuck = "minecraft:chests/simple_dungeon;minecraft:chests/jungle_temple";
        public static String ringLocationDolphin = "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small;minecraft:chests/buried_treasure";
        public static String ringLocationMagnetism = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/ruined_portal";
        public static String ringLocationFlight = "minecraft:chests/end_city_treasure";
        public static String ringLocationPoisonResistance = "minecraft:chests/jungle_temple;minecraft:chests/end_city_treasure;minecraft:chests/shipwreck_treasure;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge";
        public static String ringLocationHungerless = "minecraft:chests/village/village_butcher;minecraft:chests/end_city_treasure;minecraft:chests/woodland_mansion";
        public static String ringLocationGrowth = "minecraft:chests/jungle_temple";
        public static String ringLocationKnockbackResistance = "minecraft:chests/end_city_treasure;minecraft:chests/bastion_bridge;minecraft:chests/nether_bridge";
        public static String ringLocationHealth = "minecraft:chests/end_city_treasure;minecraft:chests/bastion_treasure;minecraft:chests/stronghold_library";
        public static String ringLocationSponge = "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small";
        public static String ringLocationExperience = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/ruined_portal";
        public static String ringLocationWaterWalking = "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small;minecraft:chests/buried_treasure";
        public static String ringLocationWither = "minecraft:chests/bastion_treasure";
        public static String ringLocationUndying = "minecraft:chests/woodland_mansion";
        public static String ringLocationSlowResistance = "minecraft:chests/end_city_treasure;minecraft:chests/shipwreck_treasure;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge";
    }

}
