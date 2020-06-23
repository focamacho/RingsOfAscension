package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemRingEffectResistance extends ItemRingBase {

    private StatusEffect effect;

    public ItemRingEffectResistance(String name, int tier, StatusEffect effect, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
        this.effect = effect;
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        if(player.hasStatusEffect(effect)) {
            player.removeStatusEffect(effect);
        }
    }

}
