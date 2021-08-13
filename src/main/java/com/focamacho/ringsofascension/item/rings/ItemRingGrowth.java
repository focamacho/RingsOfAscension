package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingGrowth extends ItemRingBase {

    private int timer = 200;

    public ItemRingGrowth(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled()) return;
        if(!(livingEntity instanceof Player)) return;
        if(timer <= 0) {
            timer = 200;

            BlockPos entityPos = new BlockPos(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
            int range = 5;
            int limit = 0;

            for(BlockPos pos : BlockPos.betweenClosed(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
                if(limit > 3) break;

                BlockState state = livingEntity.level.getBlockState(pos);

                if(state.getBlock() instanceof CropBlock || state.getBlock() instanceof StemBlock) {
                    if(BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), livingEntity.level, pos, (Player) livingEntity)) {
                        limit++;
                        if(state != livingEntity.level.getBlockState(pos)) livingEntity.level.levelEvent(2005, pos, 0);
                    }
                }
            }
        } else {
            timer--;
        }
    }

    @Override
    public List<ResourceLocation> getLocations() {
        return super.getLocations(ConfigHolder.ringLocationGrowth);
    }

    @Override
    public boolean isEnabled() {
        return ConfigHolder.ringGrowth;
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierGrowth;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!isEnabled()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
