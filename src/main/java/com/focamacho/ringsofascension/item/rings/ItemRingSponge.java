package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.capability.IFluidHandler;

import java.util.function.Supplier;

public class ItemRingSponge extends ItemRingBase {

    private final FlowingFluid staticFluidType;
    private final FlowingFluid flowingFluidType;

    public ItemRingSponge(Properties properties, String tooltip, Supplier<Boolean> enabled,
                          FlowingFluid staticFluidType, FlowingFluid flowingFluidType, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
        this.staticFluidType = staticFluidType;
        this.flowingFluidType = flowingFluidType;
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled.get()) return;
        if(livingEntity.level().isClientSide || livingEntity.isCrouching()) return;

        Level world = livingEntity.level();
        BlockPos entityPos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY(), livingEntity.getBlockZ());
        int range = 3;

        for(BlockPos pos : BlockPos.betweenClosed(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
            BlockState state = livingEntity.level().getBlockState(pos);
            FluidState fluid = livingEntity.level().getFluidState(pos);

            if (fluid.is(staticFluidType) || fluid.is(flowingFluidType)) {
                if (state.getBlock() instanceof IFluidBlock && ((IFluidBlock) state.getBlock()).drain(world, pos, IFluidHandler.FluidAction.EXECUTE) != FluidStack.EMPTY)
                    continue;

                if (state.getBlock() instanceof LiquidBlock) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                } else if (state.getBlock() instanceof IPlantable && ((IPlantable) state.getBlock()).getPlantType(
                        livingEntity.level(), pos
                ) == PlantType.WATER) {
                    BlockEntity tileentity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
                    Block.dropResources(state, world, pos, tileentity);
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                }
            }
        }
    }

}
