package com.focamacho.ringsofascension.init;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.config.Config;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.focamacho.ringsofascension.item.rings.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItems {

    public static List<ItemRingBase> allRings = new ArrayList<>();

    private static DeferredRegister<Item> register = DeferredRegister.create(ForgeRegistries.ITEMS, RingsOfAscension.MODID);

    public static RegistryObject<Item> ringFireResistance = register("ring_fire_resistance", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.fire_resistance", 1, Config.configRingFireResistance.get(), MobEffects.FIRE_RESISTANCE, Config.configRingAmplifierFireResistance.get()));
    public static RegistryObject<Item> ringInvisibility = register("ring_invisibility", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.invisibility", 1, Config.configRingInvisibility.get(), MobEffects.INVISIBILITY, Config.configRingAmplifierInvisibility.get()));
    public static RegistryObject<Item> ringRegeneration = register("ring_regeneration", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.regeneration", 3, Config.configRingRegeneration.get(), MobEffects.REGENERATION, Config.configRingAmplifierRegeneration.get()));
    public static RegistryObject<Item> ringSlowFalling = register("ring_slow_falling", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.slow_falling", 1, Config.configRingSlowFalling.get(), MobEffects.SLOW_FALLING, Config.configRingAmplifierSlowFalling.get()));
    public static RegistryObject<Item> ringStrength = register("ring_strength", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.strength", 2, Config.configRingStrength.get(), MobEffects.DAMAGE_BOOST, Config.configRingAmplifierStrength.get()));
    public static RegistryObject<Item> ringWaterBreathing = register("ring_water_breathing", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.water_breathing", 1, Config.configRingWaterBreathing.get(), MobEffects.WATER_BREATHING, Config.configRingAmplifierWaterBreathing.get()));
    public static RegistryObject<Item> ringSpeed = register("ring_speed", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.speed", 1, Config.configRingSpeed.get(), MobEffects.MOVEMENT_SPEED, Config.configRingAmplifierSpeed.get()));
    public static RegistryObject<Item> ringNightVision = register("ring_night_vision", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.night_vision", 0, Config.configRingNightVision.get(), MobEffects.NIGHT_VISION, Config.configRingAmplifierNightVision.get()));
    public static RegistryObject<Item> ringJumpBoost = register("ring_jump_boost", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.jump_boost", 0, Config.configRingJumpBoost.get(), MobEffects.JUMP, Config.configRingAmplifierJumpBoost.get()));
    public static RegistryObject<Item> ringMining = register("ring_mining", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.mining", 2, Config.configRingMining.get(), MobEffects.DIG_SPEED, Config.configRingAmplifierMining.get()));
    public static RegistryObject<Item> ringLuck = register("ring_luck", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.luck", 3, Config.configRingLuck.get(), MobEffects.LUCK, Config.configRingAmplifierLuck.get()));
    public static RegistryObject<Item> ringDolphin = register("ring_dolphin", () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascension.dolphin", 1, Config.configRingDolphin.get(), MobEffects.DOLPHINS_GRACE, Config.configRingAmplifierDolphin.get()));
    public static RegistryObject<Item> ringMagnetism = register("ring_magnetism", () -> new ItemRingMagnet(new Item.Properties(), "tooltip.ringsofascension.magnetism", 2, Config.configRingMagnetism.get()));
    public static RegistryObject<Item> ringFlight = register("ring_flight", () -> new ItemRingFlight(new Item.Properties(), "tooltip.ringsofascension.flight", 4, Config.configRingFlight.get()));
    public static RegistryObject<Item> ringPoisonResistance = register("ring_poison_resistance", () -> new ItemRingPoisonResistance(new Item.Properties(), "tooltip.ringsofascension.poison_resistance", 2, Config.configRingPoisonResistance.get()));
    public static RegistryObject<Item> ringHungerless = register("ring_hungerless", () -> new ItemRingHungerless(new Item.Properties(), "tooltip.ringsofascension.hungerless", 3, Config.configRingHungerless.get()));
    public static RegistryObject<Item> ringGrowth = register("ring_growth", () -> new ItemRingGrowth(new Item.Properties(), "tooltip.ringsofascension.growth", 2, Config.configRingGrowth.get()));
    public static RegistryObject<Item> ringKnockbackResistance = register("ring_knockback_resistance", () -> new ItemRingKnockbackResistance(new Item.Properties(), null, 1, Config.configRingKnockbackResistance.get()));
    public static RegistryObject<Item> ringHealth = register("ring_health", () -> new ItemRingHealth(new Item.Properties(), null, 3, Config.configRingHealth.get(), Config.configRingHealthHearts.get()));
    public static RegistryObject<Item> ringSponge = register("ring_sponge", () -> new ItemRingSponge(new Item.Properties(), "tooltip.ringsofascension.sponge", 1, Config.configRingSponge.get()));
    public static RegistryObject<Item> ringExperience = register("ring_experience", () -> new ItemRingExperience(new Item.Properties(), "tooltip.ringsofascension.experience", 0, Config.configRingExperience.get()));
    public static RegistryObject<Item> ringWaterWalking = register("ring_water_walking", () -> new ItemRingWaterWalking(new Item.Properties(), "tooltip.ringsofascension.water_walking", 0, Config.configRingWaterWalking.get()));
    public static RegistryObject<Item> ringWither = register("ring_wither", () -> new ItemRingWither(new Item.Properties(), "tooltip.ringsofascension.wither", 2, Config.configRingWither.get()));
    public static RegistryObject<Item> ringUndying = register("ring_undying", () -> new ItemRingUndying(new Item.Properties(), "tooltip.ringsofascension.undying", 4, Config.configRingUndying.get(), Config.configRingUndyingCooldown.get()));
    public static RegistryObject<Item> ringSlowResistance = register("ring_slow_resistance", () -> new ItemRingSlowResistance(new Item.Properties(), "tooltip.ringsofascension.slow_resistance", 1, Config.configRingSlowResistance.get()));

    public static void init(IEventBus bus) {
        register.register(bus);
    }

    private static RegistryObject<Item> register(String name, Supplier<Item> supplier) {
        return register.register(name, supplier);
    }

}
