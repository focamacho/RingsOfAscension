package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemRingGrowth extends ItemRingBase {

    private int timer = 200;

    public ItemRingGrowth(String name, String tooltip, boolean enabled, GlintRenderTypes glintType) {
        super(name, tooltip, enabled, glintType);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity livingEntity) {
        super.tick(stack, slot, livingEntity);
        if(livingEntity instanceof PlayerEntity) {
            if(timer <= 0) {
                timer = 200;

                BlockPos entityPos = livingEntity.getBlockPos();
                int range = 5;
                int limit = 0;

                List<BlockPos> blocks = new ArrayList<>();

                for(BlockPos pos : BlockPos.iterate(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
                    Block block = livingEntity.getWorld().getBlockState(pos).getBlock();
                    if(block instanceof CropBlock || block instanceof StemBlock || block instanceof KelpBlock || block instanceof SeagrassBlock) {
                        blocks.add(new BlockPos(pos));
                    }
                }

                if(blocks.size() >= 1) {
                    Random random = new Random();

                    while(blocks.size() >= 1 && limit < 3) {
                        BlockPos pos = blocks.remove(random.nextInt(blocks.size()));
                        BlockState state = livingEntity.getWorld().getBlockState(pos);

                        if(BoneMealItem.useOnFertilizable(new ItemStack(Items.BONE_MEAL), livingEntity.getWorld(), pos)) {
                            if(state != livingEntity.getWorld().getBlockState(pos)) {
                                limit++;
                                livingEntity.getWorld().syncWorldEvent(2005, pos, 0);
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
