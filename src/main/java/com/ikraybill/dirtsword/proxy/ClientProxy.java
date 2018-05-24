package com.ikraybill.dirtsword.proxy;

import com.ikraybill.dirtsword.client.settings.Keybindings;
import com.ikraybill.dirtsword.init.ModItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        //ModItems.initModels();
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        ModItems.initModels();
    }
}
