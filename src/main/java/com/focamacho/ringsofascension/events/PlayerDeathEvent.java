package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.rings.ItemRingUndying;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosAPI;

public class PlayerDeathEvent {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onLivingDeath(LivingDeathEvent event) {
        if(!ConfigHolder.ringUndying) return;
        if(!(event.getEntityLiving() instanceof ServerPlayerEntity)) return;

        ServerPlayerEntity player = (ServerPlayerEntity) event.getEntityLiving();

        if(CuriosAPI.getCurioEquipped(ModItems.ringUndying, event.getEntityLiving()).isPresent()) {
            ItemStack ring = CuriosAPI.getCurioEquipped(ModItems.ringUndying, event.getEntityLiving()).get().right;

            if(player.getCooldownTracker().hasCooldown(ring.getItem())) return;

            event.setCanceled(true);

            player.addStat(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING));
            CriteriaTriggers.USED_TOTEM.trigger(player, ring);

            ((ItemRingUndying)ring.getItem()).setCooldown(player);

            player.setHealth(1.0F);
            player.clearActivePotions();
            player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 800, 0));
            player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 900, 1));
            player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 100, 1));

            player.world.setEntityState(player, (byte) 35);

            if(player.world.isRemote) Minecraft.getInstance().gameRenderer.displayItemActivation(ring);
        }
    }

}
