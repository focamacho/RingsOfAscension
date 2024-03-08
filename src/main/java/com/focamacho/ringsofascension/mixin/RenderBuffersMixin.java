package com.focamacho.ringsofascension.mixin;

import com.focamacho.ringsofascension.client.GlintHandler;
import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.mojang.blaze3d.vertex.BufferBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderBuffers.class)
public class RenderBuffersMixin {

    @Inject(method = "put", at = @At("HEAD"))
    private static void addGlintTypes(Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder> map, RenderType renderTypeIn, CallbackInfo callbackInfo) {
        for (GlintRenderTypes value : GlintRenderTypes.values()) {
            RenderType glint = GlintHandler.glintMap.get(value);
            if (!map.containsKey(glint))
                map.put(glint, new BufferBuilder(glint.bufferSize()));

            RenderType direct = GlintHandler.directMap.get(value);
            if (!map.containsKey(direct))
                map.put(direct, new BufferBuilder(direct.bufferSize()));

            RenderType translucent = GlintHandler.translucentMap.get(value);
            if (!map.containsKey(translucent))
                map.put(translucent, new BufferBuilder(translucent.bufferSize()));
        }
    }

}
