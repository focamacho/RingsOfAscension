package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class ItemRingSlowResistance extends ItemRingBase {

    public ItemRingSlowResistance(Properties properties, String tooltip, boolean enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled) return;
        if(livingEntity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
            livingEntity.removeEffectNoUpdate(MobEffects.MOVEMENT_SLOWDOWN);
        }
    }

}