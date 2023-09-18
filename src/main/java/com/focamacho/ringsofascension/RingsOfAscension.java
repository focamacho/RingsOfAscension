package com.focamacho.ringsofascension;

import com.focamacho.ringsofascension.config.Config;
import com.focamacho.ringsofascension.events.ApplyPotionEvent;
import com.focamacho.ringsofascension.events.PlayerDeathEvent;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.loot.RingsLootModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod("ringsofascension")
public class RingsOfAscension {

    public static final String MODID = "ringsofascension";
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TAB_REGISTRY
            .register("creative_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ringsofascension"))
                    .icon(() -> new ItemStack(ModItems.ringExperience.get()))
                    .displayItems((params, output) -> {
                        for (Item entry : ModItems.allRings) {
                            output.accept(entry);
                        }
                    })
                    .build());

    public RingsOfAscension() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.spec);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModItems.init(FMLJavaModLoadingContext.get().getModEventBus());
        RingsLootModifier.REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
        CREATIVE_MODE_TAB_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(new PlayerDeathEvent());
        MinecraftForge.EVENT_BUS.register(new ApplyPotionEvent());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {}

}
