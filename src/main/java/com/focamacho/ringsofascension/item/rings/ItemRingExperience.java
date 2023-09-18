package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ItemRingExperience extends ItemRingBase {

    public ItemRingExperience(Properties properties, String tooltip, boolean enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled) return;
        if(livingEntity instanceof Player && !livingEntity.level().isClientSide && !livingEntity.isCrouching()) {
            int range = 10;
            BlockPos pos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY(), livingEntity.getBlockZ());
            List<ExperienceOrb> entities = livingEntity.level().getEntitiesOfClass(ExperienceOrb.class, new AABB(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range));
            for(ExperienceOrb orb : entities) {
                if(orb.isAlive()) {
                    orb.playerTouch((Player)livingEntity);
                }
            }
        }
    }

}
