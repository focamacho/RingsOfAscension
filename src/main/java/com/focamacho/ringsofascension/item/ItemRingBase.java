package com.focamacho.ringsofascension.item;

import com.focamacho.ringsofascension.init.ModItems;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ItemRingBase extends TrinketItem {

    private final String ringName;
    private final String tooltip;
    private final boolean enabled;

    public ItemRingBase(String name, String tooltip, boolean enabled) {
        super(new Settings().maxCount(1));
        this.ringName = name;
        this.tooltip = tooltip;
        this.enabled = enabled;
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

        tooltip.add(Text.translatable("tooltip.ringsofascension.slot").formatted(Formatting.GRAY).append(Text.literal(" ")).append(Text.translatable("tooltip.ringsofascension.slot.ring").formatted(Formatting.YELLOW)));

        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("tooltip.ringsofascension.worn").formatted(Formatting.GRAY));

        if(this.tooltip == null) return;

        tooltip.add(Text.translatable(this.tooltip).formatted(Formatting.BLUE));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
