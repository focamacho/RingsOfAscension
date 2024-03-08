package com.focamacho.ringsofascension.utils;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.Optional;

public class Utils {

    public static boolean isRingEquipped(ItemRingBase ring, Player player) {
        return getFirstCurio(ring, player) != null;
    }

    public static ItemStack getFirstCurio(ItemRingBase ring, Player player) {
        if(!ring.isEnabled.get()) return null;

        Optional<ICuriosItemHandler> inventory = CuriosApi.getCuriosInventory(player).resolve();
        if(inventory.isEmpty()) return null;

        Optional<SlotResult> curio = inventory.get().findFirstCurio(ring);
        return curio.map(SlotResult::stack).orElse(null);
    }

}
