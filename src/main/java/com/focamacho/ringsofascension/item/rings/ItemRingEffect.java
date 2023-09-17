package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class ItemRingEffect extends ItemRingBase {

    private final MobEffect effect;
    private final int amplifier;

    public ItemRingEffect(Properties properties, String tooltip, int tier, boolean enabled, MobEffect effect, int amplifier, GlintRenderTypes glintType) {
        super(properties, tooltip, tier, enabled, glintType);
        this.effect = effect;
        this.amplifier = amplifier;
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!this.isEnabled) return;
        if(!livingEntity.hasEffect(effect)) {
            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.DOLPHINS_GRACE, Integer.MAX_VALUE, amplifier, false, false);
            livingEntity.addEffect(effectInstance);
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(!this.isEnabled) return;
        livingEntity.removeEffect(effect);
    }

}