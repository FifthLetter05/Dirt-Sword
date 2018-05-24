package com.ikraybill.dirtsword.proxy;

import com.ikraybill.dirtsword.handler.ConfigurationHandler;
import com.ikraybill.dirtsword.init.ModItems;
import com.ikraybill.dirtsword.init.Recipes;
import com.ikraybill.dirtsword.item.ItemDirtSword;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        //ModItems.init();
    }

    public void init(FMLInitializationEvent event) {
        //FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        Recipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
