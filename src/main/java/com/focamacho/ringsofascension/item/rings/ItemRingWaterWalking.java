package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.Fluids;
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

        BlockPos entityPos = livingEntity.blockPosition();

        boolean water =
                livingEntity.level.getFluidState(
                        new BlockPos(entityPos.getX(), (int) Math.floor(livingEntity.getBoundingBox().minY - 0.4), entityPos.getZ())
                ).is(Fluids.WATER);

        if(water && !livingEntity.isInWater()) {
            Vec3 motion = livingEntity.getDeltaMovement();

            livingEntity.setDeltaMovement(motion.x, 0, motion.z);
            livingEntity.fallDistance = 0;
            livingEntity.setOnGround(true);
        }
    }

}
