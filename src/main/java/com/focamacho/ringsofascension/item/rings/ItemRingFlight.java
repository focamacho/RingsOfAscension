package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemRingFlight extends ItemRingBase {

    public ItemRingFlight(String name, int tier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
    }

    @Override
    public void onEquip(PlayerEntity player, ItemStack stack) {
        player.abilities.allowFlying = true;
        player.abilities.flying = true;
        player.sendAbilitiesUpdate();
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        if(!player.abilities.allowFlying) {
            player.abilities.allowFlying = true;
            player.sendAbilitiesUpdate();
        }
    }

    @Override
    public void onUnequip(PlayerEntity player, ItemStack stack) {
        player.abilities.allowFlying = false;
        player.abilities.flying = false;
        player.sendAbilitiesUpdate();
    }
}
