package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;

public class ItemRingEffect extends ItemRingBase {

    private final StatusEffect effect;
    private final int amplifier;

    public ItemRingEffect(String name, int tier, StatusEffect effect, int amplifier, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
        this.effect = effect;
        this.amplifier = amplifier;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(entity.hasStatusEffect(effect)) return;
        StatusEffectInstance effectInstance = new StatusEffectInstance(effect, Integer.MAX_VALUE, amplifier, false, false, false);
        entity.addStatusEffect(effectInstance);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(!entity.hasStatusEffect(effect)) return;
        entity.removeStatusEffect(effect);
    }

}
