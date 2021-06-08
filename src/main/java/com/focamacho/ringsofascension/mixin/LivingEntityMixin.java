package com.focamacho.ringsofascension.mixin;

import com.focamacho.ringsofascension.handler.ClientHandler;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.rings.ItemRingUndying;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/entity/LivingEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", cancellable = true)
    private void addStatusEffect(StatusEffectInstance effect, Entity source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity instanceof PlayerEntity player) {
            if (effect.getEffectType().equals(StatusEffects.POISON)) {
                Optional<TrinketComponent> optionalComponent = TrinketsApi.getTrinketComponent(player);
                if (optionalComponent.isPresent()) {
                    TrinketComponent component = optionalComponent.get();
                    if (component.isEquipped(ModItems.ringPoisonResistance)) info.setReturnValue(false);
                }
            }

            if (effect.getEffectType().equals(StatusEffects.WITHER)) {
                Optional<TrinketComponent> optionalComponent = TrinketsApi.getTrinketComponent(player);
                if (optionalComponent.isPresent()) {
                    TrinketComponent component = optionalComponent.get();
                    if (component.isEquipped(ModItems.ringWither)) info.setReturnValue(false);
                }
            }

            if (effect.getEffectType().equals(StatusEffects.SLOWNESS)) {
                Optional<TrinketComponent> optionalComponent = TrinketsApi.getTrinketComponent(player);
                if (optionalComponent.isPresent()) {
                    TrinketComponent component = optionalComponent.get();
                    if (component.isEquipped(ModItems.ringSlowResistance)) info.setReturnValue(false);
                }
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "tryUseTotem", cancellable = true)
    private void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity entity = (LivingEntity)(Object) this;
        if(entity instanceof ServerPlayerEntity player) {
            Optional<TrinketComponent> optionalComponent = TrinketsApi.getTrinketComponent(player);
            ItemStack ring = null;

            if(optionalComponent.isPresent()) {
                List<Pair<SlotReference, ItemStack>> equippedUndyingRings = optionalComponent.get().getEquipped(ModItems.ringUndying);
                if(equippedUndyingRings.size() > 0) ring = equippedUndyingRings.get(0).getRight();
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