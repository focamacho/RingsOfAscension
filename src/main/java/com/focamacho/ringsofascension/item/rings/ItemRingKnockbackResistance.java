package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import top.theillusivec4.curios.api.CuriosAPI;

import java.util.UUID;

public class ItemRingKnockbackResistance extends ItemRingBase {

    private static final UUID KNOBACK_RESISTANCE_UUID = UUID.fromString("320d847e-eecd-402f-b6cf-d339d2fa97af");

    public ItemRingKnockbackResistance(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public Multimap<String, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        Multimap<String, AttributeModifier> modifiers = HashMultimap.create();

        if (CuriosAPI.getCurioTags(stack.getItem()).contains(identifier)) {
            modifiers.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(),
                    new AttributeModifier(KNOBACK_RESISTANCE_UUID, "Knockback Resistance", 1.0D,
                            AttributeModifier.Operation.ADDITION));
        }

        return modifiers;
    }

}
