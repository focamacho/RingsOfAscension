package com.focamacho.ringsofascension.client;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;

public class GlintHandler {

    private static final ThreadLocal<ItemStack> stack = new ThreadLocal<>();

    public static void setStack(ItemStack value) {
        stack.set(value);
    }

    public static RenderLayer getGlintTranslucent() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderLayer.getGlintTranslucent() : color.translucent;
    }

    public static RenderLayer getGlint() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderLayer.getGlint() : color.glint;
    }

    public static RenderLayer getGlintDirect() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderLayer.getDirectGlint() : color.direct;
    }

    private static GlintRenderTypes getColor(ItemStack stack) {
        if(stack == null || !(stack.getItem() instanceof ItemRingBase item)) return null;
        return item.glintType;
    }

}