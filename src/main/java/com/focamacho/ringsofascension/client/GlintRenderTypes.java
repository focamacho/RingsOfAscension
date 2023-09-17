package com.focamacho.ringsofascension.client;

import com.mojang.blaze3d.vertex.BufferBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.client.renderer.RenderType;

public enum GlintRenderTypes {

    WHITE("white"),
    ORANGE("orange"),
    MAGENTA("magenta"),
    LIGHT_BLUE("light_blue"),
    YELLOW("yellow"),
    LIME("lime"),
    PINK("pink"),
    GRAY("gray"),
    LIGHT_GRAY("light_gray"),
    CYAN("cyan"),
    PURPLE("purple"),
    BLUE("blue"),
    BROWN("brown"),
    GREEN("green"),
    RED("red"),
    BLACK("black");

    public final RenderType glint;
    public final RenderType direct;
    public final RenderType translucent;

    GlintRenderTypes(String name) {
        this.glint = GlintRenderType.buildGlintRenderType(name);
        this.direct = GlintRenderType.buildGlintDirectRenderType(name);
        this.translucent = GlintRenderType.buildGlintTranslucentRenderType(name);
    }

    public void addTypes(Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder> map) {
        if (!map.containsKey(glint))
            map.put(glint, new BufferBuilder(glint.bufferSize()));

        if (!map.containsKey(direct))
            map.put(direct, new BufferBuilder(direct.bufferSize()));

        if (!map.containsKey(translucent))
            map.put(translucent, new BufferBuilder(translucent.bufferSize()));
    }

}
