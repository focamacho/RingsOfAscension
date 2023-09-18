package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ItemRingMagnet extends ItemRingBase {

    private static final int RANGE = 7;

    public ItemRingMagnet(Properties properties, String tooltip, boolean enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled) return;
        if(livingEntity instanceof Player && !livingEntity.level().isClientSide && !livingEntity.isCrouching()) {
            BlockPos pos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY(), livingEntity.getBlockZ());
            List<ItemEntity> entities = livingEntity.level().getEntitiesOfClass(ItemEntity.class, new AABB(pos.getX() + RANGE, pos.getY() + RANGE, pos.getZ() + RANGE, pos.getX() - RANGE, pos.getY() - RANGE, pos.getZ() - RANGE));
            for(ItemEntity item : entities) {
                if(item.isAlive() && !item.hasPickUpDelay()) {
                    item.playerTouch((Player)livingEntity);
                }
            }
        }
    }

}
