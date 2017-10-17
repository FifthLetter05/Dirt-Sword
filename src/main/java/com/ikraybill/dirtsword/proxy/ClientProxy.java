package com.ikraybill.dirtsword.proxy;

import com.ikraybill.dirtsword.client.settings.Keybindings;
import com.ikraybill.dirtsword.init.ModItems;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        ModItems.initModels();
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
    }
}
