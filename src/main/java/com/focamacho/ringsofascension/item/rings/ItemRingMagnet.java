package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class ItemRingMagnet extends ItemRingBase {

    public ItemRingMagnet(Properties properties, String name) {
        super(properties, name);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(livingEntity instanceof PlayerEntity && !livingEntity.world.isRemote && !livingEntity.isCrouching()) {
            int range = 5;
            BlockPos pos = livingEntity.getPosition();
            List<ItemEntity> entities = livingEntity.world.getEntitiesWithinAABB(ItemEntity.class, new AxisAlignedBB(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range));
            for(ItemEntity item : entities) {
                if(item.isAlive() && !item.cannotPickup()) {
                    item.onCollideWithPlayer((PlayerEntity)livingEntity);
                }
            }
        }
    }

}
