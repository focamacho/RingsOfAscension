package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.utils.Utils;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ApplyPotionEvent {

    @SubscribeEvent
    public void onApplyPotion(PotionEvent.PotionApplicableEvent event) {
        //Poison Resistance Ring
        if(event.getPotionEffect().getEffect() == MobEffects.POISON && ConfigHolder.ringPoisonResistance) {
            if(event.getEntityLiving() instanceof Player) {
                if(Utils.isRingEquipped(ModItems.ringPoisonResistance.get(), (Player)event.getEntityLiving())) event.setResult(Event.Result.DENY);
            }
        }

        //Slowness Resistance Ring
        if(event.getPotionEffect().getEffect() == MobEffects.MOVEMENT_SLOWDOWN && ConfigHolder.ringSlowResistance) {
            if(event.getEntityLiving() instanceof Player) {
                if(Utils.isRingEquipped(ModItems.ringSlowResistance.get(), (Player)event.getEntityLiving())) event.setResult(Event.Result.DENY);
            }
        }

        //Wither Resistance Ring
        if(event.getPotionEffect().getEffect() == MobEffects.WITHER && ConfigHolder.ringWither) {
            if(event.getEntityLiving() instanceof Player) {
                if(Utils.isRingEquipped(ModItems.ringWither.get(), (Player)event.getEntityLiving())) event.setResult(Event.Result.DENY);
            }
        }
    }

}