package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.function.Supplier;

public class ItemRingFlight extends ItemRingBase {

    public ItemRingFlight(Properties properties, String tooltip, Supplier<Boolean> enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public void onEquippedCurio(String identifier, LivingEntity livingEntity) {
        if(!isEnabled.get()) return;
        if(livingEntity instanceof Player player) {
            player.getAbilities().mayfly = true;
            player.getAbilities().flying = true;
            player.onUpdateAbilities();
        }
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled.get()) return;
        if(livingEntity instanceof Player player) {
            if(!player.getAbilities().mayfly) {
                player.getAbilities().mayfly = true;
                player.onUpdateAbilities();
            }
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(!isEnabled.get()) return;
        if(livingEntity instanceof Player player && !player.isCreative()) {
            player.getAbilities().mayfly = false;
            player.getAbilities().flying = false;
            player.onUpdateAbilities();
        }
    }

}