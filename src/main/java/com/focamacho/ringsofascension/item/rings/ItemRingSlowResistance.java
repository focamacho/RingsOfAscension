package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingSlowResistance extends ItemRingBase {

    public ItemRingSlowResistance(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled()) return;
        if(livingEntity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
            livingEntity.removeEffectNoUpdate(MobEffects.MOVEMENT_SLOWDOWN);
        }
    }

    @Override
    public List<ResourceLocation> getLocations() {
        return super.getLocations(ConfigHolder.ringLocationSlowResistance);
    }

    @Override
    public boolean isEnabled() {
        return ConfigHolder.ringSlowResistance;
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierSlowResistance;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!isEnabled()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}