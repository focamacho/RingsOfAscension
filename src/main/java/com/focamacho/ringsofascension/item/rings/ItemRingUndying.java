package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingUndying extends ItemRingBase {

    public ItemRingUndying(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    public void setCooldown(Player player) {
        if(!isEnabled()) return;
        player.getCooldowns().addCooldown(this, ConfigHolder.ringUndyingCooldown * 20);
    }

    @Override
    public List<ResourceLocation> getLocations() {
        return super.getLocations(ConfigHolder.ringLocationUndying);
    }

    @Override
    public boolean isEnabled() {
        return ConfigHolder.ringUndying;
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierUndying;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!isEnabled()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TextComponent(ChatFormatting.YELLOW + new TranslatableComponent("tooltip.ringsofascension.undying_cooldown").getString().replace("secondsHere", (ChatFormatting.RED + Integer.toString(ConfigHolder.ringUndyingCooldown) + ChatFormatting.YELLOW))));
    }

}
