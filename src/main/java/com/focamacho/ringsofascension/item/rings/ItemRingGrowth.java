package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

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
        if(!(livingEntity instanceof PlayerEntity)) return;
        if(timer <= 0) {
            timer = 200;

            BlockPos entityPos = new BlockPos(livingEntity.getPosX(), livingEntity.getPosY(), livingEntity.getPosZ());
            int range = 5;
            int limit = 0;

            for(BlockPos pos : BlockPos.getAllInBoxMutable(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
                if(limit > 3) break;

                BlockState state = livingEntity.world.getBlockState(pos);

                if(state.getBlock() instanceof CropsBlock || state.getBlock() instanceof StemBlock) {
                    if(BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), livingEntity.world, pos, (PlayerEntity) livingEntity)) {
                        limit++;
                        if(state != livingEntity.world.getBlockState(pos)) livingEntity.world.playEvent(2005, pos, 0);
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
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!isEnabled()) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
