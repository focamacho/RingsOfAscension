package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.extensions.IForgeEntity;

public class ItemRingSteadfastSteps extends ItemRingBase {

    public ItemRingSteadfastSteps(Properties properties, String tooltip, boolean enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public void onEquippedCurio(String identifier, LivingEntity livingEntity) {
        if(!isEnabled) return;
        if(livingEntity instanceof Player player) {
            if(player.getStepHeight() < 1.0625F) {
                player.setMaxUpStep(1.0625F);
                player.onUpdateAbilities();
            }
        }
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled) return;
        if(livingEntity instanceof Player player) {
            if(player.getStepHeight() < 1.0625F) {
                player.setMaxUpStep(1.0625F);
                player.onUpdateAbilities();
            }
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(!isEnabled) return;
        if(livingEntity instanceof Player player) {
            player.setMaxUpStep(0.6F);
            player.onUpdateAbilities();
        }
    }

}