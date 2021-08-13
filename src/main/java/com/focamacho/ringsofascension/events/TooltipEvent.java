package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class TooltipEvent {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onTooltip(ItemTooltipEvent event) {
        if(event.getItemStack().getItem() instanceof ItemRingBase) {
            List<Component> tooltip = event.getToolTip();
            int index1 = -1;
            int index2 = -1;
            for(Component line : tooltip) {
                if(line.getString().equals(new TranslatableComponent("curios.modifiers.ring").withStyle(ChatFormatting.GOLD).getString())) {
                    index1 = tooltip.indexOf(line);
                } else if(line.getString().startsWith(new TranslatableComponent("curios.slot").append(": ").withStyle(ChatFormatting.GOLD).getString())) {
                    index2 = tooltip.indexOf(line);
                }
            }

            if(index1 != -1) {
                tooltip.set(index1, new TranslatableComponent("tooltip.ringsofascension.worn").withStyle(ChatFormatting.GOLD));
            }
            if(index2 != -1) {
                tooltip.set(index2, new TranslatableComponent("tooltip.ringsofascension.slot").withStyle(ChatFormatting.GOLD).append(new TranslatableComponent("tooltip.ringsofascension.ring").withStyle(ChatFormatting.YELLOW)));
            }
        }
    }


}
