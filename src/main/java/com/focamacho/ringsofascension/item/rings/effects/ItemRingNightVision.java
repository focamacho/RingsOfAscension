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

public class ItemRingNightVision extends ItemRingBase {

    public ItemRingNightVision(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled()) return;
        if(!livingEntity.hasEffect(MobEffects.NIGHT_VISION)) {
            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.NIGHT_VISION, Integer.MAX_VALUE, ConfigHolder.ringAmplifierNightVision, false, false);
            if(livingEntity.level.isClientSide) effectInstance.setNoCounter(true);
            livingEntity.addEffect(effectInstance);
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(!isEnabled()) return;
        livingEntity.removeEffect(MobEffects.NIGHT_VISION);
    }

    @Override
    public List<ResourceLocation> getLocations() {
        return super.getLocations(ConfigHolder.ringLocationNightVision);
    }

    @Override
    public boolean isEnabled() {
        return ConfigHolder.ringNightVision;
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierNightVision;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!isEnabled()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}