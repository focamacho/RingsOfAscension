package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.CuriosApi;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ItemRingKnockbackResistance extends ItemRingBase {

    private static final UUID KNOBACK_RESISTANCE_UUID = UUID.fromString("320d847e-eecd-402f-b6cf-d339d2fa97af");

    public ItemRingKnockbackResistance(Properties properties, String tooltip) {
        super(properties, tooltip);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();

        if (CuriosApi.getCuriosHelper().getCurioTags(stack.getItem()).contains(identifier) && isEnabled()) {
            modifiers.put(Attributes.KNOCKBACK_RESISTANCE,
                    new AttributeModifier(KNOBACK_RESISTANCE_UUID, "Knockback Resistance", 1.0D,
                            AttributeModifier.Operation.ADDITION));
        }

        return modifiers;
    }

    @Override
    public List<ResourceLocation> getLocations() {
        return super.getLocations(ConfigHolder.ringLocationKnockbackResistance);
    }

    @Override
    public boolean isEnabled() {
        return ConfigHolder.ringKnockbackResistance;
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierKnockbackResistance;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!isEnabled()) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
