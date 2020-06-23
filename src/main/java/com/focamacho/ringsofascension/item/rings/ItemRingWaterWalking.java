package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class ItemRingWaterWalking extends ItemRingBase {

    public ItemRingWaterWalking(String name, int tier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        if(player.isSneaking()) return;

        BlockPos entityPos = player.getBlockPos();

        boolean water = player.world.getBlockState(new BlockPos(entityPos.getX(), player.getBoundingBox().getMin(Direction.Axis.Y) - 0.1, entityPos.getZ())).getMaterial() == Material.WATER;

        if(water && !player.isTouchingWater() && player.getVelocity().y < 0.0D) {
            Vec3d motion = player.getVelocity();

            player.setVelocity(motion.x, 0.0D, motion.z);
            player.fallDistance = 0;
        }
    }

}
