package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.List;

public class ItemRingExperience extends ItemRingBase {

    public ItemRingExperience(String name, int tier, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if(entity instanceof PlayerEntity player && !player.world.isClient && !player.isSneaking()) {
            int range = 5;
            BlockPos pos = player.getBlockPos();
            List<ExperienceOrbEntity> entities = player.world.getEntitiesByClass(ExperienceOrbEntity.class, new Box(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range), experienceOrbEntity -> true);
            for(ExperienceOrbEntity orb : entities) {
                if(orb.isAlive()) {
                    orb.onPlayerCollision(player);
                }
            }
        }
    }

}