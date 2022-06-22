package com.focamacho.ringsofascension;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import com.focamacho.ringsofascension.events.ApplyPotionEvent;
import com.focamacho.ringsofascension.events.LootTableEvent;
import com.focamacho.ringsofascension.events.PlayerDeathEvent;
import com.focamacho.ringsofascension.events.TooltipEvent;
import com.focamacho.ringsofascension.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
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

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModItems.init(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(new LootTableEvent());
        MinecraftForge.EVENT_BUS.register(new PlayerDeathEvent());
        MinecraftForge.EVENT_BUS.register(new ApplyPotionEvent());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new TooltipEvent());
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("ring").size(2).build());
    }

    public static final CreativeModeTab tabGroup = new CreativeModeTab("ringsofascension") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ringExperience.get());
        }

    };


    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onModConfigEvent(final ModConfigEvent event) {
            final ModConfig config = event.getConfig();

            if (config.getSpec() == ConfigRingsOfAscension.spec) {
                ConfigHolder.updateConfigs();
            }
        }

    }
}
