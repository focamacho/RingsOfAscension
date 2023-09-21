package com.focamacho.ringsofascension.mixin;

import com.focamacho.ringsofascension.client.ClientHandler;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.rings.ItemRingUndying;
import com.focamacho.ringsofascension.util.Utils;
import net.minecraft.entity.Entity;
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

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/entity/LivingEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", cancellable = true)
    private void addStatusEffect(StatusEffectInstance effect, Entity source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity instanceof PlayerEntity player) {
            if (effect.getEffectType().equals(StatusEffects.POISON) && Utils.isRingEquipped(ModItems.ringPoisonResistance, player)) {
                info.setReturnValue(false);
            } else if (effect.getEffectType().equals(StatusEffects.WITHER)&& Utils.isRingEquipped(ModItems.ringWither, player)) {
                info.setReturnValue(false);
            } else if (effect.getEffectType().equals(StatusEffects.SLOWNESS) && Utils.isRingEquipped(ModItems.ringSlowResistance, player)) {
                info.setReturnValue(false);
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "tryUseTotem", cancellable = true)
    private void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity entity = (LivingEntity)(Object) this;
        if(entity instanceof ServerPlayerEntity player) {
            ItemStack ring = Utils.getFirstRing(ModItems.ringUndying, player);

            if(ring != null && ring.getItem() instanceof ItemRingUndying) {
                if(!player.getItemCooldownManager().isCoolingDown(ring.getItem())) {
                    ((ItemRingUndying) ring.getItem()).setCooldown(player);

                    player.setHealth(1.0F);
                    player.clearStatusEffects();
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));

                    player.getWorld().sendEntityStatus(player, (byte) 35);

                    if (player.getWorld().isClient) ClientHandler.showFloatingTotem(ring);

                    info.setReturnValue(true);
                }
            }
        }
    }

}