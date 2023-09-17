package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingUndying extends ItemRingBase {

    private final int cooldown;

    public ItemRingUndying(Properties properties, String tooltip, boolean enabled, int cooldown, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
        this.cooldown = cooldown;
    }

    public void setCooldown(Player player) {
        if(!isEnabled) return;
        player.getCooldowns().addCooldown(this, cooldown * 20);
    }

}
