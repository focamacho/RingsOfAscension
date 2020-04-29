package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effects;

public class ItemRingWither extends ItemRingBase {

    public ItemRingWither(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(livingEntity.isPotionActive(Effects.WITHER)) {
            livingEntity.removeActivePotionEffect(Effects.WITHER);
        }
    }

}