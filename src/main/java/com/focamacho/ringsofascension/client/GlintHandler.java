package com.focamacho.ringsofascension.client;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;

public class GlintHandler {

    private static final ThreadLocal<ItemStack> stack = new ThreadLocal<>();

    public static void setStack(ItemStack value) {
        stack.set(value);
    }

    public static RenderType getGlintTranslucent() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderType.glintTranslucent() : color.translucent;
    }

    public static RenderType getGlint() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderType.glint() : color.glint;
    }

    public static RenderType getGlintDirect() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderType.glintDirect() : color.direct;
    }

    private static GlintRenderTypes getColor(ItemStack stack) {
        if(stack == null || !(stack.getItem() instanceof ItemRingBase item)) return null;
        return item.glintType;
    }

}
