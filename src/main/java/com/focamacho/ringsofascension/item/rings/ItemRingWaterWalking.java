package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class ItemRingWaterWalking extends ItemRingBase {

    public ItemRingWaterWalking(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if(entity.isSneaking()) return;

        BlockPos entityPos = entity.getBlockPos();

        boolean water = entity.world.getBlockState(new BlockPos(entityPos.getX(),
                (int) (entity.getBoundingBox().getMin(Direction.Axis.Y) - 0.1), entityPos.getZ())).getMaterial() == Material.WATER;

        if(water && !entity.isTouchingWater() && entity.getVelocity().y < 0.0D) {
            Vec3d motion = entity.getVelocity();

            entity.setVelocity(motion.x, 0.0D, motion.z);
            entity.fallDistance = 0;
        }
    }

}
