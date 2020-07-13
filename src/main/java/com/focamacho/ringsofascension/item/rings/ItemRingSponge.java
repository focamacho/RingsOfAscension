package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidBlock;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingSponge extends ItemRingBase {

    public ItemRingSponge(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!ConfigHolder.ringSponge) return;
        if(livingEntity.world.isRemote || livingEntity.isCrouching()) return;

        BlockPos entityPos = new BlockPos(livingEntity.getPosX(), livingEntity.getPosY(), livingEntity.getPosZ());
        int range = 3;

        for(BlockPos pos : BlockPos.getAllInBoxMutable(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
            Fluid fluid = livingEntity.world.getFluidState(pos).getFluid();

            if(fluid.equals(Fluids.WATER) || fluid.equals(Fluids.FLOWING_WATER)) {
                livingEntity.world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }

        }
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierSponge;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringSponge) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
