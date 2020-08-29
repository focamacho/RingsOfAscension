package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.List;

public class ItemRingMagnetism extends ItemRingBase {

    public ItemRingMagnetism(String name, int tier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        if(!player.world.isClient && !player.isSneaking()) {
            int range = 5;
            BlockPos pos = player.getBlockPos();
            List<ItemEntity> entities = player.world.getEntitiesByClass(ItemEntity.class, new Box(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range), null);
            for(ItemEntity item : entities) {
                if(item.isAlive() && !item.cannotPickup()) {
                    item.onPlayerCollision(player);
                }
            }
        }
    }

}