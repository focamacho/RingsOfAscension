package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class ItemRingSponge extends ItemRingBase {

    public ItemRingSponge(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(livingEntity.world.isRemote || livingEntity.isCrouching()) return;

        BlockPos entityPos = livingEntity.getPosition();
        int range = 3;

        for(BlockPos pos : BlockPos.getAllInBoxMutable(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
            BlockState state = livingEntity.world.getBlockState(pos);

            if(state.getBlock() == Blocks.WATER) {
                livingEntity.world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }

        }
    }

}
