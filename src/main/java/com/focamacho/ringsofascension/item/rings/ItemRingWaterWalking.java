package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingWaterWalking extends ItemRingBase {

    public ItemRingWaterWalking(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!ConfigHolder.ringWaterWalking) return;
        if(!(livingEntity instanceof PlayerEntity) || livingEntity.isCrouching()) return;

        BlockPos entityPos = new BlockPos(livingEntity.getPosX(), livingEntity.getPosY(), livingEntity.getPosZ());

        boolean water = livingEntity.world.getBlockState(new BlockPos(entityPos.getX(), livingEntity.getBoundingBox().minY - 0.1, entityPos.getZ())).getMaterial() == Material.WATER;

        if(water && !livingEntity.isInWater() && livingEntity.getMotion().y < 0.0D) {
            Vector3d motion = livingEntity.getMotion();

            livingEntity.setMotion(motion.x, 0, motion.z);
            livingEntity.fallDistance = 0;
        }
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierWaterWalking;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringWaterWalking) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
