package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

import static com.focamacho.ringsofascension.RingsOfAscension.config;

public class ItemRingUndying extends ItemRingBase {

    public ItemRingUndying(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
    }

    public void setCooldown(PlayerEntity player) {
        player.getItemCooldownManager().set(this, config.general.ringUndyingCooldown * 20);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(Text.literal("§e" + I18n.translate("tooltip.ringsofascension.undying_cooldown").replace("secondsHere", "§c" + config.general.ringUndyingCooldown + "§e")));
    }
}
