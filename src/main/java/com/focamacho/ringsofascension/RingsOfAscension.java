package com.focamacho.ringsofascension;

import com.focamacho.ringsofascension.config.Config;
import com.focamacho.ringsofascension.events.ApplyPotionEvent;
import com.focamacho.ringsofascension.events.PlayerDeathEvent;
import com.focamacho.ringsofascension.init.ModItems;
import com.focamacho.ringsofascension.loot.RingsLootModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;

@Mod("ringsofascension")
public class RingsOfAscension {

    public static final String MODID = "ringsofascension";

    public RingsOfAscension() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.spec);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCreativeTab);

        ModItems.init(FMLJavaModLoadingContext.get().getModEventBus());
        RingsLootModifier.REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(new PlayerDeathEvent());
        MinecraftForge.EVENT_BUS.register(new ApplyPotionEvent());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("ring").size(2).build());
    }

    public void onCreativeTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MODID, "creative_tab"), (builder) ->
                builder.title(Component.translatable("itemGroup.ringsofascension"))
                        .icon(() -> new ItemStack(ModItems.ringExperience.get()))
                        .displayItems((params, output) ->
                                ModItems.allRings.forEach(
                                        output::accept
                                )
                        )
        );
    }

}
