package com.focamacho.ringsofascension.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "ringsofascension")
public class ConfigRingsOfAscension implements ConfigData {

    @Comment("General configs")
    @ConfigEntry.Gui.CollapsibleObject
    public RingsOfAscension general = new RingsOfAscension();

    @Comment("Enable/Disable Rings")
    @ConfigEntry.Gui.CollapsibleObject
    public EnableRings enableRings = new EnableRings();

    @Comment("Sets the amplifier of the effect given by the ring. Example: 0 = Fire Resistance I; 1 = Fire Resistance II")
    @ConfigEntry.Gui.CollapsibleObject
    public Amplifiers amplifiers = new Amplifiers();

    @Comment("Sets the Tier of the rings. Higher tier rings are more difficult to find. 0 = Common; 1 = Rare; 2 = Epic; 3 = Legendary; 4 = Mythic")
    @ConfigEntry.Gui.CollapsibleObject
    public Tiers tiers = new Tiers();

    @Comment("Rings Loot")
    @ConfigEntry.Gui.CollapsibleObject
    public LootConfig loot = new LootConfig();

    @Comment("Loot Tables containing the Rings. You can edit it easier on the config file instead of the gui.")
    @ConfigEntry.Gui.CollapsibleObject
    public LootLocations lootLocations = new LootLocations();

    public class RingsOfAscension {
        @Comment("The cooldown in seconds of the Ring of Undying")
        public int ringUndyingCooldown = 600;

        @Comment("The amount of hearts that Ring of Max Health gives you.")
        public int ringHealthHearts = 10;
    }

    public class EnableRings {
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

    public class Amplifiers {
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierFireResistance = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierInvisibility = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierRegeneration = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierSlowFalling = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierStrength = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierWaterBreathing = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierSpeed = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierNightVision = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierJumpBoost = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierMining = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierLuck = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
        public int ringAmplifierDolphin = 0;
    }

    public class Tiers {
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierFireResistance = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierInvisibility = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierRegeneration = 3;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierSlowFalling = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierStrength = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierWaterBreathing = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierSpeed = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierNightVision = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierJumpBoost = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierMining = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierLuck = 3;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierDolphin = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierMagnetism = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierFlight = 4;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierPoisonResistance = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierHungerless = 3;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierGrowth = 2;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierKnockbackResistance = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierHealth = 3;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierSponge = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierExperience = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierWaterWalking = 0;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierWither = 1;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierUndying = 4;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
        public int ringTierSlowResistance = 1;
    }

    public class LootConfig {
        @Comment("The minimum number of rings that can be found inside a single chest. Values below 0 decrease the chance of the rings appearing.")
        public int ringMinLoot = -5;
        @Comment("The maximum number of rings that can be found inside a single chest.")
        public int ringMaxLoot = 1;
    }

    public class LootLocations {
        public String ringLocationFireResistance = "minecraft:chests/nether_bridge;minecraft:chests/ruined_portal;minecraft:chests/bastion_treasure";
        public String ringLocationInvisibility = "minecraft:chests/abandoned_mineshaft;minecraft:chests/buried_treasure";
        public String ringLocationRegeneration = "minecraft:chests/stronghold_corridor;minecraft:chests/stronghold_library";
        public String ringLocationSlowFalling = "minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/end_city_treasure";
        public String ringLocationStrength = "minecraft:chests/stronghold_library;minecraft:chests/stronghold_corridor;minecraft:chests/stronghold_crossing;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge;minecraft:chests/pillager_outpost";
        public String ringLocationWaterBreathing = "minecraft:chests/spawn_bonus_chest;minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small;minecraft:chests/buried_treasure";
        public String ringLocationSpeed = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure";
        public String ringLocationNightVision = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/abandoned_mineshaft";
        public String ringLocationJumpBoost = "minecraft:chests/end_city_treasure;minecraft:chests/igloo_chest;minecraft:chests/desert_pyramid";
        public String ringLocationMining = "minecraft:chests/simple_dungeon;minecraft:chests/abandoned_mineshaft";
        public String ringLocationLuck = "minecraft:chests/simple_dungeon;minecraft:chests/jungle_temple";
        public String ringLocationDolphin = "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small;minecraft:chests/buried_treasure";
        public String ringLocationMagnetism = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/ruined_portal";
        public String ringLocationFlight = "minecraft:chests/end_city_treasure";
        public String ringLocationPoisonResistance = "minecraft:chests/jungle_temple;minecraft:chests/end_city_treasure;minecraft:chests/shipwreck_treasure;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge";
        public String ringLocationHungerless = "minecraft:chests/village/village_butcher;minecraft:chests/end_city_treasure;minecraft:chests/woodland_mansion";
        public String ringLocationGrowth = "minecraft:chests/jungle_temple";
        public String ringLocationKnockbackResistance = "minecraft:chests/end_city_treasure;minecraft:chests/bastion_bridge;minecraft:chests/nether_bridge";
        public String ringLocationHealth = "minecraft:chests/end_city_treasure;minecraft:chests/bastion_treasure;minecraft:chests/stronghold_library";
        public String ringLocationSponge = "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small";
        public String ringLocationExperience = "minecraft:chests/spawn_bonus_chest;minecraft:chests/simple_dungeon;minecraft:chests/buried_treasure;minecraft:chests/ruined_portal";
        public String ringLocationWaterWalking = "minecraft:chests/underwater_ruin_big;minecraft:chests/underwater_run_small;minecraft:chests/buried_treasure";
        public String ringLocationWither = "minecraft:chests/bastion_treasure";
        public String ringLocationUndying = "minecraft:chests/woodland_mansion";
        public String ringLocationSlowResistance = "minecraft:chests/end_city_treasure;minecraft:chests/shipwreck_treasure;minecraft:chests/bastion_treasure;minecraft:chests/bastion_bridge";
    }

}
