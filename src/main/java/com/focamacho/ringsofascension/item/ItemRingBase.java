package com.focamacho.ringsofascension.item;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.init.ModItems;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemRingBase extends TrinketItem {

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
        return slot.equals(Slots.RING);
    }

    public String getRingName() {
        return ringName;
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(new TranslatableText("tooltip.ringsofascension.slot").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.slot.ring").formatted(Formatting.YELLOW)));

        switch(tier) {
            case 0:
                tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.common").formatted(Formatting.GREEN)));
                break;
            case 1:
                tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.rare").formatted(Formatting.BLUE)));
                break;
            case 2:
                tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.epic").formatted(Formatting.LIGHT_PURPLE)));
                break;
            case 3:
                tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.legendary").formatted(Formatting.RED)));
        }

        tooltip.add(new LiteralText(""));
        tooltip.add(new TranslatableText("tooltip.ringsofascension.worn").formatted(Formatting.GOLD));

        if(this.tooltip == null) return;

        tooltip.add(new TranslatableText(this.tooltip).formatted(Formatting.BLUE));
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
