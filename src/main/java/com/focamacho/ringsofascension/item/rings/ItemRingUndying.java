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

    public ItemRingUndying(String name, String tooltip, boolean enabled) {
        super(name, tooltip, enabled);
    }

    public void setCooldown(PlayerEntity player) {
        player.getItemCooldownManager().set(this, config.general.ringUndyingCooldown * 20);
    }

}
