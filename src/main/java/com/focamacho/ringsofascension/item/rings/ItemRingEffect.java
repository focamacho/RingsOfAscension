package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class ItemRingEffect extends ItemRingBase {

    private Effect effect;
    private int duration;
    private int amplifier;

    public ItemRingEffect(Properties properties, String name, Effect effect, int duration, int amplifier, String tooltip) {
        super(properties, name, tooltip);
        this.effect = effect;
        this.duration = duration;
        this.amplifier = amplifier;
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        livingEntity.addPotionEffect(new EffectInstance(effect, duration, amplifier, false, false));
    }

}

