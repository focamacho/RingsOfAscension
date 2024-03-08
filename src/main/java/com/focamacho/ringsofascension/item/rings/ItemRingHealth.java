package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.UUID;
import java.util.function.Supplier;

public class ItemRingHealth extends ItemRingBase {

    private static final UUID HEALTH_UUID = UUID.fromString("b29c34f3-1450-48ff-ab28-639647e11861");
    private final Supplier<Integer> hearts;

    public ItemRingHealth(Properties properties, String tooltip, Supplier<Boolean> enabled, Supplier<Integer> hearts, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
        this.hearts = hearts;
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(livingEntity.getHealth() > livingEntity.getMaxHealth())
            livingEntity.setHealth(livingEntity.getMaxHealth());
    }

    @Override
    public Multimap<Attribute, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();

        if (CuriosApi.getItemStackSlots(stack).containsKey(identifier) && isEnabled.get()) {
            modifiers.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(HEALTH_UUID, "Max Health", hearts.get() * 2,
                            AttributeModifier.Operation.ADDITION));
        }

        return modifiers;
    }

}