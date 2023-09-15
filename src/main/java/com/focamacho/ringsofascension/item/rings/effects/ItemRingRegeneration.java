package com.focamacho.ringsofascension.item.rings.effects;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingRegeneration extends ItemRingBase {

    public ItemRingRegeneration(Properties properties, String tooltip) {
        super(properties, tooltip, 3);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled()) return;
        if(!livingEntity.hasEffect(MobEffects.REGENERATION)) {
            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.REGENERATION, Integer.MAX_VALUE, ConfigHolder.ringAmplifierRegeneration, false, false);
            if(livingEntity.level.isClientSide) effectInstance.setNoCounter(true);
            livingEntity.addEffect(effectInstance);
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(!isEnabled()) return;
        livingEntity.removeEffect(MobEffects.REGENERATION);
    }

    @Override
    public boolean isEnabled() {
        return ConfigHolder.ringRegeneration;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!isEnabled()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}