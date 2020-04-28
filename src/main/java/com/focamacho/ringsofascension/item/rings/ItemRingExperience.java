package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class ItemRingExperience extends ItemRingBase {

    public ItemRingExperience(Properties properties, String name) {
        super(properties, name);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(livingEntity instanceof PlayerEntity && !livingEntity.world.isRemote && !livingEntity.isCrouching()) {
            int range = 10;
            BlockPos pos = livingEntity.getPosition();
            List<ExperienceOrbEntity> entities = livingEntity.world.getEntitiesWithinAABB(ExperienceOrbEntity.class, new AxisAlignedBB(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range));
            for(ExperienceOrbEntity orb : entities) {
                if(orb.isAlive()) {
                    orb.onCollideWithPlayer((PlayerEntity)livingEntity);
                }
            }
        }
    }

}
