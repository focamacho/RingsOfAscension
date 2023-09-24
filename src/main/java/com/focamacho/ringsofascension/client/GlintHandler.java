package com.focamacho.ringsofascension.client;

import com.focamacho.ringsofascension.item.ItemRingBase;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class GlintHandler {

    private static final ThreadLocal<ItemStack> stack = new ThreadLocal<>();

    public static void setStack(ItemStack value) {
        stack.set(value);
    }

    private static final HashMap<GlintRenderTypes, RenderLayer> glint = new HashMap<>() {{
        for (GlintRenderTypes value : GlintRenderTypes.values()) {
            put(value, GlintRenderType.buildGlintRenderType(value.name));
        }
    }};
    private static final HashMap<GlintRenderTypes, RenderLayer> directGlint = new HashMap<>() {{
        for (GlintRenderTypes value : GlintRenderTypes.values()) {
            put(value, GlintRenderType.buildGlintDirectRenderType(value.name));
        }
    }};
    private static final HashMap<GlintRenderTypes, RenderLayer> translucentGlint = new HashMap<>() {{
        for (GlintRenderTypes value : GlintRenderTypes.values()) {
            put(value, GlintRenderType.buildGlintTranslucentRenderType(value.name));
        }
    }};

    public static void addTypes(Object2ObjectLinkedOpenHashMap<RenderLayer, BufferBuilder> map) {
        glint.forEach((glint, render) -> {
            if (!map.containsKey(render))
                map.put(render, new BufferBuilder(render.getExpectedBufferSize()));
        });
        directGlint.forEach((glint, render) -> {
            if (!map.containsKey(render))
                map.put(render, new BufferBuilder(render.getExpectedBufferSize()));
        });
        translucentGlint.forEach((glint, render) -> {
            if (!map.containsKey(render))
                map.put(render, new BufferBuilder(render.getExpectedBufferSize()));
        });
    }

    public static RenderLayer getGlintTranslucent() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderLayer.getGlintTranslucent() : translucentGlint.get(color);
    }

    public static RenderLayer getGlint() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderLayer.getGlint() : glint.get(color);
    }

    public static RenderLayer getGlintDirect() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderLayer.getDirectGlint() : directGlint.get(color);
    }

    private static GlintRenderTypes getColor(ItemStack stack) {
        if(stack == null || !(stack.getItem() instanceof ItemRingBase item)) return null;
        return item.glintType;
    }

}