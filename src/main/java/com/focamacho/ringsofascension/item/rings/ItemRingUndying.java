package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingUndying extends ItemRingBase {

    private final int cooldown;

    public ItemRingUndying(Properties properties, String tooltip, int tier, boolean enabled, int cooldown) {
        super(properties, tooltip, tier, enabled);
        this.cooldown = cooldown;
    }

    public void setCooldown(Player player) {
        if(!isEnabled) return;
        player.getCooldowns().addCooldown(this, cooldown * 20);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!isEnabled) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(Component.literal(ChatFormatting.YELLOW + Component.translatable("tooltip.ringsofascension.undying_cooldown").getString().replace("secondsHere", (ChatFormatting.RED + Integer.toString(this.cooldown) + ChatFormatting.YELLOW))));
    }

}
