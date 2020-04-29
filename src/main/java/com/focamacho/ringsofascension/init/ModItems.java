package com.focamacho.ringsofascension.init;

import com.focamacho.ringsofascension.item.rings.*;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static List<Item> allItems = new ArrayList<>();

    public static Item ringFireResistance = new ItemRingEffect(new Item.Properties(), "ring_fire_resistance", Effects.FIRE_RESISTANCE, 20, 0);
    public static Item ringInvisibility = new ItemRingEffect(new Item.Properties(), "ring_invisibility", Effects.INVISIBILITY, 20, 0);
    public static Item ringRegeneration = new ItemRingEffect(new Item.Properties(), "ring_regeneration", Effects.REGENERATION, 20, 0);
    public static Item ringSlowFalling = new ItemRingEffect(new Item.Properties(), "ring_slow_falling", Effects.SLOW_FALLING, 20, 0);
    public static Item ringStrength = new ItemRingEffect(new Item.Properties(), "ring_strength", Effects.STRENGTH, 20, 0);
    public static Item ringWaterBreathing = new ItemRingEffect(new Item.Properties(), "ring_water_breathing", Effects.WATER_BREATHING, 20, 0);
    public static Item ringSpeed = new ItemRingEffect(new Item.Properties(), "ring_speed", Effects.SPEED, 20, 0);
    public static Item ringNightVision = new ItemRingEffect(new Item.Properties(), "ring_night_vision", Effects.NIGHT_VISION, 20, 0);
    public static Item ringJumpBoost = new ItemRingEffect(new Item.Properties(), "ring_jump_boost", Effects.JUMP_BOOST, 20, 0);
    public static Item ringMining = new ItemRingEffect(new Item.Properties(), "ring_mining", Effects.HASTE, 20, 0);
    public static Item ringLuck = new ItemRingEffect(new Item.Properties(), "ring_luck", Effects.LUCK, 20, 0);

    public static Item ringMagnetism = new ItemRingMagnet(new Item.Properties(), "ring_magnetism");
    public static Item ringFlight = new ItemRingFlight(new Item.Properties(), "ring_flight");
    public static Item ringPoisonResistance = new ItemRingPoisonResistance(new Item.Properties(), "ring_poison_resistance");
    public static Item ringHungerless = new ItemRingHungerless(new Item.Properties(), "ring_hungerless");
    public static Item ringGrowth = new ItemRingGrowth(new Item.Properties(), "ring_growth");
    public static Item ringKnockbackResistance = new ItemRingKnockbackResistance(new Item.Properties(), "ring_knockback_resistance");
    public static Item ringHealth = new ItemRingHealth(new Item.Properties(), "ring_health", 20);
    public static Item ringSponge = new ItemRingSponge(new Item.Properties(), "ring_sponge");
    public static Item ringExperience = new ItemRingExperience(new Item.Properties(), "ring_experience");
    public static Item ringWaterWalking = new ItemRingWaterWalking(new Item.Properties(), "ring_water_walking");
    public static Item ringWither = new ItemRingWither(new Item.Properties(), "ring_wither");

}
