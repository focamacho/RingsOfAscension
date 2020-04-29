package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class ItemRingHungerless extends ItemRingBase {

    public ItemRingHungerless(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(livingEntity instanceof PlayerEntity) {
            ((PlayerEntity) livingEntity).getFoodStats().setFoodLevel(20);
        }
    }

}
