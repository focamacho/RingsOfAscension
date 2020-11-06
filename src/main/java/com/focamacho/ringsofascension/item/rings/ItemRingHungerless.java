package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemRingHungerless extends ItemRingBase {

    public ItemRingHungerless(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        super.tick(player, stack);
        player.getHungerManager().setFoodLevel(20);
    }

}
