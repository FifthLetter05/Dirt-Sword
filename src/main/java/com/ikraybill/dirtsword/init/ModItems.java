package com.ikraybill.dirtsword.init;

import com.ikraybill.dirtsword.item.*;
import com.ikraybill.dirtsword.reference.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModItems {
    public static ItemDirtSword dirtSword = new ItemDirtSword();

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        dirtSword.initModel();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(new ItemDirtSword());
    }
}
