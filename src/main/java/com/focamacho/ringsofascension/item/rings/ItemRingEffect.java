package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemRingEffect extends ItemRingBase {

    private StatusEffect effect;
    private int amplifier;

    public ItemRingEffect(String name, int tier, StatusEffect effect, int amplifier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
        this.effect = effect;
        this.amplifier = amplifier;
    }

    @Override
    public void onEquip(PlayerEntity player, ItemStack stack) {
        if(player.hasStatusEffect(effect)) return;
        StatusEffectInstance effectInstance = new StatusEffectInstance(effect, Integer.MAX_VALUE, amplifier, false, false);
        if(player.world.isClient) effectInstance.setPermanent(true);
        try {
			player.addStatusEffect(effectInstance);
		} catch(Exception e) {}
    }

    @Override
    public void onUnequip(PlayerEntity player, ItemStack stack) {
        if(!player.hasStatusEffect(effect)) return;
        player.removeStatusEffect(effect);
    }

}
