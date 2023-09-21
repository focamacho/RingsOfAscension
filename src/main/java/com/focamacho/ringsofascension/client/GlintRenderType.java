package com.focamacho.ringsofascension.client;

import com.focamacho.ringsofascension.RingsOfAscension;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

/**
 * This code is from Vazkii's Quark.
 * Check out it <a href="https://github.com/VazkiiMods/Quark/blob/1.19.4/src/main/java/vazkii/quark/content/tools/client/render/GlintRenderTypes.java">here</a>.
 */
public class GlintRenderType extends RenderLayer {

    private GlintRenderType(String name, VertexFormat vf, VertexFormat.DrawMode mode, int bufSize, boolean affectsCrumbling, boolean sortOnUpload, Runnable setup, Runnable clean) {
        super(name, vf, mode, bufSize, affectsCrumbling, sortOnUpload, setup, clean);
        throw new UnsupportedOperationException("Don't instantiate this");
    }

    static RenderLayer buildGlintRenderType(String name) {
        return RenderLayer.of("glint_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, false, false, MultiPhaseParameters.builder()
                .program(RenderPhase.GLINT_PROGRAM)
                .texture(new Texture(new Identifier(RingsOfAscension.MODID, "textures/glint/glint_" + name + ".png"), true, false))
                .writeMaskState(RenderPhase.COLOR_MASK)
                .cull(RenderPhase.DISABLE_CULLING)
                .depthTest(RenderPhase.EQUAL_DEPTH_TEST)
                .transparency(RenderPhase.GLINT_TRANSPARENCY)
                .texturing(RenderPhase.GLINT_TEXTURING)
                .build(false));
    }

    static RenderLayer buildGlintTranslucentRenderType(String name) {
        return RenderLayer.of("glint_translucent_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, false, false, MultiPhaseParameters.builder()
                .program(RenderPhase.TRANSLUCENT_GLINT_PROGRAM)
                .texture(new Texture(new Identifier(RingsOfAscension.MODID, "textures/glint/glint_" + name + ".png"), true, false))
                .writeMaskState(RenderPhase.COLOR_MASK)
                .cull(RenderPhase.DISABLE_CULLING)
                .depthTest(RenderPhase.EQUAL_DEPTH_TEST)
                .transparency(RenderPhase.GLINT_TRANSPARENCY)
                .texturing(RenderPhase.GLINT_TEXTURING)
                .build(false));
    }

    static RenderLayer buildGlintDirectRenderType(String name) {
        return RenderLayer.of("glint_direct_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, false, false, MultiPhaseParameters.builder()
                .program(RenderPhase.DIRECT_GLINT_PROGRAM)
                .texture(new Texture(new Identifier(RingsOfAscension.MODID, "textures/glint/glint_" + name + ".png"), true, false))
                .writeMaskState(RenderPhase.COLOR_MASK)
                .cull(RenderPhase.DISABLE_CULLING)
                .depthTest(RenderPhase.EQUAL_DEPTH_TEST)
                .transparency(RenderPhase.GLINT_TRANSPARENCY)
                .texturing(RenderPhase.GLINT_TEXTURING)
                .build(false));
    }

}