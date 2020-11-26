package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class TooltipEvent {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onTooltip(ItemTooltipEvent event) {
        if(event.getItemStack().getItem() instanceof ItemRingBase) {
            List<ITextComponent> tooltip = event.getToolTip();
            int index1 = -1;
            int index2 = -1;
            for(ITextComponent line : tooltip) {
                if(line.getString().equals(new TranslationTextComponent("curios.modifiers.ring").mergeStyle(TextFormatting.GOLD).getString())) {
                    index1 = tooltip.indexOf(line);
                } else if(line.getString().startsWith(new TranslationTextComponent("curios.slot").appendString(": ").mergeStyle(TextFormatting.GOLD).getString())) {
                    index2 = tooltip.indexOf(line);
                }
            }

            if(index1 != -1) {
                tooltip.set(index1, new TranslationTextComponent("tooltip.ringsofascension.worn").mergeStyle(TextFormatting.GOLD));
            }
            if(index2 != -1) {
                tooltip.set(index2, new TranslationTextComponent("tooltip.ringsofascension.slot").mergeStyle(TextFormatting.GOLD).append(new TranslationTextComponent("tooltip.ringsofascension.ring").mergeStyle(TextFormatting.YELLOW)));
            }
        }
    }


}
