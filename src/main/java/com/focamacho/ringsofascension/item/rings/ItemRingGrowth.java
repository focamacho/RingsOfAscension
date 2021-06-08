package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

public class ItemRingGrowth extends ItemRingBase {

    private int timer = 200;

    public ItemRingGrowth(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if(entity instanceof PlayerEntity player) {
            if (timer <= 0) {
                timer = 200;

                BlockPos entityPos = player.getBlockPos();
                int range = 5;
                int limit = 0;

                for (BlockPos pos : BlockPos.iterate(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
                    if (limit > 3) break;

                    BlockState state = player.world.getBlockState(pos);

                    if (state.getBlock() instanceof CropBlock || state.getBlock() instanceof StemBlock) {
                        if (BoneMealItem.useOnFertilizable(new ItemStack(Items.BONE_MEAL), player.world, pos)) {
                            limit++;
                            if (state != player.world.getBlockState(pos)) player.world.syncWorldEvent(2005, pos, 0);
                        }
                    }
                }
            } else {
                timer--;
            }
        }
    }

}
