package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.item.Item;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.RandomValueRange;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableEvent {

    @SubscribeEvent
    public void onLoadTable(LootTableLoadEvent event) {
        LootPool.Builder builder = LootPool.builder().rolls(RandomValueRange.of(ConfigHolder.ringMinLoot, ConfigHolder.ringMaxLoot)).name("rings_of_ascension_pool");
        boolean add = false;

        for(Item item : ModItems.allItems) {
            if(!(item instanceof ItemRingBase)) continue;
            ItemRingBase ring = (ItemRingBase) item;
            if(ring.isEnabled()) {
                if(ring.getLocations().contains(event.getName())) {
                    builder.addEntry(ItemLootEntry.builder(() -> item).weight(getWeightFromTier(ring.getTier())));
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
