package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.config.Config;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.rings.ItemRingUndying;
import com.focamacho.ringsofascension.utils.Utils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerDeathEvent {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onLivingDeath(LivingDeathEvent event) {
        if(!Config.configRingUndying.get()) return;
        if(!(event.getEntity() instanceof ServerPlayer player)) return;

        ItemStack ring = Utils.getFirstCurio(ModItems.ringUndying.get(), player);
        if(ring != null) {
            if(player.getCooldowns().isOnCooldown(ring.getItem())) return;

            event.setCanceled(true);

            player.awardStat(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING));
            CriteriaTriggers.USED_TOTEM.trigger(player, ring);

            ((ItemRingUndying)ring.getItem()).setCooldown(player);

            player.setHealth(1.0F);
            player.removeAllEffects();
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));

            player.level().broadcastEntityEvent(player, (byte) 35);

            if(player.level().isClientSide) Minecraft.getInstance().gameRenderer.displayItemActivation(ring);
        }
    }

}
