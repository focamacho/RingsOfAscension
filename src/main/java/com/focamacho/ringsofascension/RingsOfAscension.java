package com.focamacho.ringsofascension;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.events.ApplyPotionEvent;
import com.focamacho.ringsofascension.events.LootTableEvent;
import com.focamacho.ringsofascension.events.PlayerDeathEvent;
import com.focamacho.ringsofascension.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;

@Mod("ringsofascension")
public class RingsOfAscension {

    public static final String MODID = "ringsofascension";

    private static final Logger LOGGER = LogManager.getLogger();

    public RingsOfAscension() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigRingsOfAscension.spec);
        ConfigHolder.updateConfigs();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(new LootTableEvent());
        MinecraftForge.EVENT_BUS.register(new PlayerDeathEvent());
        MinecraftForge.EVENT_BUS.register(new ApplyPotionEvent());
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("ring").size(2).build());
    }

    private void processIMC(final InterModProcessEvent event) {

    }

    public static final ItemGroup tabGroup = new ItemGroup("ringsofascension") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ringExperience);
        }

    };


    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {

        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
            ModItems.allItems.forEach(item -> event.getRegistry().register(item));
        }

        @SubscribeEvent
        public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
            final ModConfig config = event.getConfig();

            if (config.getSpec() == ConfigRingsOfAscension.spec) {
                ConfigHolder.updateConfigs();
            }
        }

    }
}
