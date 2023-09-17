package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.client.GlintRenderTypes;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingExperience extends ItemRingBase {

    public ItemRingExperience(Properties properties, String tooltip, int tier, boolean enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, tier, enabled, glintType);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!isEnabled) return;
        if(livingEntity instanceof Player && !livingEntity.level.isClientSide && !livingEntity.isCrouching()) {
            int range = 10;
            BlockPos pos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY(), livingEntity.getBlockZ());
            List<ExperienceOrb> entities = livingEntity.level.getEntitiesOfClass(ExperienceOrb.class, new AABB(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range));
            for(ExperienceOrb orb : entities) {
                if(orb.isAlive()) {
                    orb.playerTouch((Player)livingEntity);
                }
            }
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, @NotNull List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        if(!isEnabled) return;
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
