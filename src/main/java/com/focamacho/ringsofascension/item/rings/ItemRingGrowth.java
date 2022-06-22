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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemRingGrowth extends ItemRingBase {

    private int timer = 200;

    public ItemRingGrowth(Properties properties, String tooltip) {
        super(properties, tooltip);
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

            List<BlockPos> blocks = new ArrayList<>();

            for(BlockPos pos : BlockPos.betweenClosed(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
                Block block = livingEntity.level.getBlockState(pos).getBlock();
                if(block instanceof CropBlock || block instanceof StemBlock || block instanceof KelpBlock || block instanceof SeagrassBlock) {
                    blocks.add(new BlockPos(pos));
                }
            }

            if(blocks.size() >= 1) {
                Random random = new Random();

                while(blocks.size() >= 1 && limit < 3) {
                    BlockPos pos = blocks.remove(random.nextInt(blocks.size()));
                    BlockState state = livingEntity.level.getBlockState(pos);

                    if(BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), livingEntity.level, pos, (Player) livingEntity)) {
                        if(state != livingEntity.level.getBlockState(pos)) {
                            limit++;
                            livingEntity.level.levelEvent(2005, pos, 0);
                        }
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
