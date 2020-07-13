package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class ItemRingSponge extends ItemRingBase {

    public ItemRingSponge(String name, int tier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        if(player.world.isClient || player.isSneaking()) return;

        BlockPos entityPos = player.getBlockPos();
        int range = 3;

        for(BlockPos pos : BlockPos.iterate(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
            Fluid fluid = player.world.getFluidState(pos).getFluid();

            if(fluid.equals(Fluids.WATER) || fluid.equals(Fluids.FLOWING_WATER)) {
                player.world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }

}
