package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effects;

public class ItemRingSlowResistance extends ItemRingBase {

    public ItemRingSlowResistance(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(livingEntity.isPotionActive(Effects.SLOWNESS)) {
            livingEntity.removeActivePotionEffect(Effects.SLOWNESS);
        }
    }

}