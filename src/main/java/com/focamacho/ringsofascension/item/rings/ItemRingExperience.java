package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingExperience extends ItemRingBase {

    public ItemRingExperience(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!ConfigHolder.ringExperience) return;
        if(livingEntity instanceof PlayerEntity && !livingEntity.world.isRemote && !livingEntity.isCrouching()) {
            int range = 10;
            BlockPos pos = livingEntity.getPosition();
            List<ExperienceOrbEntity> entities = livingEntity.world.getEntitiesWithinAABB(ExperienceOrbEntity.class, new AxisAlignedBB(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range));
            for(ExperienceOrbEntity orb : entities) {
                if(orb.isAlive()) {
                    orb.onCollideWithPlayer((PlayerEntity)livingEntity);
                }
            }
        }
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierExperience;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringExperience) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
