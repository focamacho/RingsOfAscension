package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class ItemRingHealth extends ItemRingBase {

    private static final UUID HEALTH_UUID = UUID.fromString("b29c34f3-1450-48ff-ab28-639647e11861");

    public ItemRingHealth(String name, int tier, String tooltip, boolean enabled) {
        super(name, tier, tooltip, enabled);
    }

    @Override
    public Multimap<String, EntityAttributeModifier> getTrinketModifiers(String group, String slot, UUID uuid, ItemStack stack) {
        Multimap<String, EntityAttributeModifier> modifiers = HashMultimap.create();

        modifiers.put(EntityAttributes.MAX_HEALTH.getId(),
                new EntityAttributeModifier(HEALTH_UUID, "Max Health", ConfigRingsOfAscension.ringHealthHearts * 2,
                        EntityAttributeModifier.Operation.ADDITION));

        return modifiers;
    }
}