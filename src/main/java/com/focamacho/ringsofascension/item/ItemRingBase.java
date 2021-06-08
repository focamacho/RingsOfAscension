package com.focamacho.ringsofascension.item;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.init.ModItems;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ItemRingBase extends TrinketItem {

    private final String ringName;
    private final int tier;
    private final String tooltip;
    private final boolean enabled;
    public final List<Identifier> locations = new ArrayList<>();

    public ItemRingBase(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(new Settings().group(enabled ? RingsOfAscension.creativeTab : null).maxCount(1));
        this.ringName = name;
        this.tier = tier;
        this.tooltip = tooltip;
        this.enabled = enabled;

        for (String location : locations.split(";")) {
            try {
                String[] split = location.split(":");
                this.locations.add(new Identifier(split[0], split[1]));
            } catch(Exception ignored) {}
        }

        ModItems.allRings.add(this);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!enabled) stack.setCount(0);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(!enabled) stack.setCount(0);
    }

    public String getRingName() {
        return ringName;
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(new TranslatableText("tooltip.ringsofascension.slot").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.slot.ring").formatted(Formatting.YELLOW)));

        switch (tier) {
            case 0 -> tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.common").formatted(Formatting.GREEN)));
            case 1 -> tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.rare").formatted(Formatting.BLUE)));
            case 2 -> tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.epic").formatted(Formatting.LIGHT_PURPLE)));
            case 3 -> tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.legendary").formatted(Formatting.RED)));
            case 4 -> tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.mythic").formatted(Formatting.DARK_RED)));
        }

        tooltip.add(new LiteralText(""));
        tooltip.add(new TranslatableText("tooltip.ringsofascension.worn").formatted(Formatting.GOLD));

        if(this.tooltip == null) return;

        tooltip.add(new TranslatableText(this.tooltip).formatted(Formatting.BLUE));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public int getTier() {
        return tier;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
