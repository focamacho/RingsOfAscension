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

public class ItemRingSlowFalling extends ItemRingBase {

    public ItemRingSlowFalling(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!ConfigHolder.ringSlowFalling) return;
        if(!livingEntity.isPotionActive(Effects.SLOW_FALLING)) {
            livingEntity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, Integer.MAX_VALUE, ConfigHolder.ringAmplifierSlowFalling, false, false));
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(!ConfigHolder.ringSlowFalling) return;
        livingEntity.removePotionEffect(Effects.SLOW_FALLING);
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierSlowFalling;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringSlowFalling) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}