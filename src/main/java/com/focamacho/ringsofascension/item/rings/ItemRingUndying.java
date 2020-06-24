package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class ItemRingUndying extends ItemRingBase {

    public ItemRingUndying(String name, int tier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
    }

    public void setCooldown(PlayerEntity player) {
        player.getItemCooldownManager().set(this, ConfigRingsOfAscension.ringUndyingCooldown * 20);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(new LiteralText("§e" + I18n.translate("tooltip.ringsofascension.undying_cooldown").replace("secondsHere", "§c" + ConfigRingsOfAscension.ringUndyingCooldown + "§e")));
    }
}
