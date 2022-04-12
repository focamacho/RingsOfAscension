package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import com.google.common.collect.Lists;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Random;

public class ItemRingGrowth extends ItemRingBase {

    private int timer = 200;

    public ItemRingGrowth(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity livingEntity) {
        super.tick(stack, slot, livingEntity);
        if(livingEntity instanceof PlayerEntity) {
            if(timer <= 0) {
                timer = 200;

                BlockPos entityPos = new BlockPos(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                int range = 5;
                int limit = 0;

                List<BlockPos> blocks = Lists.newArrayList();

                for(BlockPos pos : BlockPos.iterate(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
                    Block block = livingEntity.world.getBlockState(pos).getBlock();
                    if(block instanceof CropBlock || block instanceof StemBlock || block instanceof KelpBlock || block instanceof SeagrassBlock) {
                        blocks.add(new BlockPos(pos));
                    }
                }

                if(blocks.size() >= 1) {
                    Random random = new Random();

                    while(blocks.size() >= 1 && limit < 3) {
                        BlockPos pos = blocks.remove(random.nextInt(blocks.size()));
                        BlockState state = livingEntity.world.getBlockState(pos);

                        if(BoneMealItem.useOnFertilizable(new ItemStack(Items.BONE_MEAL), livingEntity.world, pos)) {
                            if(state != livingEntity.world.getBlockState(pos)) {
                                limit++;
                                livingEntity.world.syncWorldEvent(2005, pos, 0);
                            }
                        }
                    }
                }
            } else {
                timer--;
            }
        }
    }

}
