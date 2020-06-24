package com.focamacho.ringsofascension.mixin;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.List;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Inject(at = @At("RETURN"), method = "getTooltip", cancellable = true)
    private void getTooltip(PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> info) {
        Item item = ((ItemStack) (Object) this).getItem();
        if(item instanceof ItemRingBase) {
            List<Text> tooltip = info.getReturnValue();
            Iterator<Text> iterator = tooltip.iterator();

            while(iterator.hasNext()) {
                String text = iterator.next().toString();
                if(text.contains("attribute.name")) iterator.remove();
            }

            tooltip.remove(new LiteralText("Equippable in trinket slots:").formatted(Formatting.GRAY));
            tooltip.remove(new TranslatableText("trinkets.slot.hand.ring").formatted(Formatting.BLUE));
            tooltip.remove(new TranslatableText("trinkets.slot.offhand.ring").formatted(Formatting.BLUE));
            tooltip.remove(tooltip.lastIndexOf(new LiteralText("")));
            tooltip.remove(new LiteralText("When equiped in ").formatted(Formatting.GRAY).append(new LiteralText("any").formatted(Formatting.BLUE)).append(new LiteralText(" trinket slot:")).formatted(Formatting.GRAY));
        }
    }
}