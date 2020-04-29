package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class ItemRingWaterWalking extends ItemRingBase {

    public ItemRingWaterWalking(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!(livingEntity instanceof PlayerEntity) || livingEntity.isCrouching()) return;

        BlockPos entityPos = livingEntity.getPosition();

        boolean water = livingEntity.world.getBlockState(new BlockPos(entityPos.getX(), livingEntity.getBoundingBox().minY - 0.1, entityPos.getZ())).getMaterial() == Material.WATER;

        if(water && !livingEntity.isInWater() && livingEntity.getMotion().y < 0.0D) {
            Vec3d motion = livingEntity.getMotion();

            livingEntity.setMotion(motion.x, 0, motion.z);
            livingEntity.fallDistance = 0;
        }
    }

}
