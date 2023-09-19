package com.focamacho.ringsofascension.init;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.focamacho.ringsofascension.item.rings.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static com.focamacho.ringsofascension.RingsOfAscension.MODID;
import static com.focamacho.ringsofascension.RingsOfAscension.config;

public class ModItems {

    public static List<ItemRingBase> allRings = new ArrayList<>();

    public static final ItemRingBase ringFireResistance = new ItemRingEffect("ring_fire_resistance", StatusEffects.FIRE_RESISTANCE,
            config.amplifiers.ringAmplifierFireResistance, "tooltip.ringsofascension.fire_resistance",
            config.enableRings.ringFireResistance, GlintRenderTypes.ORANGE);

    public static final ItemRingBase ringInvisibility = new ItemRingEffect("ring_invisibility", StatusEffects.INVISIBILITY,
            config.amplifiers.ringAmplifierInvisibility, "tooltip.ringsofascension.invisibility",
            config.enableRings.ringInvisibility, GlintRenderTypes.PURPLE);

    public static final ItemRingBase ringRegeneration = new ItemRingEffect("ring_regeneration", StatusEffects.REGENERATION,
            config.amplifiers.ringAmplifierRegeneration, "tooltip.ringsofascension.regeneration",
            config.enableRings.ringRegeneration, GlintRenderTypes.RED);

    public static final ItemRingBase ringSlowFalling = new ItemRingEffect("ring_slow_falling", StatusEffects.SLOW_FALLING,
            config.amplifiers.ringAmplifierSlowFalling, "tooltip.ringsofascension.slow_falling",
            config.enableRings.ringSlowFalling, GlintRenderTypes.WHITE);

    public static final ItemRingBase ringStrength = new ItemRingEffect("ring_strength", StatusEffects.STRENGTH,
            config.amplifiers.ringAmplifierStrength, "tooltip.ringsofascension.strength",
            config.enableRings.ringStrength, GlintRenderTypes.RED);

    public static final ItemRingBase ringWaterBreathing = new ItemRingEffect("ring_water_breathing", StatusEffects.WATER_BREATHING,
            config.amplifiers.ringAmplifierWaterBreathing, "tooltip.ringsofascension.water_breathing",
            config.enableRings.ringWaterBreathing, GlintRenderTypes.BLUE);

    public static final ItemRingBase ringSpeed = new ItemRingEffect("ring_speed", StatusEffects.SPEED,
            config.amplifiers.ringAmplifierSpeed, "tooltip.ringsofascension.speed",
            config.enableRings.ringSpeed, GlintRenderTypes.LIGHT_BLUE);

    public static final ItemRingBase ringNightVision = new ItemRingEffect("ring_night_vision", StatusEffects.NIGHT_VISION,
            config.amplifiers.ringAmplifierNightVision, "tooltip.ringsofascension.night_vision",
            config.enableRings.ringNightVision, GlintRenderTypes.LIGHT_GRAY);

    public static final ItemRingBase ringJumpBoost = new ItemRingEffect("ring_jump_boost", StatusEffects.JUMP_BOOST,
            config.amplifiers.ringAmplifierJumpBoost, "tooltip.ringsofascension.jump_boost",
            config.enableRings.ringJumpBoost, GlintRenderTypes.LIME);

    public static final ItemRingBase ringMining = new ItemRingEffect("ring_mining", StatusEffects.HASTE,
            config.amplifiers.ringAmplifierMining, "tooltip.ringsofascension.mining",
            config.enableRings.ringMining, GlintRenderTypes.YELLOW);

    public static final ItemRingBase ringLuck = new ItemRingEffect("ring_luck", StatusEffects.LUCK,
            config.amplifiers.ringAmplifierLuck, "tooltip.ringsofascension.luck",
            config.enableRings.ringLuck, GlintRenderTypes.GREEN);

    public static final ItemRingBase ringDolphin = new ItemRingEffect("ring_dolphin", StatusEffects.DOLPHINS_GRACE,
            config.amplifiers.ringAmplifierDolphin, "tooltip.ringsofascension.dolphin",
            config.enableRings.ringDolphin, GlintRenderTypes.LIGHT_GRAY);

    public static final ItemRingBase ringMagnetism = new ItemRingMagnetism("ring_magnetism", "tooltip.ringsofascension.magnetism",
            config.enableRings.ringMagnetism, GlintRenderTypes.LIGHT_GRAY);

    public static final ItemRingBase ringFlight = new ItemRingFlight("ring_flight", "tooltip.ringsofascension.flight",
            config.enableRings.ringFlight, GlintRenderTypes.LIGHT_BLUE);

    public static final ItemRingBase ringPoisonResistance = new ItemRingEffectResistance("ring_poison_resistance", StatusEffects.POISON,
            "tooltip.ringsofascension.poison_resistance", config.enableRings.ringPoisonResistance, GlintRenderTypes.GREEN);

    public static final ItemRingBase ringHungerless = new ItemRingHungerless("ring_hungerless", "tooltip.ringsofascension.hungerless",
            config.enableRings.ringHungerless, GlintRenderTypes.BROWN);

    public static final ItemRingBase ringGrowth = new ItemRingGrowth("ring_growth", "tooltip.ringsofascension.growth",
            config.enableRings.ringGrowth, GlintRenderTypes.GREEN);

    public static final ItemRingBase ringKnockbackResistance = new ItemRingKnockbackResistance("ring_knockback_resistance", null,
            config.enableRings.ringKnockbackResistance, GlintRenderTypes.GRAY);

    public static final ItemRingBase ringHealth = new ItemRingHealth("ring_health", null,
            config.enableRings.ringHealth, GlintRenderTypes.RED);

    public static final ItemRingBase ringSponge = new ItemRingSponge("ring_sponge", "tooltip.ringsofascension.sponge",
            Fluids.WATER, Fluids.FLOWING_WATER, config.enableRings.ringSponge, GlintRenderTypes.YELLOW);

    public static final ItemRingBase ringLavaSponge = new ItemRingSponge("ring_lava_sponge", "tooltip.ringsofascension.lava_sponge",
            Fluids.LAVA, Fluids.FLOWING_LAVA, config.enableRings.ringLavaSponge, GlintRenderTypes.ORANGE);

    public static final ItemRingBase ringExperience = new ItemRingExperience("ring_experience", "tooltip.ringsofascension.experience",
            config.enableRings.ringExperience, GlintRenderTypes.YELLOW);

    public static final ItemRingBase ringWaterWalking = new ItemRingWaterWalking("ring_water_walking", "tooltip.ringsofascension.water_walking",
            config.enableRings.ringWaterWalking, GlintRenderTypes.LIGHT_BLUE);

    public static final ItemRingBase ringWither = new ItemRingEffectResistance("ring_wither", StatusEffects.WITHER,
            "tooltip.ringsofascension.wither", config.enableRings.ringWither, GlintRenderTypes.BLACK);

    public static final ItemRingBase ringUndying = new ItemRingUndying("ring_undying", "tooltip.ringsofascension.undying",
            config.enableRings.ringUndying, GlintRenderTypes.ORANGE);

    public static final ItemRingBase ringSlowResistance = new ItemRingEffectResistance("ring_slow_resistance", StatusEffects.SLOWNESS,
            "tooltip.ringsofascension.slow_resistance", config.enableRings.ringSlowResistance, GlintRenderTypes.GRAY);

    public static final ItemRingBase ringSteadfastSteps = new ItemRingSteadfastSteps("ring_steadfast_steps", "tooltip.ringsofascension.steadfast_steps",
            config.enableRings.ringSteadfastSteps, GlintRenderTypes.BROWN);


    public static void init() {
        allRings.forEach(ModItems::registerRing);
    }

    public static void registerRing(ItemRingBase ring) {
        Registry.register(Registries.ITEM, new Identifier(MODID, ring.getRingName()), ring);
    }

}
