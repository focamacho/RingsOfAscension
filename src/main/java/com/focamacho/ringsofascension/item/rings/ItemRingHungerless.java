package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingHungerless extends ItemRingBase {

    public ItemRingHungerless(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!ConfigHolder.ringHungerless) return;
        if(livingEntity instanceof PlayerEntity) {
            ((PlayerEntity) livingEntity).getFoodStats().setFoodLevel(20);
        }
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierHungerless;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringHungerless) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
