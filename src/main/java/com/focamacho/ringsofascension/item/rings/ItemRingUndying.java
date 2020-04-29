package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.player.PlayerEntity;

public class ItemRingUndying extends ItemRingBase {

    public ItemRingUndying(Properties properties, String name) {
        super(properties, name);
    }

    public void setCooldown(PlayerEntity player) {
        player.getCooldownTracker().setCooldown(this, 6000);
    }

}
