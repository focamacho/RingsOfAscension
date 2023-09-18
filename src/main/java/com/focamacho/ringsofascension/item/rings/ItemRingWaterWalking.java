package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;

public class ItemRingWaterWalking extends ItemRingBase {

    public ItemRingWaterWalking(Properties properties, String tooltip, boolean enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled) return;
        if(!(livingEntity instanceof Player) || livingEntity.isCrouching()) return;

        BlockPos entityPos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY(), livingEntity.getBlockZ());

        boolean water = livingEntity.level.getBlockState(new BlockPos(entityPos.getX(), (int) Math.floor(livingEntity.getBoundingBox().minY - 0.1), entityPos.getZ())).getMaterial() == Material.WATER;

        if(water && !livingEntity.isInWater() && livingEntity.getDeltaMovement().y < 0.0D) {
            Vec3 motion = livingEntity.getDeltaMovement();

            livingEntity.setDeltaMovement(motion.x, 0, motion.z);
            livingEntity.fallDistance = 0;
        }
    }

}
