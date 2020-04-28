package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import top.theillusivec4.curios.api.CuriosAPI;

import java.util.UUID;

public class ItemRingHealth extends ItemRingBase {

    private static final UUID HEALTH_UUID = UUID.fromString("b29c34f3-1450-48ff-ab28-639647e11861");
    private int health;

    public ItemRingHealth(Properties properties, String name, int health) {
        super(properties, name);
        this.health = health;
    }

    @Override
    public Multimap<String, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        Multimap<String, AttributeModifier> modifiers = HashMultimap.create();

        if (CuriosAPI.getCurioTags(stack.getItem()).contains(identifier)) {
            modifiers.put(SharedMonsterAttributes.MAX_HEALTH.getName(),
                    new AttributeModifier(HEALTH_UUID, "Max Health", health,
                            AttributeModifier.Operation.ADDITION));
        }

        return modifiers;
    }

}