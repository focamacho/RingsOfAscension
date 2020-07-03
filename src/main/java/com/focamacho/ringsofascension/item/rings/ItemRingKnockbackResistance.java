package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import top.theillusivec4.curios.api.CuriosApi;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ItemRingKnockbackResistance extends ItemRingBase {

    private static final UUID KNOBACK_RESISTANCE_UUID = UUID.fromString("320d847e-eecd-402f-b6cf-d339d2fa97af");

    public ItemRingKnockbackResistance(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();

        if (CuriosApi.getCuriosHelper().getCurioTags(stack.getItem()).contains(identifier) && ConfigHolder.ringKnockbackResistance) {
            modifiers.put(Attributes.field_233820_c_,
                    new AttributeModifier(KNOBACK_RESISTANCE_UUID, "Knockback Resistance", 1.0D,
                            AttributeModifier.Operation.ADDITION));
        }

        return modifiers;
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierKnockbackResistance;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringKnockbackResistance) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
