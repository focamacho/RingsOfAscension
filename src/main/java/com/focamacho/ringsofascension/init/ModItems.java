package com.focamacho.ringsofascension.init;

import com.focamacho.ringsofascension.item.ItemRingBase;
import com.focamacho.ringsofascension.item.rings.*;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static List<Item> allItems = new ArrayList<>();

    public static Item ringFireResistance = new ItemRingEffect(new Item.Properties(), "ring_fire_resistance", Effects.FIRE_RESISTANCE, 20, 0, "tooltip.ringsofascension.fire_resistance");
    public static Item ringInvisibility = new ItemRingEffect(new Item.Properties(), "ring_invisibility", Effects.INVISIBILITY, 20, 0, "tooltip.ringsofascension.invisibility");
    public static Item ringRegeneration = new ItemRingEffect(new Item.Properties(), "ring_regeneration", Effects.REGENERATION, 20, 0, "tooltip.ringsofascension.regeneration");
    public static Item ringSlowFalling = new ItemRingEffect(new Item.Properties(), "ring_slow_falling", Effects.SLOW_FALLING, 20, 0, "tooltip.ringsofascension.slow_falling");
    public static Item ringStrength = new ItemRingEffect(new Item.Properties(), "ring_strength", Effects.STRENGTH, 20, 0, "tooltip.ringsofascension.strength");
    public static Item ringWaterBreathing = new ItemRingEffect(new Item.Properties(), "ring_water_breathing", Effects.WATER_BREATHING, 20, 0, "tooltip.ringsofascension.water_breathing");
    public static Item ringSpeed = new ItemRingEffect(new Item.Properties(), "ring_speed", Effects.SPEED, 20, 0, "tooltip.ringsofascension.speed");
    public static Item ringNightVision = new ItemRingEffect(new Item.Properties(), "ring_night_vision", Effects.NIGHT_VISION, 20, 0, "tooltip.ringsofascension.night_vision");
    public static Item ringJumpBoost = new ItemRingEffect(new Item.Properties(), "ring_jump_boost", Effects.JUMP_BOOST, 20, 0, "tooltip.ringsofascension.jump_boost");
    public static Item ringMining = new ItemRingEffect(new Item.Properties(), "ring_mining", Effects.HASTE, 20, 0, "tooltip.ringsofascension.mining");
    public static Item ringLuck = new ItemRingEffect(new Item.Properties(), "ring_luck", Effects.LUCK, 20, 0, "tooltip.ringsofascension.luck");
    public static Item ringDolphin = new ItemRingEffect(new Item.Properties(), "ring_dolphin", Effects.DOLPHINS_GRACE, 20, 0, "tooltip.ringsofascension.dolphin");

    public static Item ringMagnetism = new ItemRingMagnet(new Item.Properties(), "ring_magnetism", "tooltip.ringsofascension.magnetism");
    public static Item ringFlight = new ItemRingFlight(new Item.Properties(), "ring_flight", "tooltip.ringsofascension.flight");
    public static Item ringPoisonResistance = new ItemRingPoisonResistance(new Item.Properties(), "ring_poison_resistance", "tooltip.ringsofascension.poison_resistance");
    public static Item ringHungerless = new ItemRingHungerless(new Item.Properties(), "ring_hungerless", "tooltip.ringsofascension.hungerless");
    public static Item ringGrowth = new ItemRingGrowth(new Item.Properties(), "ring_growth", "tooltip.ringsofascension.growth");
    public static Item ringKnockbackResistance = new ItemRingKnockbackResistance(new Item.Properties(), "ring_knockback_resistance", null);
    public static Item ringHealth = new ItemRingHealth(new Item.Properties(), "ring_health", 20, null);
    public static Item ringSponge = new ItemRingSponge(new Item.Properties(), "ring_sponge", "tooltip.ringsofascension.sponge");
    public static Item ringExperience = new ItemRingExperience(new Item.Properties(), "ring_experience", "tooltip.ringsofascension.experience");
    public static Item ringWaterWalking = new ItemRingWaterWalking(new Item.Properties(), "ring_water_walking", "tooltip.ringsofascension.water_walking");
    public static Item ringWither = new ItemRingWither(new Item.Properties(), "ring_wither", "tooltip.ringsofascension.wither");
    public static Item ringUndying = new ItemRingUndying(new Item.Properties(), "ring_undying", "tooltip.ringsofascension.undying");
    public static Item ringSlowResistance = new ItemRingSlowResistance(new Item.Properties(), "ring_slow_resistance", "tooltip.ringsofascension.slow_resistance");

}
