package com.focamacho.ringsofascension.init;

import com.focamacho.ringsofascension.item.rings.*;
import com.focamacho.ringsofascension.item.rings.effects.*;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static List<Item> allItems = new ArrayList<>();

    public static Item ringFireResistance = new ItemRingFireResistance(new Item.Properties(), "ring_fire_resistance", "tooltip.ringsofascension.fire_resistance");
    public static Item ringInvisibility = new ItemRingInvisibility(new Item.Properties(), "ring_invisibility", "tooltip.ringsofascension.invisibility");
    public static Item ringRegeneration = new ItemRingRegeneration(new Item.Properties(), "ring_regeneration", "tooltip.ringsofascension.regeneration");
    public static Item ringSlowFalling = new ItemRingSlowFalling(new Item.Properties(), "ring_slow_falling", "tooltip.ringsofascension.slow_falling");
    public static Item ringStrength = new ItemRingStrength(new Item.Properties(), "ring_strength", "tooltip.ringsofascension.strength");
    public static Item ringWaterBreathing = new ItemRingWaterBreathing(new Item.Properties(), "ring_water_breathing", "tooltip.ringsofascension.water_breathing");
    public static Item ringSpeed = new ItemRingSpeed(new Item.Properties(), "ring_speed", "tooltip.ringsofascension.speed");
    public static Item ringNightVision = new ItemRingNightVision(new Item.Properties(), "ring_night_vision", "tooltip.ringsofascension.night_vision");
    public static Item ringJumpBoost = new ItemRingJumpBoost(new Item.Properties(), "ring_jump_boost", "tooltip.ringsofascension.jump_boost");
    public static Item ringMining = new ItemRingMining(new Item.Properties(), "ring_mining", "tooltip.ringsofascension.mining");
    public static Item ringLuck = new ItemRingLuck(new Item.Properties(), "ring_luck", "tooltip.ringsofascension.luck");
    public static Item ringDolphin = new ItemRingDolphin(new Item.Properties(), "ring_dolphin", "tooltip.ringsofascension.dolphin");
    public static Item ringMagnetism = new ItemRingMagnet(new Item.Properties(), "ring_magnetism", "tooltip.ringsofascension.magnetism");
    public static Item ringFlight = new ItemRingFlight(new Item.Properties(), "ring_flight", "tooltip.ringsofascension.flight");
    public static Item ringPoisonResistance = new ItemRingPoisonResistance(new Item.Properties(), "ring_poison_resistance", "tooltip.ringsofascension.poison_resistance");
    public static Item ringHungerless = new ItemRingHungerless(new Item.Properties(), "ring_hungerless", "tooltip.ringsofascension.hungerless");
    public static Item ringGrowth = new ItemRingGrowth(new Item.Properties(), "ring_growth", "tooltip.ringsofascension.growth");
    public static Item ringKnockbackResistance = new ItemRingKnockbackResistance(new Item.Properties(), "ring_knockback_resistance", null);
    public static Item ringHealth = new ItemRingHealth(new Item.Properties(), "ring_health", null);
    public static Item ringSponge = new ItemRingSponge(new Item.Properties(), "ring_sponge", "tooltip.ringsofascension.sponge");
    public static Item ringExperience = new ItemRingExperience(new Item.Properties(), "ring_experience", "tooltip.ringsofascension.experience");
    public static Item ringWaterWalking = new ItemRingWaterWalking(new Item.Properties(), "ring_water_walking", "tooltip.ringsofascension.water_walking");
    public static Item ringWither = new ItemRingWither(new Item.Properties(), "ring_wither", "tooltip.ringsofascension.wither");
    public static Item ringUndying = new ItemRingUndying(new Item.Properties(), "ring_undying", "tooltip.ringsofascension.undying");
    public static Item ringSlowResistance = new ItemRingSlowResistance(new Item.Properties(), "ring_slow_resistance", "tooltip.ringsofascension.slow_resistance");

}
