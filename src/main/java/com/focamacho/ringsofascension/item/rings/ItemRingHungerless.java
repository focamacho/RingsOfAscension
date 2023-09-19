package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemRingHungerless extends ItemRingBase {

    public ItemRingHungerless(String name, String tooltip, boolean enabled, GlintRenderTypes glintType) {
        super(name, tooltip, enabled, glintType);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if(entity instanceof PlayerEntity player) player.getHungerManager().setFoodLevel(20);
    }

}
