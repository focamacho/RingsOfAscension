package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingSponge extends ItemRingBase {

    public ItemRingSponge(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled()) return;
        if(livingEntity.level.isClientSide || livingEntity.isCrouching()) return;

        Level world = livingEntity.level;
        BlockPos entityPos = new BlockPos(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
        int range = 3;

        for(BlockPos pos : BlockPos.betweenClosed(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
            BlockState state = livingEntity.level.getBlockState(pos);
            FluidState fluid = livingEntity.level.getFluidState(pos);
            Material material = state.getMaterial();

            if (fluid.is(Fluids.WATER)) {
                if (state.getBlock() instanceof IFluidBlock && ((IFluidBlock) state.getBlock()).drain(world, pos, IFluidHandler.FluidAction.EXECUTE) != FluidStack.EMPTY)
                    continue;

                if (state.getBlock() instanceof LiquidBlock) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                } else if (material == Material.WATER_PLANT || material == Material.REPLACEABLE_WATER_PLANT) {
                    BlockEntity tileentity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
                    Block.dropResources(state, world, pos, tileentity);
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                }
            }
        }
    }

    @Override
    public List<ResourceLocation> getLocations() {
        return super.getLocations(ConfigHolder.ringLocationSponge);
    }

    @Override
    public boolean isEnabled() {
        return ConfigHolder.ringSponge;
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierSponge;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!isEnabled()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
