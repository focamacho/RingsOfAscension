package com.focamacho.ringsofascension.init;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.config.Config;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.focamacho.ringsofascension.item.rings.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItems {

    public static List<ItemRingBase> allRings = new ArrayList<>();

    private static final DeferredRegister<Item> register = DeferredRegister.create(Registries.ITEM, RingsOfAscension.MODID);

    public static Supplier<ItemRingBase> ringFireResistance = register("ring_fire_resistance",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.fire_resistance",
                    () -> Config.configRingFireResistance.get(), MobEffects.FIRE_RESISTANCE,
                    () -> Config.configRingAmplifierFireResistance.get(), GlintRenderTypes.ORANGE));

    public static Supplier<ItemRingBase> ringInvisibility = register("ring_invisibility",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.invisibility",
                    () -> Config.configRingInvisibility.get(), MobEffects.INVISIBILITY,
                    () -> Config.configRingAmplifierInvisibility.get(), GlintRenderTypes.PURPLE));

    public static Supplier<ItemRingBase> ringRegeneration = register("ring_regeneration",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.regeneration",
                    () -> Config.configRingRegeneration.get(), MobEffects.REGENERATION,
                    () -> Config.configRingAmplifierRegeneration.get(), GlintRenderTypes.RED));

    public static Supplier<ItemRingBase> ringSlowFalling = register("ring_slow_falling",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.slow_falling",
                    () -> Config.configRingSlowFalling.get(), MobEffects.SLOW_FALLING,
                    () -> Config.configRingAmplifierSlowFalling.get(), GlintRenderTypes.WHITE));

    public static Supplier<ItemRingBase> ringStrength = register("ring_strength",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.strength",
                    () -> Config.configRingStrength.get(), MobEffects.DAMAGE_BOOST,
                    () -> Config.configRingAmplifierStrength.get(), GlintRenderTypes.RED));

    public static Supplier<ItemRingBase> ringWaterBreathing = register("ring_water_breathing",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.water_breathing",
                    () -> Config.configRingWaterBreathing.get(), MobEffects.WATER_BREATHING,
                    () -> Config.configRingAmplifierWaterBreathing.get(), GlintRenderTypes.BLUE));

    public static Supplier<ItemRingBase> ringSpeed = register("ring_speed",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.speed",
                    () -> Config.configRingSpeed.get(), MobEffects.MOVEMENT_SPEED,
                    () -> Config.configRingAmplifierSpeed.get(), GlintRenderTypes.LIGHT_BLUE));

    public static Supplier<ItemRingBase> ringNightVision = register("ring_night_vision",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.night_vision",
                    () -> Config.configRingNightVision.get(), MobEffects.NIGHT_VISION,
                    () -> Config.configRingAmplifierNightVision.get(), GlintRenderTypes.LIGHT_GRAY));

    public static Supplier<ItemRingBase> ringJumpBoost = register("ring_jump_boost",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.jump_boost",
                    () -> Config.configRingJumpBoost.get(), MobEffects.JUMP,
                    () -> Config.configRingAmplifierJumpBoost.get(), GlintRenderTypes.LIME));

    public static Supplier<ItemRingBase> ringMining = register("ring_mining",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.mining",
                    () -> Config.configRingMining.get(), MobEffects.DIG_SPEED,
                    () -> Config.configRingAmplifierMining.get(), GlintRenderTypes.YELLOW));

    public static Supplier<ItemRingBase> ringLuck = register("ring_luck",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.luck",
                    () -> Config.configRingLuck.get(), MobEffects.LUCK,
                    () -> Config.configRingAmplifierLuck.get(), GlintRenderTypes.GREEN));

    public static Supplier<ItemRingBase> ringDolphin = register("ring_dolphin",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.dolphin",
                    () -> Config.configRingDolphin.get(), MobEffects.DOLPHINS_GRACE,
                    () -> Config.configRingAmplifierDolphin.get(), GlintRenderTypes.LIGHT_GRAY));

    public static Supplier<ItemRingBase> ringMagnetism = register("ring_magnetism",
            () -> new ItemRingMagnet(new Item.Properties(), "tooltip.ringsofascension.magnetism",
                    () -> Config.configRingMagnetism.get(), GlintRenderTypes.LIGHT_GRAY));

    public static Supplier<ItemRingBase> ringFlight = register("ring_flight",
            () -> new ItemRingFlight(new Item.Properties(), "tooltip.ringsofascension.flight",
                    () -> Config.configRingFlight.get(), GlintRenderTypes.LIGHT_BLUE));

    public static Supplier<ItemRingBase> ringPoisonResistance = register("ring_poison_resistance",
            () -> new ItemRingPoisonResistance(new Item.Properties(), "tooltip.ringsofascension.poison_resistance",
                    () -> Config.configRingPoisonResistance.get(), GlintRenderTypes.GREEN));

    public static Supplier<ItemRingBase> ringHungerless = register("ring_hungerless",
            () -> new ItemRingHungerless(new Item.Properties(), "tooltip.ringsofascension.hungerless",
                    () -> Config.configRingHungerless.get(), GlintRenderTypes.BROWN));

    public static Supplier<ItemRingBase> ringGrowth = register("ring_growth",
            () -> new ItemRingGrowth(new Item.Properties(), "tooltip.ringsofascension.growth",
                    () -> Config.configRingGrowth.get(), GlintRenderTypes.GREEN));

    public static Supplier<ItemRingBase> ringKnockbackResistance = register("ring_knockback_resistance",
            () -> new ItemRingKnockbackResistance(new Item.Properties(), null,
                    () -> Config.configRingKnockbackResistance.get(), GlintRenderTypes.GRAY));

    public static Supplier<ItemRingBase> ringHealth = register("ring_health",
            () -> new ItemRingHealth(new Item.Properties(), null, () -> Config.configRingHealth.get(),
                    () -> Config.configRingHealthHearts.get(), GlintRenderTypes.RED));

    public static Supplier<ItemRingBase> ringSponge = register("ring_sponge",
            () -> new ItemRingSponge(new Item.Properties(), "tooltip.ringsofascension.sponge",
                    () -> Config.configRingSponge.get(), Fluids.WATER, Fluids.FLOWING_WATER, GlintRenderTypes.YELLOW));

    public static Supplier<ItemRingBase> ringLavaSponge = register("ring_lava_sponge",
            () -> new ItemRingSponge(new Item.Properties(), "tooltip.ringsofascension.lava_sponge",
                    () -> Config.configRingSponge.get(), Fluids.LAVA, Fluids.FLOWING_LAVA, GlintRenderTypes.ORANGE));

    public static Supplier<ItemRingBase> ringExperience = register("ring_experience",
            () -> new ItemRingExperience(new Item.Properties(), "tooltip.ringsofascension.experience",
                    () -> Config.configRingExperience.get(), GlintRenderTypes.LIME));

    public static Supplier<ItemRingBase> ringWaterWalking = register("ring_water_walking",
            () -> new ItemRingWaterWalking(new Item.Properties(), "tooltip.ringsofascension.water_walking",
                    () -> Config.configRingWaterWalking.get(), GlintRenderTypes.LIGHT_BLUE));

    public static Supplier<ItemRingBase> ringWither = register("ring_wither",
            () -> new ItemRingWither(new Item.Properties(), "tooltip.ringsofascension.wither",
                    () -> Config.configRingWither.get(), GlintRenderTypes.BLACK));

    public static Supplier<ItemRingBase> ringUndying = register("ring_undying",
            () -> new ItemRingUndying(new Item.Properties(), "tooltip.ringsofascension.undying",
                    () -> Config.configRingUndying.get(), () -> Config.configRingUndyingCooldown.get(), GlintRenderTypes.ORANGE));

    public static Supplier<ItemRingBase> ringSlowResistance = register("ring_slow_resistance",
            () -> new ItemRingSlowResistance(new Item.Properties(), "tooltip.ringsofascension.slow_resistance",
                    () -> Config.configRingSlowResistance.get(), GlintRenderTypes.GRAY));

    public static Supplier<ItemRingBase> ringSteadfastSteps = register("ring_steadfast_steps",
            () -> new ItemRingSteadfastSteps(new Item.Properties(), "tooltip.ringsofascension.steadfast_steps", () -> Config.configRingSteadfastSteps.get(), GlintRenderTypes.BROWN));

    public static void init(IEventBus bus) {
        register.register(bus);
    }

    private static Supplier<ItemRingBase> register(String name, Supplier<ItemRingBase> supplier) {
        return register.register(name, supplier);
    }

}
