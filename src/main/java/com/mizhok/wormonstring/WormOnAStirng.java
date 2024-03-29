package com.mizhok.wormonstring;

import com.google.common.eventbus.Subscribe;
import com.mizhok.wormonstring.block.ModBlocks;
import com.mizhok.wormonstring.block.WormIron;
import com.mizhok.wormonstring.setup.ClientProxy;
import com.mizhok.wormonstring.setup.IProxy;
import com.mizhok.wormonstring.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value
// here should match an entry in the META-INF/mods.toml file
@Mod("wormonastring")
public class WormOnAStirng
{

    //runs code depending on which proxy side.
    //i dont think we have to understand it yet.
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () ->  new ServerProxy());


    private static final Logger LOGGER = LogManager.getLogger();

    public WormOnAStirng() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }


    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)

    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new WormIron());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(ModBlocks.WORMIRON, new Item.Properties()).setRegistryName("wormiron"));
        }
    }
}
