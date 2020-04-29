package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingUndying extends ItemRingBase {

    public ItemRingUndying(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    public void setCooldown(PlayerEntity player) {
        player.getCooldownTracker().setCooldown(this, 6000);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent(ChatFormatting.YELLOW + new TranslationTextComponent("tooltip.ringsofascension.undying_cooldown").getFormattedText().replace("secondsHere", (ChatFormatting.RED + "300" + ChatFormatting.YELLOW))));
    }

}
