package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ItemRingEffect extends ItemRingBase {

    private final MobEffect effect;
    private final Supplier<Integer> amplifier;

    public ItemRingEffect(Properties properties, String tooltip, Supplier<Boolean> enabled, MobEffect effect, Supplier<Integer> amplifier, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
        this.effect = effect;
        this.amplifier = amplifier;
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!this.isEnabled.get()) return;
        if(!livingEntity.hasEffect(effect)) {
            MobEffectInstance effectInstance = new MobEffectInstance(effect, Integer.MAX_VALUE, amplifier.get(), false, false);
            livingEntity.addEffect(effectInstance);
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        livingEntity.removeEffect(effect);
    }

}