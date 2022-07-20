package com.focamacho.ringsofascension.item;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.init.ModItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class ItemRingBase extends Item {

    protected String tooltip;
    private final List<ResourceLocation> locations = new ArrayList<>();

    public ItemRingBase(Properties properties, String tooltip) {
        super(properties.tab(RingsOfAscension.tabGroup).stacksTo(1));
        this.tooltip = tooltip;
        ModItems.allRings.add(this);
    }

    public abstract boolean isEnabled();

    protected List<ResourceLocation> getLocations(String locations) {
        if(this.locations.isEmpty() && !locations.isEmpty()) {
            for (String location : locations.split(";")) {
                try {
                    String[] split = location.split(":");
                    this.locations.add(new ResourceLocation(split[0], split[1]));
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this.locations;
    }

    public abstract List<ResourceLocation> getLocations();

    public void tickCurio(String identifier, int index, LivingEntity livingEntity){}

    public Multimap<Attribute, AttributeModifier> curioModifiers(ItemStack stack, String identifier){
        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();
        return modifiers;
    }

    public void onEquippedCurio(String identifier, LivingEntity livingEntity){}

    public void onUnequippedCurio(String identifier, LivingEntity livingEntity){}

    public abstract int getTier();

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new ICapabilityProvider() {
            private final LazyOptional<ICurio> lazyCurio = LazyOptional.of(()-> new ICurio() {

                @Override
                public ItemStack getStack() {
                    return stack;
                }

                @Override
                public void curioTick(String identifier, int index, LivingEntity livingEntity) {
                    tickCurio(identifier, index, livingEntity);
                }

                @Override
                public void playRightClickEquipSound(LivingEntity livingEntity) {
                    livingEntity.level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.ARMOR_EQUIP_GOLD, SoundSource.NEUTRAL, 1.0f, 1.0f);
                }

                @Override
                public void onEquip(String identifier, int index, LivingEntity livingEntity) {
                    onEquippedCurio(identifier, livingEntity);
                }

                @Nonnull
                @Override
                public DropRule getDropRule(LivingEntity livingEntity) {
                    return DropRule.DEFAULT;
                }


                @Override
                public void onUnequip(String identifier, int index, LivingEntity livingEntity) {
                    onUnequippedCurio(identifier, livingEntity);
                }

                @Override
                public boolean canRightClickEquip() {
                    return true;
                }

                @Override
                public Multimap<Attribute, AttributeModifier> getAttributeModifiers(String identifier) {
                    return curioModifiers(stack, identifier);
                }

            });

            @Override
            public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction side) {
                return CuriosCapability.ITEM.orEmpty(capability, lazyCurio);
            }
        };
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        switch (getTier()) {
            case 0 ->
                    tooltip.add(Component.literal(ChatFormatting.GOLD + Component.translatable("tooltip.ringsofascension.tier").getString() + " " + ChatFormatting.GREEN + Component.translatable("tooltip.ringsofascension.tier.common").getString()));
            case 1 ->
                    tooltip.add(Component.literal(ChatFormatting.GOLD + Component.translatable("tooltip.ringsofascension.tier").getString() + " " + ChatFormatting.BLUE + Component.translatable("tooltip.ringsofascension.tier.rare").getString()));
            case 2 ->
                    tooltip.add(Component.literal(ChatFormatting.GOLD + Component.translatable("tooltip.ringsofascension.tier").getString() + " " + ChatFormatting.LIGHT_PURPLE + Component.translatable("tooltip.ringsofascension.tier.epic").getString()));
            case 3 ->
                    tooltip.add(Component.literal(ChatFormatting.GOLD + Component.translatable("tooltip.ringsofascension.tier").getString() + " " + ChatFormatting.RED + Component.translatable("tooltip.ringsofascension.tier.legendary").getString()));
            case 4 ->
                    tooltip.add(Component.literal(ChatFormatting.GOLD + Component.translatable("tooltip.ringsofascension.tier").getString() + " " + ChatFormatting.DARK_RED + Component.translatable("tooltip.ringsofascension.tier.mythic").getString()));
        }

        if(this.tooltip == null) return;

        tooltip.add(Component.literal(""));
        tooltip.add(Component.literal(ChatFormatting.GOLD + Component.translatable("tooltip.ringsofascension.worn").getString()));
        tooltip.add(Component.literal(ChatFormatting.BLUE + Component.translatable(this.tooltip).getString()));
    }
}
