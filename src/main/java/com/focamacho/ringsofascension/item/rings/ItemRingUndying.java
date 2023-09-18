package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.entity.player.Player;

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
