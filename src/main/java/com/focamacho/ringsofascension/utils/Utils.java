package com.focamacho.ringsofascension.utils;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

public class Utils {

    public static boolean isRingEquipped(ItemStack ring, Player player) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(ring.getItem(), player).isPresent();
    }

    public static boolean isRingEquipped(Item ring, Player player) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(ring, player).isPresent();
    }

}
