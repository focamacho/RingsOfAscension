package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemRingSteadfastSteps extends ItemRingBase {

    public ItemRingSteadfastSteps(String name, String tooltip, boolean enabled, GlintRenderTypes glintType) {
        super(name, tooltip, enabled, glintType);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(!isEnabled()) return;
        if(entity instanceof PlayerEntity player) {
            if(player.getStepHeight() < 1.0625F) {
                player.setStepHeight(1.0625F);
                player.sendAbilitiesUpdate();
            }
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(!isEnabled()) return;
        if(entity instanceof PlayerEntity player) {
            if(player.getStepHeight() < 1.0625F) {
                player.setStepHeight(1.0625F);
                player.sendAbilitiesUpdate();
            }
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(!isEnabled()) return;
        if(entity instanceof PlayerEntity player) {
            player.setStepHeight(0.6F);
            player.sendAbilitiesUpdate();
        }
    }

}