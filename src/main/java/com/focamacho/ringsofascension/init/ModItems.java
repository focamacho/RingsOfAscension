package com.focamacho.ringsofascension.init;

import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.focamacho.ringsofascension.item.rings.*;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static List<ItemRingBase> allRings = new ArrayList<>();

    public static ConfigRingsOfAscension config = AutoConfig.getConfigHolder(ConfigRingsOfAscension.class).getConfig();

    public static final ItemRingBase ringFireResistance = new ItemRingEffect("ring_fire_resistance", config.tiers.ringTierFireResistance, StatusEffects.FIRE_RESISTANCE, config.amplifiers.ringAmplifierFireResistance, "tooltip.ringsofascension.fire_resistance", config.enableRings.ringFireResistance, config.lootLocations.ringLocationFireResistance);
    public static final ItemRingBase ringDolphin = new ItemRingEffect("ring_dolphin", config.tiers.ringTierDolphin, StatusEffects.DOLPHINS_GRACE, config.amplifiers.ringAmplifierDolphin, "tooltip.ringsofascension.dolphin", config.enableRings.ringDolphin, config.lootLocations.ringLocationDolphin);
    public static final ItemRingBase ringInvisibility = new ItemRingEffect("ring_invisibility", config.tiers.ringTierInvisibility, StatusEffects.INVISIBILITY, config.amplifiers.ringAmplifierInvisibility, "tooltip.ringsofascension.invisibility", config.enableRings.ringInvisibility, config.lootLocations.ringLocationInvisibility);
    public static final ItemRingBase ringJumpBoost = new ItemRingEffect("ring_jump_boost", config.tiers.ringTierJumpBoost, StatusEffects.JUMP_BOOST, config.amplifiers.ringAmplifierJumpBoost, "tooltip.ringsofascension.jump_boost", config.enableRings.ringJumpBoost, config.lootLocations.ringLocationJumpBoost);
    public static final ItemRingBase ringLuck = new ItemRingEffect("ring_luck", config.tiers.ringTierLuck, StatusEffects.LUCK, config.amplifiers.ringAmplifierLuck, "tooltip.ringsofascension.luck", config.enableRings.ringLuck, config.lootLocations.ringLocationLuck);
    public static final ItemRingBase ringMining = new ItemRingEffect("ring_mining", config.tiers.ringTierMining, StatusEffects.HASTE, config.amplifiers.ringAmplifierMining, "tooltip.ringsofascension.mining", config.enableRings.ringMining, config.lootLocations.ringLocationMining);
    public static final ItemRingBase ringNightVision = new ItemRingEffect("ring_night_vision", config.tiers.ringTierNightVision, StatusEffects.NIGHT_VISION, config.amplifiers.ringAmplifierNightVision, "tooltip.ringsofascension.night_vision", config.enableRings.ringNightVision, config.lootLocations.ringLocationNightVision);
    public static final ItemRingBase ringRegeneration = new ItemRingEffect("ring_regeneration", config.tiers.ringTierRegeneration, StatusEffects.REGENERATION, config.amplifiers.ringAmplifierRegeneration, "tooltip.ringsofascension.regeneration", config.enableRings.ringRegeneration, config.lootLocations.ringLocationRegeneration);
    public static final ItemRingBase ringSlowFalling = new ItemRingEffect("ring_slow_falling", config.tiers.ringTierSlowFalling, StatusEffects.SLOW_FALLING, config.amplifiers.ringAmplifierSlowFalling, "tooltip.ringsofascension.slow_falling", config.enableRings.ringSlowFalling, config.lootLocations.ringLocationSlowFalling);
    public static final ItemRingBase ringSpeed = new ItemRingEffect("ring_speed", config.tiers.ringTierSpeed, StatusEffects.SPEED, config.amplifiers.ringAmplifierSpeed, "tooltip.ringsofascension.speed", config.enableRings.ringSpeed, config.lootLocations.ringLocationSpeed);
    public static final ItemRingBase ringStrength = new ItemRingEffect("ring_strength", config.tiers.ringTierStrength, StatusEffects.STRENGTH, config.amplifiers.ringAmplifierStrength, "tooltip.ringsofascension.strength", config.enableRings.ringStrength, config.lootLocations.ringLocationStrength);
    public static final ItemRingBase ringWaterBreathing = new ItemRingEffect("ring_water_breathing", config.tiers.ringTierWaterBreathing, StatusEffects.WATER_BREATHING, config.amplifiers.ringAmplifierWaterBreathing, "tooltip.ringsofascension.water_breathing", config.enableRings.ringWaterBreathing, config.lootLocations.ringLocationWaterBreathing);

    public static final ItemRingBase ringSlowResistance = new ItemRingEffectResistance("ring_slow_resistance", config.tiers.ringTierSlowResistance, StatusEffects.SLOWNESS, "tooltip.ringsofascension.slow_resistance", config.enableRings.ringSlowResistance, config.lootLocations.ringLocationSlowResistance);
    public static final ItemRingBase ringPoisonResistance = new ItemRingEffectResistance("ring_poison_resistance", config.tiers.ringTierPoisonResistance, StatusEffects.POISON, "tooltip.ringsofascension.poison_resistance", config.enableRings.ringPoisonResistance, config.lootLocations.ringLocationPoisonResistance);
    public static final ItemRingBase ringWither = new ItemRingEffectResistance("ring_wither", config.tiers.ringTierWither, StatusEffects.WITHER, "tooltip.ringsofascension.wither", config.enableRings.ringWither, config.lootLocations.ringLocationWither);

    public static final ItemRingBase ringMagnetism = new ItemRingMagnetism("ring_magnetism", config.tiers.ringTierMagnetism, "tooltip.ringsofascension.magnetism", config.enableRings.ringMagnetism, config.lootLocations.ringLocationMagnetism);
    public static final ItemRingBase ringFlight = new ItemRingFlight("ring_flight", config.tiers.ringTierFlight, "tooltip.ringsofascension.flight", config.enableRings.ringFlight, config.lootLocations.ringLocationFlight);
    public static final ItemRingBase ringHungerless = new ItemRingHungerless("ring_hungerless", config.tiers.ringTierHungerless, "tooltip.ringsofascension.hungerless", config.enableRings.ringHungerless, config.lootLocations.ringLocationHungerless);
    public static final ItemRingBase ringExperience = new ItemRingExperience("ring_experience", config.tiers.ringTierExperience, "tooltip.ringsofascension.experience", config.enableRings.ringExperience, config.lootLocations.ringLocationExperience);
    public static final ItemRingBase ringGrowth = new ItemRingGrowth("ring_growth", config.tiers.ringTierGrowth, "tooltip.ringsofascension.growth", config.enableRings.ringGrowth, config.lootLocations.ringLocationGrowth);
    public static final ItemRingBase ringKnockbackResistance = new ItemRingKnockbackResistance("ring_knockback_resistance", config.tiers.ringTierKnockbackResistance, null, config.enableRings.ringKnockbackResistance, config.lootLocations.ringLocationKnockbackResistance);
    public static final ItemRingBase ringHealth = new ItemRingHealth("ring_health", config.tiers.ringTierHealth, null, config.enableRings.ringHealth, config.lootLocations.ringLocationHealth);
    public static final ItemRingBase ringSponge = new ItemRingSponge("ring_sponge", config.tiers.ringTierSponge, "tooltip.ringsofascension.sponge", config.enableRings.ringSponge, config.lootLocations.ringLocationSponge);
    public static final ItemRingBase ringWaterWalking = new ItemRingWaterWalking("ring_water_walking", config.tiers.ringTierWaterWalking, "tooltip.ringsofascension.water_walking", config.enableRings.ringWaterWalking, config.lootLocations.ringLocationWaterWalking);
    public static final ItemRingBase ringUndying = new ItemRingUndying("ring_undying", config.tiers.ringTierUndying, "tooltip.ringsofascension.undying", config.enableRings.ringUndying, config.lootLocations.ringLocationUndying);

    public static void init() {
        allRings.forEach(ModItems::registerRing);
    }

    public static void registerRing(ItemRingBase ring) {
        Registry.register(Registry.ITEM, new Identifier("ringsofascension", ring.getRingName()), ring);
    }

}
