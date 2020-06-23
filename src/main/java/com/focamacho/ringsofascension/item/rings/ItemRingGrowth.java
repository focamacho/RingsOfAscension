package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class ItemRingGrowth extends ItemRingBase {

    private int timer = 200;

    public ItemRingGrowth(String name, int tier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        if(timer <= 0) {
            timer = 200;

            BlockPos entityPos = player.getBlockPos();
            int range = 5;
            int limit = 0;

            for(BlockPos pos : BlockPos.iterate(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
                if(limit > 3) break;

                BlockState state = player.world.getBlockState(pos);

                Random rand = new Random();
                if(rand.nextInt(100) < 90) continue;

                if(state.getBlock() instanceof CropBlock) {
                    CropBlock crop = (CropBlock) state.getBlock();

                    if(crop.canGrow(player.world, player.world.random, pos, state)) {
                        if(player.world instanceof ServerWorld) {
                            crop.grow((ServerWorld) player.world, player.world.random, pos, state);
                        }

                        if(state != player.world.getBlockState(pos)) {
                            player.world.syncWorldEvent(2005, pos, 0);
                        }

                        limit++;
                    }
                }
            }
        } else {
            timer--;
        }
    }

}
