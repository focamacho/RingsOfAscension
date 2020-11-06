package com.focamacho.ringsofascension.item;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.init.ModItems;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
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

    private String ringName;
    private int tier;
    private String tooltip;
    private boolean enabled;
    public final List<Identifier> locations = new ArrayList<>();

    public ItemRingBase(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(new Settings().group(RingsOfAscension.creativeTab).maxCount(1));
        this.ringName = name;
        this.tier = tier;
        this.tooltip = tooltip;
        this.enabled = enabled;

        for (String location : locations.split(";")) {
            try {
                String[] split = location.split(":");
                this.locations.add(new Identifier(split[0], split[1]));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        ModItems.allRings.add(this);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!enabled) stack.setCount(0);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        if(!enabled) stack.setCount(0);
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
                break;
            case 4:
                tooltip.add(new TranslatableText("tooltip.ringsofascension.tier").formatted(Formatting.GOLD).append(new LiteralText(" ")).append(new TranslatableText("tooltip.ringsofascension.tier.mythic").formatted(Formatting.DARK_RED)));
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
