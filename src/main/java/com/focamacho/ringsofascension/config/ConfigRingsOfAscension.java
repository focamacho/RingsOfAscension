package com.focamacho.ringsofascension.config;

import com.focamacho.sealconfig.relocated.blue.endless.jankson.api.annotation.Comment;

public class ConfigRingsOfAscension {

    @Comment("General configs")
    public RingsOfAscension general = new RingsOfAscension();

    @Comment("Enable/Disable Rings")
    public EnableRings enableRings = new EnableRings();

    @Comment("Sets the amplifier of the effect given by the ring. Example: 0 = Fire Resistance I; 1 = Fire Resistance II")
    public Amplifiers amplifiers = new Amplifiers();

    @Comment("Sets the Tier of the rings. Higher tier rings are more difficult to find. 0 = Common; 1 = Rare; 2 = Epic; 3 = Legendary; 4 = Mythic")
    public Tiers tiers = new Tiers();

    @Comment("Rings Loot")
    public LootConfig loot = new LootConfig();

    @Comment("Loot Tables containing the Rings.")
    public LootLocations lootLocations = new LootLocations();

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
        public boolean ringExperience = true;
        public boolean ringWaterWalking = true;
        public boolean ringWither = true;
        public boolean ringUndying = true;
        public boolean ringSlowResistance = true;
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

    public static class Tiers {
        public int ringTierFireResistance = 0;
        public int ringTierInvisibility = 1;
        public int ringTierRegeneration = 3;
        public int ringTierSlowFalling = 0;
        public int ringTierStrength = 2;
        public int ringTierWaterBreathing = 0;
        public int ringTierSpeed = 1;
        public int ringTierNightVision = 0;
        public int ringTierJumpBoost = 0;
        public int ringTierMining = 2;
        public int ringTierLuck = 3;
        public int ringTierDolphin = 1;
        public int ringTierMagnetism = 2;
        public int ringTierFlight = 4;
        public int ringTierPoisonResistance = 2;
        public int ringTierHungerless = 3;
        public int ringTierGrowth = 2;
        public int ringTierKnockbackResistance = 0;
        public int ringTierHealth = 3;
        public int ringTierSponge = 1;
        public int ringTierExperience = 0;
        public int ringTierWaterWalking = 0;
        public int ringTierWither = 1;
        public int ringTierUndying = 4;
        public int ringTierSlowResistance = 1;
    }

    public static class LootConfig {
        @Comment("The minimum number of rings that can be found inside a single chest. Values below 0 decrease the chance of the rings appearing.")
        public int ringMinLoot = -5;
        @Comment("The maximum number of rings that can be found inside a single chest.")
        public int ringMaxLoot = 1;
    }

    public static class LootLocations {
        public String ringLocationFireResistance = "minecraft:chests/nether_bridge;minecraft:chests/ruined_portal;minecraft:chests/bastion_treasure";
        public String ringLocationInvisibility = "minecraft:chests/abandoned_mineshaft;minecraft:chests/buried_treasure";
        public String ringLocationRegeneration = "minecraft:chests/stronghold_corridor;minecraft:chests/stronghold_library";
        public String ringLocationSlowFalling = "minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/end_city_treasure";
        public String ringLocationStrength = "minecraft:chests/stronghold_library;minecraft:chests/stronghold_corridor;minecraft:chests/stronghold_crossing;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge;minecraft:chests/pillager_outpost";
        public String ringLocationWaterBreathing = "minecraft:chests/spawn_bonus_chest;minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_ruin_small;minecraft:chests/buried_treasure";
        public String ringLocationSpeed = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure";
        public String ringLocationNightVision = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/abandoned_mineshaft";
        public String ringLocationJumpBoost = "minecraft:chests/end_city_treasure;minecraft:chests/igloo_chest;minecraft:chests/desert_pyramid";
        public String ringLocationMining = "minecraft:chests/simple_dungeon;minecraft:chests/abandoned_mineshaft";
        public String ringLocationLuck = "minecraft:chests/simple_dungeon;minecraft:chests/jungle_temple";
        public String ringLocationDolphin = "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_ruin_small;minecraft:chests/buried_treasure";
        public String ringLocationMagnetism = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/ruined_portal";
        public String ringLocationFlight = "minecraft:chests/end_city_treasure";
        public String ringLocationPoisonResistance = "minecraft:chests/jungle_temple;minecraft:chests/end_city_treasure;minecraft:chests/shipwreck_treasure;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge";
        public String ringLocationHungerless = "minecraft:chests/village/village_butcher;minecraft:chests/end_city_treasure;minecraft:chests/woodland_mansion";
        public String ringLocationGrowth = "minecraft:chests/jungle_temple";
        public String ringLocationKnockbackResistance = "minecraft:chests/end_city_treasure;minecraft:chests/bastion_bridge;minecraft:chests/nether_bridge";
        public String ringLocationHealth = "minecraft:chests/end_city_treasure;minecraft:chests/bastion_treasure;minecraft:chests/stronghold_library";
        public String ringLocationSponge = "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_ruin_small";
        public String ringLocationExperience = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/ruined_portal";
        public String ringLocationWaterWalking = "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_ruin_small;minecraft:chests/buried_treasure";
        public String ringLocationWither = "minecraft:chests/bastion_treasure";
        public String ringLocationUndying = "minecraft:chests/woodland_mansion";
        public String ringLocationSlowResistance = "minecraft:chests/end_city_treasure;minecraft:chests/shipwreck_treasure;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge";
    }

}
