package com.focamacho.ringsofascension.util;

import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;

import java.util.Optional;

public class Utils {

    public static boolean isRingEquipped(ItemRingBase ring, PlayerEntity player) {
        return getFirstRing(ring, player) != null;
    }

    public static ItemStack getFirstRing(ItemRingBase ring, PlayerEntity player) {
        Optional<TrinketComponent> optionalComponent = TrinketsApi.getTrinketComponent(player);
        if(optionalComponent.isEmpty()) return null;

        TrinketComponent component = optionalComponent.get();
        return component.getEquipped(ring).stream().map(Pair::getRight).findFirst().orElse(null);
    }

}
