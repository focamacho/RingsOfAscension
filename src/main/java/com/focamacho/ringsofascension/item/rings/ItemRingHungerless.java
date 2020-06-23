package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemRingHungerless extends ItemRingBase {

    public ItemRingHungerless(String name, int tier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        player.getHungerManager().setFoodLevel(20);
    }

}
