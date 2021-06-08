package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;

public class ItemRingEffectResistance extends ItemRingBase {

    private final StatusEffect effect;

    public ItemRingEffectResistance(String name, int tier, StatusEffect effect, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
        this.effect = effect;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if(entity.hasStatusEffect(effect)) {
            entity.removeStatusEffect(effect);
        }
    }

}
