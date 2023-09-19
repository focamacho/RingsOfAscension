package com.focamacho.ringsofascension.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;

public class ClientHandler {

    public static void showFloatingTotem(ItemStack ring) {
        MinecraftClient.getInstance().gameRenderer.showFloatingItem(ring);
    }

}
