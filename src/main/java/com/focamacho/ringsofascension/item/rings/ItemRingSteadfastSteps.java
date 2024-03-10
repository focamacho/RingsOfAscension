package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForgeMod;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public class ItemRingSteadfastSteps extends ItemRingBase {

    private final UUID STEP_HEIGHT_UUID = UUID.fromString("14378aa6-035b-4794-9137-da589a6dfe05");

    public ItemRingSteadfastSteps(Properties properties, String tooltip, Supplier<Boolean> enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();

        if (CuriosApi.getItemStackSlots(stack).containsKey(identifier) && isEnabled.get()) {
            modifiers.put(NeoForgeMod.STEP_HEIGHT.value(),
                    new AttributeModifier(STEP_HEIGHT_UUID, "Step Assist", 0.4625F,
                            AttributeModifier.Operation.ADDITION));
        }

        return modifiers;
    }

    @Override
    public List<Component> getAttributesTooltip(List<Component> tt) {
        tt.clear();
        return tt;
    }
}