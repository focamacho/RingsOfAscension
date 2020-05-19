package com.focamacho.ringsofascension.item.rings.effects;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingLuck extends ItemRingBase {

    public ItemRingLuck(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!ConfigHolder.ringLuck) return;
        if(!livingEntity.isPotionActive(Effects.LUCK)) {
            livingEntity.addPotionEffect(new EffectInstance(Effects.LUCK, Integer.MAX_VALUE, ConfigHolder.ringAmplifierLuck, false, false));
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(!ConfigHolder.ringLuck) return;
        livingEntity.removePotionEffect(Effects.LUCK);
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierLuck;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringLuck) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}