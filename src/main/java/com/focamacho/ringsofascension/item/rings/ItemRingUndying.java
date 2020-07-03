package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingUndying extends ItemRingBase {

    public ItemRingUndying(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    public void setCooldown(PlayerEntity player) {
        if(!ConfigHolder.ringUndying) return;
        player.getCooldownTracker().setCooldown(this, ConfigHolder.ringUndyingCooldown * 20);
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierUndying;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringUndying) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent(TextFormatting.YELLOW + new TranslationTextComponent("tooltip.ringsofascension.undying_cooldown").getString().replace("secondsHere", (TextFormatting.RED + Integer.toString(ConfigHolder.ringUndyingCooldown) + TextFormatting.YELLOW))));
    }

}
