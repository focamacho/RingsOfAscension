package com.focamacho.ringsofascension.events;

import com.focamacho.ringsofascension.RingsOfAscension;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableEvent {

    @SubscribeEvent
    public void onLoadTable(LootTableLoadEvent event) {
        if(event.getName().equals(new ResourceLocation("minecraft", "chests/simple_dungeon"))) {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(RingsOfAscension.MODID,"chests/simple_dungeon"))).build());
        }
    }

}
