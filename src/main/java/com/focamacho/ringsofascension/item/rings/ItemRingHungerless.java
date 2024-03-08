package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.function.Supplier;

public class ItemRingHungerless extends ItemRingBase {

    public ItemRingHungerless(Properties properties, String tooltip, Supplier<Boolean> enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled.get()) return;
        if(livingEntity instanceof Player) {
            ((Player) livingEntity).getFoodData().setFoodLevel(20);
        }
    }

}
