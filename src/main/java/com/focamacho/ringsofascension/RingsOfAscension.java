package com.focamacho.ringsofascension;

import com.focamacho.ringsofascension.config.Config;
import com.focamacho.ringsofascension.events.ApplyPotionEvent;
import com.focamacho.ringsofascension.events.PlayerDeathEvent;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.focamacho.ringsofascension.loot.RingsLootModifier;
import com.google.common.collect.Multimap;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@Mod("ringsofascension")
public class RingsOfAscension {

    public static final String MODID = "ringsofascension";
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final Supplier<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TAB_REGISTRY
            .register("creative_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ringsofascension"))
                    .icon(() -> new ItemStack(ModItems.ringExperience.get()))
                    .displayItems((params, output) -> {
                        for (Item entry : ModItems.allRings) {
                            output.accept(entry);
                        }
                    })
                    .build());

    public RingsOfAscension(IEventBus bus) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.spec);

        bus.addListener(this::registerCapabilities);

        ModItems.init(bus);
        RingsLootModifier.REGISTER.register(bus);
        CREATIVE_MODE_TAB_REGISTRY.register(bus);

        NeoForge.EVENT_BUS.register(new PlayerDeathEvent());
        NeoForge.EVENT_BUS.register(new ApplyPotionEvent());
    }

    public void registerCapabilities(final RegisterCapabilitiesEvent event) {
        for (ItemRingBase ring : ModItems.allRings) {
            event.registerItem(
                    CuriosCapability.ITEM,
                    (stack, context) -> new ICurio() {

                        @Override
                        public ItemStack getStack() {
                            return stack;
                        }

                        @Override
                        public void curioTick(SlotContext slotContext) {
                            if (!slotContext.cosmetic())
                                ring.tickCurio(slotContext.identifier(), slotContext.index(), slotContext.entity());
                        }

                        @NotNull
                        @Override
                        public SoundInfo getEquipSound(SlotContext slotContext) {
                            return new SoundInfo(SoundEvents.ARMOR_EQUIP_GOLD, 1.0f, 1.0f);
                        }

                        @Override
                        public void onEquip(SlotContext slotContext, ItemStack prevStack) {
                            if (!slotContext.cosmetic())
                                ring.onEquippedCurio(slotContext.identifier(), slotContext.entity());
                        }

                        @NotNull
                        @Override
                        public DropRule getDropRule(SlotContext slotContext, DamageSource source, int lootingLevel, boolean recentlyHit) {
                            return DropRule.DEFAULT;
                        }

                        @Override
                        public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                            if (!slotContext.cosmetic())
                                ring.onUnequippedCurio(slotContext.identifier(), slotContext.entity());
                        }

                        @Override
                        public boolean canEquipFromUse(SlotContext slotContext) {
                            return true;
                        }

                        @Override
                        public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                            return ring.curioModifiers(stack, slotContext.identifier());
                        }

                        @Override
                        public List<Component> getSlotsTooltip(List<Component> tt) {
                            List<Component> tooltips = ICurio.super.getAttributesTooltip(tt);
                            return ring.replaceTooltips(tooltips);
                        }

                        @Override
                        public List<Component> getAttributesTooltip(List<Component> tt) {
                            List<Component> tooltips = ICurio.super.getAttributesTooltip(tt);
                            return ring.getAttributesTooltip(ItemRingBase.replaceTooltips(tooltips));
                        }

                        @Override
                        public boolean canEquip(SlotContext slotContext) {
                            return !slotContext.cosmetic();
                        }
                    },
                    ring);
        }
    }

}
