package com.focamacho.ringsofascension.item;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.init.ModItems;
import dev.emi.trinkets.api.ITrinket;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class ItemRingBase extends Item implements ITrinket {

    private String ringName;
    private int tier;
    private String tooltip;
    private boolean enabled;

    public ItemRingBase(String name, int tier, String tooltip, boolean enabled) {
        super(new Settings().group(RingsOfAscension.creativeTab).maxCount(1));
        this.ringName = name;
        this.tier = tier;
        this.tooltip = tooltip;
        this.enabled = enabled;

        if(enabled) ModItems.allRings.add(this);
    }

    @Override
    public boolean canWearInSlot(String group, String slot) {
        return (group.equals(SlotGroups.HAND) && (slot.equals(Slots.RING) || slot.equals(RingsOfAscension.ring2)));
    }

    public String getRingName() {
        return ringName;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(new LiteralText("§6" + new TranslatableText("tooltip.ringsofascension.slot").asString() + " §e" + new TranslatableText("tooltip.ringsofascension.slot.ring").asString()));

        switch(tier) {
            case 0:
                tooltip.add(new LiteralText("§6" + new TranslatableText("tooltip.ringsofascension.tier").asString() + " " + "§a" + new TranslatableText("tooltip.ringsofascension.tier.common").asString()));
                break;
            case 1:
                tooltip.add(new LiteralText("§6" + new TranslatableText("tooltip.ringsofascension.tier").asString() + " " + "§9" + new TranslatableText("tooltip.ringsofascension.tier.rare").asString()));
                break;
            case 2:
                tooltip.add(new LiteralText("§6" + new TranslatableText("tooltip.ringsofascension.tier").asString() + " " + "§d" + new TranslatableText("tooltip.ringsofascension.tier.epic").asString()));
                break;
            case 3:
                tooltip.add(new LiteralText("§6" + new TranslatableText("tooltip.ringsofascension.tier").asString() + " " + "§c" + new TranslatableText("tooltip.ringsofascension.tier.legendary").asString()));
        }

        tooltip.add(new LiteralText(""));
        tooltip.add(new LiteralText("§6" + new TranslatableText("tooltip.ringsofascension.worn").asString()));

        if(this.tooltip == null) return;

        tooltip.add(new LiteralText("§9" + new TranslatableText(this.tooltip).asString()));

    }

    @Override
    public boolean hasEnchantmentGlint(ItemStack stack) {
        return true;
    }

    public int getTier() {
        return tier;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
