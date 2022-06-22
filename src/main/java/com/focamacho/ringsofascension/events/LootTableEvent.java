package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableEvent {

    @SubscribeEvent
    public void onLoadTable(LootTableLoadEvent event) {
        LootPool.Builder builder = LootPool.lootPool().setRolls(UniformGenerator.between(ConfigHolder.ringMinLoot, ConfigHolder.ringMaxLoot)).name("rings_of_ascension_pool");
        boolean add = false;

        for(ItemRingBase item : ModItems.allRings) {
            if(item == null) continue;
            ItemRingBase ring = item;
            if(ring.isEnabled()) {
                if(ring.getLocations().contains(event.getName())) {
                    builder.add(LootItem.lootTableItem(() -> item).setWeight(getWeightFromTier(ring.getTier())));
                    add = true;
                }
            }
        }

        if(add) event.getTable().addPool(builder.build());
    }

    private int getWeightFromTier(int tier) {
        switch(tier) {
            case 0:
                return 20;
            case 1:
                return 15;
            case 2:
                return 10;
            case 3:
                return 5;
            case 4:
                return 1;
        }
        return 20;
    }

}
