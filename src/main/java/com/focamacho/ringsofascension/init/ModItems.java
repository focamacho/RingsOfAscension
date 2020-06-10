package com.focamacho.ringsofascension.init;

import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.focamacho.ringsofascension.item.rings.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static List<ItemRingBase> allRings = new ArrayList<>();

    public static final ItemRingBase ringFireResistance = new ItemRingEffect("ring_fire_resistance", ConfigRingsOfAscension.ringTierFireResistance, StatusEffects.FIRE_RESISTANCE, ConfigRingsOfAscension.ringAmplifierFireResistance, "tooltip.ringsofascension.fire_resistance", ConfigRingsOfAscension.ringFireResistance);
    public static final ItemRingBase ringDolphin = new ItemRingEffect("ring_dolphin", ConfigRingsOfAscension.ringTierDolphin, StatusEffects.DOLPHINS_GRACE, ConfigRingsOfAscension.ringAmplifierDolphin, "tooltip.ringsofascension.dolphin", ConfigRingsOfAscension.ringDolphin);
    public static final ItemRingBase ringInvisibility = new ItemRingEffect("ring_invisibility", ConfigRingsOfAscension.ringTierInvisibility, StatusEffects.INVISIBILITY, ConfigRingsOfAscension.ringAmplifierInvisibility, "tooltip.ringsofascension.invisibility", ConfigRingsOfAscension.ringInvisibility);
    public static final ItemRingBase ringJumpBoost = new ItemRingEffect("ring_jump_boost", ConfigRingsOfAscension.ringTierJumpBoost, StatusEffects.JUMP_BOOST, ConfigRingsOfAscension.ringAmplifierJumpBoost, "tooltip.ringsofascension.jump_boost", ConfigRingsOfAscension.ringJumpBoost);
    public static final ItemRingBase ringLuck = new ItemRingEffect("ring_luck", ConfigRingsOfAscension.ringTierLuck, StatusEffects.LUCK, ConfigRingsOfAscension.ringAmplifierLuck, "tooltip.ringsofascension.luck", ConfigRingsOfAscension.ringLuck);
    public static final ItemRingBase ringMining = new ItemRingEffect("ring_mining", ConfigRingsOfAscension.ringTierMining, StatusEffects.HASTE, ConfigRingsOfAscension.ringAmplifierMining, "tooltip.ringsofascension.mining", ConfigRingsOfAscension.ringMining);
    public static final ItemRingBase ringNightVision = new ItemRingEffect("ring_night_vision", ConfigRingsOfAscension.ringTierNightVision, StatusEffects.NIGHT_VISION, ConfigRingsOfAscension.ringAmplifierNightVision, "tooltip.ringsofascension.night_vision", ConfigRingsOfAscension.ringNightVision);
    public static final ItemRingBase ringRegeneration = new ItemRingEffect("ring_regeneration", ConfigRingsOfAscension.ringTierRegeneration, StatusEffects.REGENERATION, ConfigRingsOfAscension.ringAmplifierRegeneration, "tooltip.ringsofascension.regeneration", ConfigRingsOfAscension.ringRegeneration);
    public static final ItemRingBase ringSlowFalling = new ItemRingEffect("ring_slow_falling", ConfigRingsOfAscension.ringTierSlowFalling, StatusEffects.SLOW_FALLING, ConfigRingsOfAscension.ringAmplifierSlowFalling, "tooltip.ringsofascension.slow_falling", ConfigRingsOfAscension.ringSlowFalling);
    public static final ItemRingBase ringSpeed = new ItemRingEffect("ring_speed", ConfigRingsOfAscension.ringTierSpeed, StatusEffects.SPEED, ConfigRingsOfAscension.ringAmplifierSpeed, "tooltip.ringsofascension.speed", ConfigRingsOfAscension.ringSpeed);
    public static final ItemRingBase ringStrength = new ItemRingEffect("ring_strength", ConfigRingsOfAscension.ringTierStrength, StatusEffects.STRENGTH, ConfigRingsOfAscension.ringAmplifierStrength, "tooltip.ringsofascension.strength", ConfigRingsOfAscension.ringStrength);
    public static final ItemRingBase ringWaterBreathing = new ItemRingEffect("ring_water_breathing", ConfigRingsOfAscension.ringTierWaterBreathing, StatusEffects.WATER_BREATHING, ConfigRingsOfAscension.ringAmplifierWaterBreathing, "tooltip.ringsofascension.water_breathing", ConfigRingsOfAscension.ringWaterBreathing);

    public static final ItemRingBase ringSlowResistance = new ItemRingEffectResistance("ring_slow_resistance", ConfigRingsOfAscension.ringTierSlowResistance, StatusEffects.SLOWNESS, "tooltip.ringsofascension.slow_resistance", ConfigRingsOfAscension.ringSlowResistance);
    public static final ItemRingBase ringPoisonResistance = new ItemRingEffectResistance("ring_poison_resistance", ConfigRingsOfAscension.ringTierPoisonResistance, StatusEffects.POISON, "tooltip.ringsofascension.poison_resistance", ConfigRingsOfAscension.ringPoisonResistance);
    public static final ItemRingBase ringWither = new ItemRingEffectResistance("ring_wither", ConfigRingsOfAscension.ringTierWither, StatusEffects.WITHER, "tooltip.ringsofascension.wither", ConfigRingsOfAscension.ringWither);

    public static final ItemRingBase ringMagnetism = new ItemRingMagnetism("ring_magnetism", ConfigRingsOfAscension.ringTierMagnetism, "tooltip.ringsofascension.magnetism", ConfigRingsOfAscension.ringMagnetism);
    public static final ItemRingBase ringFlight = new ItemRingFlight("ring_flight", ConfigRingsOfAscension.ringTierFlight, "tooltip.ringsofascension.flight", ConfigRingsOfAscension.ringFlight);
    public static final ItemRingBase ringHungerless = new ItemRingHungerless("ring_hungerless", ConfigRingsOfAscension.ringTierHungerless, "tooltip.ringsofascension.hungerless", ConfigRingsOfAscension.ringHungerless);
    public static final ItemRingBase ringExperience = new ItemRingExperience("ring_experience", ConfigRingsOfAscension.ringTierExperience, "tooltip.ringsofascension.experience", ConfigRingsOfAscension.ringExperience);
    public static final ItemRingBase ringGrowth = new ItemRingGrowth("ring_growth", ConfigRingsOfAscension.ringTierGrowth, "tooltip.ringsofascension.growth", ConfigRingsOfAscension.ringGrowth);
    public static final ItemRingBase ringKnockbackResistance = new ItemRingKnockbackResistance("ring_knockback_resistance", ConfigRingsOfAscension.ringTierKnockbackResistance, null, ConfigRingsOfAscension.ringKnockbackResistance);
    public static final ItemRingBase ringHealth = new ItemRingHealth("ring_health", ConfigRingsOfAscension.ringTierHealth, null, ConfigRingsOfAscension.ringHealth);
    public static final ItemRingBase ringSponge = new ItemRingSponge("ring_sponge", ConfigRingsOfAscension.ringTierSponge, "tooltip.ringsofascension.sponge", ConfigRingsOfAscension.ringSponge);
    public static final ItemRingBase ringWaterWalking = new ItemRingWaterWalking("ring_water_walking", ConfigRingsOfAscension.ringTierWaterWalking, "tooltip.ringsofascension.water_walking", ConfigRingsOfAscension.ringWaterWalking);
    public static final ItemRingBase ringUndying = new ItemRingUndying("ring_undying", ConfigRingsOfAscension.ringTierUndying, "tooltip.ringsofascension.undying", ConfigRingsOfAscension.ringUndying);

    public static void init() {
        allRings.forEach(ModItems::registerRing);
    }

    public static void registerRing(ItemRingBase ring) {
        Registry.register(Registry.ITEM, new Identifier("ringsofascension", ring.getRingName()), ring);
    }

}
