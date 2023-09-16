package com.focamacho.ringsofascension.utils;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.CuriosApi;

public class Utils {

    public static boolean isRingEquipped(ItemRingBase ring, Player player) {
        return ring.isEnabled && CuriosApi.getCuriosHelper().findFirstCurio(player, ring).isPresent();
    }

}
