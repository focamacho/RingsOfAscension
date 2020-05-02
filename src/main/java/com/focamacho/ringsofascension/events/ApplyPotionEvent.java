package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.utils.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ApplyPotionEvent {

    @SubscribeEvent
    public void onApplyPotion(PotionEvent.PotionApplicableEvent event) {
        //Poison Resistance Ring
        if(event.getPotionEffect().getPotion() == Effects.SLOWNESS && ConfigHolder.ringPoisonResistance) {
            if(event.getEntityLiving() instanceof PlayerEntity) {
                if(Utils.isRingEquipped(ModItems.ringPoisonResistance, (PlayerEntity)event.getEntityLiving())) event.setResult(Event.Result.DENY);
            }
        }

        //Slowness Resistance Ring
        if(event.getPotionEffect().getPotion() == Effects.SLOWNESS && ConfigHolder.ringSlowResistance) {
            if(event.getEntityLiving() instanceof PlayerEntity) {
                if(Utils.isRingEquipped(ModItems.ringSlowResistance, (PlayerEntity)event.getEntityLiving())) event.setResult(Event.Result.DENY);
            }
        }

        //Wither Resistance Ring
        if(event.getPotionEffect().getPotion() == Effects.WITHER && ConfigHolder.ringWither) {
            if(event.getEntityLiving() instanceof PlayerEntity) {
                if(Utils.isRingEquipped(ModItems.ringWither, (PlayerEntity)event.getEntityLiving())) event.setResult(Event.Result.DENY);
            }
        }
    }

}