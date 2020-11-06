package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class ItemRingKnockbackResistance extends ItemRingBase {

    private static final UUID KNOBACK_RESISTANCE_UUID = UUID.fromString("320d847e-eecd-402f-b6cf-d339d2fa97af");

    public ItemRingKnockbackResistance(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getTrinketModifiers(String group, String slot, UUID uuid, ItemStack stack) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = HashMultimap.create();

        modifiers.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                new EntityAttributeModifier(KNOBACK_RESISTANCE_UUID, "Knockback Resistance", 1.0D,
                        EntityAttributeModifier.Operation.ADDITION));

        return modifiers;
    }

}