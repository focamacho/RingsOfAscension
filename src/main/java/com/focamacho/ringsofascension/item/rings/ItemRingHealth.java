package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import top.theillusivec4.curios.api.CuriosAPI;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ItemRingHealth extends ItemRingBase {

    private static final UUID HEALTH_UUID = UUID.fromString("b29c34f3-1450-48ff-ab28-639647e11861");

    public ItemRingHealth(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public Multimap<String, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        Multimap<String, AttributeModifier> modifiers = HashMultimap.create();

        if (CuriosAPI.getCurioTags(stack.getItem()).contains(identifier) && ConfigHolder.ringHealth) {
            modifiers.put(SharedMonsterAttributes.MAX_HEALTH.getName(),
                    new AttributeModifier(HEALTH_UUID, "Max Health", ConfigHolder.ringHealthHearts * 2,
                            AttributeModifier.Operation.ADDITION));
        }

        return modifiers;
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierHealth;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringHealth) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}