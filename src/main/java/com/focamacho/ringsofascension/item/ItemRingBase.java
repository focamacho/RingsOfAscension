package com.focamacho.ringsofascension.item;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.init.ModItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class ItemRingBase extends Item {

    protected String tooltip;
    public final Supplier<Boolean> isEnabled;
    public final GlintRenderTypes glintType;

    public ItemRingBase(Properties properties, String tooltip, Supplier<Boolean> enabled, GlintRenderTypes glintType) {
        super(properties.stacksTo(1));
        this.tooltip = tooltip;
        this.isEnabled = enabled;
        this.glintType = glintType;
        ModItems.allRings.add(this);
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    public void tickCurio(String identifier, int index, LivingEntity livingEntity){}

    public Multimap<Attribute, AttributeModifier> curioModifiers(ItemStack stack, String identifier){
        return HashMultimap.create();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    public void onEquippedCurio(String identifier, LivingEntity livingEntity){}

    public void onUnequippedCurio(String identifier, LivingEntity livingEntity){}

    public List<Component> getAttributesTooltip(List<Component> tt) {
        return tt;
    }

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, @NotNull List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if(this.tooltip == null) return;

        tooltip.add(Component.literal(""));
        tooltip.add(Component.literal(ChatFormatting.GRAY + Component.translatable("tooltip.ringsofascension.worn").getString()));
        tooltip.add(Component.literal(ChatFormatting.BLUE + Component.translatable(this.tooltip).getString()));
    }

    public static List<Component> replaceTooltips(List<Component> tooltips) {
        tooltips.replaceAll(tooltip ->
                changeColors(tooltip, TextColor.fromLegacyFormat(ChatFormatting.GOLD), TextColor.fromLegacyFormat(ChatFormatting.GRAY))
        );
        return tooltips;
    }

    private static Component changeColors(Component component, TextColor from, TextColor to) {
        MutableComponent mutable = component.copy();

        if(Objects.equals(mutable.getStyle().getColor(), from))
            mutable.setStyle(mutable.getStyle().withColor(to));

        mutable.getSiblings().replaceAll(component1 -> changeColors(component1, from, to));

        return mutable;
    }

}
