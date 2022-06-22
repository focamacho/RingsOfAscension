package com.focamacho.ringsofascension.init;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.focamacho.ringsofascension.item.rings.*;
import com.focamacho.ringsofascension.item.rings.effects.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.EventBus;
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

    public static RegistryObject<Item> ringFireResistance = register("ring_fire_resistance", () -> new ItemRingFireResistance(new Item.Properties(), "tooltip.ringsofascension.fire_resistance"));
    public static RegistryObject<Item> ringInvisibility = register("ring_invisibility", () -> new ItemRingInvisibility(new Item.Properties(), "tooltip.ringsofascension.invisibility"));
    public static RegistryObject<Item> ringRegeneration = register("ring_regeneration", () -> new ItemRingRegeneration(new Item.Properties(), "tooltip.ringsofascension.regeneration"));
    public static RegistryObject<Item> ringSlowFalling = register("ring_slow_falling", () -> new ItemRingSlowFalling(new Item.Properties(), "tooltip.ringsofascension.slow_falling"));
    public static RegistryObject<Item> ringStrength = register("ring_strength", () -> new ItemRingStrength(new Item.Properties(), "tooltip.ringsofascension.strength"));
    public static RegistryObject<Item> ringWaterBreathing = register("ring_water_breathing", () -> new ItemRingWaterBreathing(new Item.Properties(), "tooltip.ringsofascension.water_breathing"));
    public static RegistryObject<Item> ringSpeed = register("ring_speed", () -> new ItemRingSpeed(new Item.Properties(), "tooltip.ringsofascension.speed"));
    public static RegistryObject<Item> ringNightVision = register("ring_night_vision", () -> new ItemRingNightVision(new Item.Properties(), "tooltip.ringsofascension.night_vision"));
    public static RegistryObject<Item> ringJumpBoost = register("ring_jump_boost", () -> new ItemRingJumpBoost(new Item.Properties(), "tooltip.ringsofascension.jump_boost"));
    public static RegistryObject<Item> ringMining = register("ring_mining", () -> new ItemRingMining(new Item.Properties(), "tooltip.ringsofascension.mining"));
    public static RegistryObject<Item> ringLuck = register("ring_luck", () -> new ItemRingLuck(new Item.Properties(), "tooltip.ringsofascension.luck"));
    public static RegistryObject<Item> ringDolphin = register("ring_dolphin", () -> new ItemRingDolphin(new Item.Properties(), "tooltip.ringsofascension.dolphin"));
    public static RegistryObject<Item> ringMagnetism = register("ring_magnetism", () -> new ItemRingMagnet(new Item.Properties(), "tooltip.ringsofascension.magnetism"));
    public static RegistryObject<Item> ringFlight = register("ring_flight", () -> new ItemRingFlight(new Item.Properties(), "tooltip.ringsofascension.flight"));
    public static RegistryObject<Item> ringPoisonResistance = register("ring_poison_resistance", () -> new ItemRingPoisonResistance(new Item.Properties(), "tooltip.ringsofascension.poison_resistance"));
    public static RegistryObject<Item> ringHungerless = register("ring_hungerless", () -> new ItemRingHungerless(new Item.Properties(), "tooltip.ringsofascension.hungerless"));
    public static RegistryObject<Item> ringGrowth = register("ring_growth", () -> new ItemRingGrowth(new Item.Properties(), "tooltip.ringsofascension.growth"));
    public static RegistryObject<Item> ringKnockbackResistance = register("ring_knockback_resistance", () -> new ItemRingKnockbackResistance(new Item.Properties(), null));
    public static RegistryObject<Item> ringHealth = register("ring_health", () -> new ItemRingHealth(new Item.Properties(), null));
    public static RegistryObject<Item> ringSponge = register("ring_sponge", () -> new ItemRingSponge(new Item.Properties(), "tooltip.ringsofascension.sponge"));
    public static RegistryObject<Item> ringExperience = register("ring_experience", () -> new ItemRingExperience(new Item.Properties(), "tooltip.ringsofascension.experience"));
    public static RegistryObject<Item> ringWaterWalking = register("ring_water_walking", () -> new ItemRingWaterWalking(new Item.Properties(), "tooltip.ringsofascension.water_walking"));
    public static RegistryObject<Item> ringWither = register("ring_wither", () -> new ItemRingWither(new Item.Properties(), "tooltip.ringsofascension.wither"));
    public static RegistryObject<Item> ringUndying = register("ring_undying", () -> new ItemRingUndying(new Item.Properties(), "tooltip.ringsofascension.undying"));
    public static RegistryObject<Item> ringSlowResistance = register("ring_slow_resistance", () -> new ItemRingSlowResistance(new Item.Properties(), "tooltip.ringsofascension.slow_resistance"));

    public static void init(IEventBus bus) {
        register.register(bus);
    }

    private static RegistryObject<Item> register(String name, Supplier<Item> supplier) {
        return register.register(name, supplier);
    }

}
