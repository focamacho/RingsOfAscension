package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingWaterWalking extends ItemRingBase {

    public ItemRingWaterWalking(Properties properties, String tooltip) {
        super(properties, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled()) return;
        if(!(livingEntity instanceof Player) || livingEntity.isCrouching()) return;

        BlockPos entityPos = new BlockPos(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());

        boolean water = livingEntity.level.getBlockState(new BlockPos(entityPos.getX(), livingEntity.getBoundingBox().minY - 0.1, entityPos.getZ())).getMaterial() == Material.WATER;

        if(water && !livingEntity.isInWater() && livingEntity.getDeltaMovement().y < 0.0D) {
            Vec3 motion = livingEntity.getDeltaMovement();

            livingEntity.setDeltaMovement(motion.x, 0, motion.z);
            livingEntity.fallDistance = 0;
        }
    }

    @Override
    public List<ResourceLocation> getLocations() {
        return super.getLocations(ConfigHolder.ringLocationWaterWalking);
    }

    @Override
    public boolean isEnabled() {
        return ConfigHolder.ringWaterWalking;
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierWaterWalking;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!isEnabled()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
