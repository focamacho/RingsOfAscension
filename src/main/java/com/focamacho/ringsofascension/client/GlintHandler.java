package com.focamacho.ringsofascension.client;

import com.focamacho.ringsofascension.item.ItemRingBase;
import com.mojang.blaze3d.vertex.BufferBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;

public class GlintHandler {

    private static final ThreadLocal<ItemStack> stack = new ThreadLocal<>();

    public static void setStack(ItemStack value) {
        stack.set(value);
    }

    private static final HashMap<GlintRenderTypes, RenderType> glint = new HashMap<>() {{
        for (GlintRenderTypes value : GlintRenderTypes.values()) {
            put(value, GlintRenderType.buildGlintRenderType(value.name));
        }
    }};
    private static final HashMap<GlintRenderTypes, RenderType> directGlint = new HashMap<>() {{
        for (GlintRenderTypes value : GlintRenderTypes.values()) {
            put(value, GlintRenderType.buildGlintDirectRenderType(value.name));
        }
    }};
    private static final HashMap<GlintRenderTypes, RenderType> translucentGlint = new HashMap<>() {{
        for (GlintRenderTypes value : GlintRenderTypes.values()) {
            put(value, GlintRenderType.buildGlintTranslucentRenderType(value.name));
        }
    }};

    public static void addTypes(Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder> map) {
        glint.forEach((glint, render) -> {
            if (!map.containsKey(render))
                map.put(render, new BufferBuilder(render.bufferSize()));
        });
        directGlint.forEach((glint, render) -> {
            if (!map.containsKey(render))
                map.put(render, new BufferBuilder(render.bufferSize()));
        });
        translucentGlint.forEach((glint, render) -> {
            if (!map.containsKey(render))
                map.put(render, new BufferBuilder(render.bufferSize()));
        });
    }

    public static RenderType getGlintTranslucent() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderType.glintTranslucent() : translucentGlint.get(color);
    }

    public static RenderType getGlint() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderType.glint() : glint.get(color);
    }

    public static RenderType getGlintDirect() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderType.glintDirect() : directGlint.get(color);
    }

    private static GlintRenderTypes getColor(ItemStack stack) {
        if(stack == null || !(stack.getItem() instanceof ItemRingBase item)) return null;
        return item.glintType;
    }

}
