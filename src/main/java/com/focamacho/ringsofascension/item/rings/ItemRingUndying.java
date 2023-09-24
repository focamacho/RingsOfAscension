package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.player.PlayerEntity;

import static com.focamacho.ringsofascension.RingsOfAscension.config;

public class ItemRingUndying extends ItemRingBase {

    public ItemRingUndying(String name, String tooltip, boolean enabled, GlintRenderTypes glintType) {
        super(name, tooltip, enabled, glintType);
    }

    public void setCooldown(PlayerEntity player) {
        player.getItemCooldownManager().set(this, config.general.ringUndyingCooldown * 20);
    }

}
