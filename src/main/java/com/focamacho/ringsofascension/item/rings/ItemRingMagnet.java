package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingMagnet extends ItemRingBase {

    public ItemRingMagnet(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!ConfigHolder.ringMagnetism) return;
        if(livingEntity instanceof PlayerEntity && !livingEntity.world.isRemote && !livingEntity.isCrouching()) {
            int range = 5;
            BlockPos pos = new BlockPos(livingEntity.getPosX(), livingEntity.getPosY(), livingEntity.getPosZ());
            List<ItemEntity> entities = livingEntity.world.getEntitiesWithinAABB(ItemEntity.class, new AxisAlignedBB(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range));
            for(ItemEntity item : entities) {
                if(item.isAlive() && !item.cannotPickup()) {
                    item.onCollideWithPlayer((PlayerEntity)livingEntity);
                }
            }
        }
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierMagnetism;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringMagnetism) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
