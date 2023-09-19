package com.focamacho.ringsofascension.client;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.RenderLayer;

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

    public final RenderLayer glint;
    public final RenderLayer direct;
    public final RenderLayer translucent;

    GlintRenderTypes(String name) {
        this.glint = GlintRenderType.buildGlintRenderType(name);
        this.direct = GlintRenderType.buildGlintDirectRenderType(name);
        this.translucent = GlintRenderType.buildGlintTranslucentRenderType(name);
    }

    public void addTypes(Object2ObjectLinkedOpenHashMap<RenderLayer, BufferBuilder> map) {
        if (!map.containsKey(glint))
            map.put(glint, new BufferBuilder(glint.getExpectedBufferSize()));

        if (!map.containsKey(direct))
            map.put(direct, new BufferBuilder(direct.getExpectedBufferSize()));

        if (!map.containsKey(translucent))
            map.put(translucent, new BufferBuilder(translucent.getExpectedBufferSize()));
    }

}