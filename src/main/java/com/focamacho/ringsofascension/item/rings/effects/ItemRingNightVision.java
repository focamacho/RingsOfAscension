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

public class ItemRingNightVision extends ItemRingBase {

    public ItemRingNightVision(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!ConfigHolder.ringNightVision) return;
        if(!livingEntity.isPotionActive(Effects.NIGHT_VISION)) {
            EffectInstance effectInstance = new EffectInstance(Effects.NIGHT_VISION, Integer.MAX_VALUE, ConfigHolder.ringAmplifierNightVision, false, false);
            if(livingEntity.world.isRemote) effectInstance.setPotionDurationMax(true);
            livingEntity.addPotionEffect(effectInstance);
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(!ConfigHolder.ringNightVision) return;
        livingEntity.removePotionEffect(Effects.NIGHT_VISION);
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierNightVision;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringNightVision) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}