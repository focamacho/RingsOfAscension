package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.config.Config;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.utils.Utils;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ApplyPotionEvent {

    @SubscribeEvent
    public void onApplyPotion(MobEffectEvent.Applicable event) {
        if(!(event.getEntity() instanceof Player player)) return;
        MobEffect effect = event.getEffectInstance().getEffect();

        //Poison Resistance Ring
        if(effect == MobEffects.POISON && Config.configRingPoisonResistance.get()) {
            if(Utils.isRingEquipped(ModItems.ringPoisonResistance.get(), player)) event.setResult(Event.Result.DENY);
        } else

        //Slowness Resistance Ring
        if(effect == MobEffects.MOVEMENT_SLOWDOWN && Config.configRingSlowResistance.get()) {
            if(Utils.isRingEquipped(ModItems.ringSlowResistance.get(), player)) event.setResult(Event.Result.DENY);
        } else

        //Wither Resistance Ring
        if(effect == MobEffects.WITHER && Config.configRingWither.get()) {
            if(Utils.isRingEquipped(ModItems.ringWither.get(), player)) event.setResult(Event.Result.DENY);
        }
    }

}