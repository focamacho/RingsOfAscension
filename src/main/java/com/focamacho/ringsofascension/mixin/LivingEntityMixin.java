package com.focamacho.ringsofascension.mixin;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.handler.ClientHandler;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.rings.ItemRingUndying;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(at = @At("HEAD"), method = "addStatusEffect", cancellable = true)
    private void addStatusEffect(StatusEffectInstance effect, CallbackInfoReturnable<Boolean> info) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            if (effect.getEffectType().equals(StatusEffects.POISON)) {
                TrinketComponent component = TrinketsApi.getTrinketComponent(player);
                if (component.getStack(SlotGroups.HAND, "ring").getItem().equals(ModItems.ringPoisonResistance) || component.getStack(SlotGroups.HAND, RingsOfAscension.ring2).getItem().equals(ModItems.ringPoisonResistance)) {
                    info.setReturnValue(false);
                }
            }

            if (effect.getEffectType().equals(StatusEffects.WITHER)) {
                TrinketComponent component = TrinketsApi.getTrinketComponent(player);
                if (component.getStack(SlotGroups.HAND, "ring").getItem().equals(ModItems.ringWither) || component.getStack(SlotGroups.HAND, RingsOfAscension.ring2).getItem().equals(ModItems.ringWither)) {
                    info.setReturnValue(false);
                }
            }

            if (effect.getEffectType().equals(StatusEffects.SLOWNESS)) {
                TrinketComponent component = TrinketsApi.getTrinketComponent(player);
                if (component.getStack(SlotGroups.HAND, "ring").getItem().equals(ModItems.ringSlowResistance) || component.getStack(SlotGroups.HAND, RingsOfAscension.ring2).getItem().equals(ModItems.ringSlowResistance)) {
                    info.setReturnValue(false);
                }
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "tryUseTotem", cancellable = true)
    private void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity entity = (LivingEntity)(Object) this;
        if(entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;

            TrinketComponent component = TrinketsApi.getTrinketComponent(player);
            ItemStack ring = null;

            if(component.getStack(SlotGroups.HAND, "ring").getItem().equals(ModItems.ringUndying)) {
                ring = component.getStack(SlotGroups.HAND, "ring");
            } else if(component.getStack(SlotGroups.HAND, RingsOfAscension.ring2).getItem().equals(ModItems.ringUndying)){
                ring = component.getStack(SlotGroups.HAND, RingsOfAscension.ring2);
            }

            if(ring != null && ring.getItem() instanceof ItemRingUndying) {
                if(!player.getItemCooldownManager().isCoolingDown(ring.getItem())) {
                    ((ItemRingUndying) ring.getItem()).setCooldown(player);

                    player.setHealth(1.0F);
                    player.clearStatusEffects();
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));

                    player.world.sendEntityStatus(player, (byte) 35);

                    if (player.world.isClient) ClientHandler.showFloatingTotem(ring);

                    info.setReturnValue(true);
                }
            }
        }
    }

}