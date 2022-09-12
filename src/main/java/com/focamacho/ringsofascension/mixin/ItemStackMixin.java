package com.focamacho.ringsofascension.mixin;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Inject(at = @At("RETURN"), method = "getTooltip", cancellable = true)
    private void getTooltip(PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> info) {
        Item item = ((ItemStack) (Object) this).getItem();
        if(item instanceof ItemRingBase) {
            List<Text> tooltip = info.getReturnValue();
            tooltip.remove(Text.translatable("trinkets.tooltip.slots.single",
                    Text.translatable("trinkets.slot.hand.ring").formatted(Formatting.BLUE)).formatted(Formatting.GRAY));
            tooltip.remove(Text.translatable("trinkets.tooltip.slots.single",
                    Text.translatable("trinkets.slot.offhand.ring").formatted(Formatting.BLUE)).formatted(Formatting.GRAY));

            tooltip.remove(Text.translatable("trinkets.tooltip.slots.any").formatted(Formatting.GRAY));

            tooltip.remove(Text.translatable("trinkets.tooltip.attributes.all").formatted(Formatting.GRAY));
            tooltip.remove(Text.translatable("trinkets.tooltip.attributes.single",
                    Text.translatable("trinkets.slot.hand.ring").formatted(Formatting.BLUE)).formatted(Formatting.GRAY));
            tooltip.remove(Text.translatable("trinkets.tooltip.attributes.single",
                    Text.translatable("trinkets.slot.offhand.ring").formatted(Formatting.BLUE)).formatted(Formatting.GRAY));
        }
    }
}