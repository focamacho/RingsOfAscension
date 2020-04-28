package com.focamacho.ringsofascension.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import top.theillusivec4.curios.api.CuriosAPI;

public class Utils {

    public static boolean isRingEquipped(ItemStack ring, PlayerEntity player) {
        return CuriosAPI.getCurioEquipped(ring.getItem(), player).isPresent();
    }

}
