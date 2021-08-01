package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.SlotReference;
import io.github.ladysnake.pal.AbilitySource;
import io.github.ladysnake.pal.Pal;
import io.github.ladysnake.pal.VanillaAbilities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemRingFlight extends ItemRingBase {

    public static final AbilitySource abilityFlightRing = Pal.getAbilitySource("ringsofascension", "ring_flight");

    public ItemRingFlight(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(entity instanceof PlayerEntity player && !player.isCreative() && !entity.getEntityWorld().isClient()) {
            abilityFlightRing.grantTo(player, VanillaAbilities.ALLOW_FLYING);
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(entity instanceof PlayerEntity player && !player.isCreative() && !entity.getEntityWorld().isClient()) {
            abilityFlightRing.revokeFrom(player, VanillaAbilities.ALLOW_FLYING);
        }
    }

}
