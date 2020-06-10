package com.focamacho.ringsofascension.mixin;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.Slots;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.apache.commons.lang3.StringUtils;
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
            tooltip.remove(new LiteralText("Equippable in trinket slots:").formatted(Formatting.GRAY));
            tooltip.remove((new LiteralText(StringUtils.capitalize(Slots.RING)).formatted(Formatting.BLUE)));
            tooltip.remove((new LiteralText(StringUtils.capitalize(RingsOfAscension.ring2)).formatted(Formatting.BLUE)));
            tooltip.remove(tooltip.lastIndexOf(new LiteralText("")));
            tooltip.remove(new LiteralText("When equiped in ").formatted(Formatting.GRAY).append(new LiteralText("any").formatted(Formatting.BLUE)).append(new LiteralText(" trinket slot:")).formatted(Formatting.GRAY));
        }
    }
}