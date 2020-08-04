package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemRingSponge extends ItemRingBase {

    public ItemRingSponge(String name, int tier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        if(player.world.isClient || player.isSneaking()) return;

        World world = player.world;
        BlockPos entityPos = player.getBlockPos();
        int range = 3;

        for(BlockPos pos : BlockPos.iterate(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
            BlockState state = world.getBlockState(pos);
            FluidState fluid = world.getFluidState(pos);
            Material material = state.getMaterial();

            if (fluid.isIn(FluidTags.WATER)) {
                if (state.getBlock() instanceof FluidDrainable && ((FluidDrainable) state.getBlock()).tryDrainFluid(world, pos, state) != Fluids.EMPTY) {
                    continue;
                } else if (state.getBlock() instanceof FluidBlock) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                } else if (material == Material.UNDERWATER_PLANT || material == Material.REPLACEABLE_UNDERWATER_PLANT) {
                    BlockEntity tileentity = state.getBlock().hasBlockEntity() ? world.getBlockEntity(pos) : null;
                    Block.dropStacks(state, world, pos, tileentity);
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                }
            }
        }
    }

}
