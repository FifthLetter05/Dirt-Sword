package com.ikraybill.dirtsword.init;

import com.ikraybill.dirtsword.item.*;
import com.ikraybill.dirtsword.reference.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static ItemSwordMT dirtSword;

    public static void init()
    {
        dirtSword = new ItemDirtSword();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        dirtSword.initModel();
    }
}
