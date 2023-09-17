package com.focamacho.ringsofascension.client;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

/**
 * This code is from Vazkii's Quark.
 * Check out it <a href="https://github.com/VazkiiMods/Quark/blob/1.19.4/src/main/java/vazkii/quark/content/tools/client/render/GlintRenderTypes.java">here</a>.
 */
public class GlintRenderType extends RenderType {

    private GlintRenderType(String name, VertexFormat vf, VertexFormat.Mode mode, int bufSize, boolean affectsCrumbling, boolean sortOnUpload, Runnable setup, Runnable clean) {
        super(name, vf, mode, bufSize, affectsCrumbling, sortOnUpload, setup, clean);
        throw new UnsupportedOperationException("Don't instantiate this");
    }

    static RenderType buildGlintRenderType(String name) {
        return RenderType.create("glint_" + name, DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder()
                .setShaderState(RenderStateShard.RENDERTYPE_GLINT_SHADER)
                .setTextureState(new RenderStateShard.TextureStateShard(new ResourceLocation(RingsOfAscension.MODID, "textures/glint/glint_" + name + ".png"), true, false))
                .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                .setCullState(RenderStateShard.NO_CULL)
                .setDepthTestState(RenderStateShard.EQUAL_DEPTH_TEST)
                .setTransparencyState(RenderStateShard.GLINT_TRANSPARENCY)
                .setOutputState(RenderStateShard.ITEM_ENTITY_TARGET)
                .setTexturingState(RenderStateShard.GLINT_TEXTURING)
                .createCompositeState(false));
    }

    static RenderType buildGlintTranslucentRenderType(String name) {
        return RenderType.create("glint_translucent_" + name, DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, CompositeState.builder()
                .setShaderState(RenderStateShard.RENDERTYPE_GLINT_TRANSLUCENT_SHADER)
                .setTextureState(new TextureStateShard(new ResourceLocation(RingsOfAscension.MODID, "textures/glint/glint_" + name + ".png"), true, false))
                .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                .setCullState(RenderStateShard.NO_CULL)
                .setDepthTestState(RenderStateShard.EQUAL_DEPTH_TEST)
                .setTransparencyState(RenderStateShard.GLINT_TRANSPARENCY)
                .setOutputState(RenderStateShard.ITEM_ENTITY_TARGET)
                .setTexturingState(RenderStateShard.GLINT_TEXTURING)
                .createCompositeState(false));
    }

    static RenderType buildGlintDirectRenderType(String name) {
        return RenderType.create("glint_direct_" + name, DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, CompositeState.builder()
                .setShaderState(RenderStateShard.RENDERTYPE_GLINT_DIRECT_SHADER)
                .setTextureState(new TextureStateShard(new ResourceLocation(RingsOfAscension.MODID, "textures/glint/glint_" + name + ".png"), true, false))
                .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                .setCullState(RenderStateShard.NO_CULL)
                .setDepthTestState(RenderStateShard.EQUAL_DEPTH_TEST)
                .setTransparencyState(RenderStateShard.GLINT_TRANSPARENCY)
                .setTexturingState(RenderStateShard.GLINT_TEXTURING)
                .createCompositeState(false));
    }

}
