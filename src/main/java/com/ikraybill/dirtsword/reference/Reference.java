package com.ikraybill.dirtsword.reference;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class Reference
{
    public static final String MOD_ID = "dirtsword";
    public static final String MOD_NAME = "Dirt Sword Mod";
    public static final String VERSION = "1.2.1";
    public static final String ACCEPTED_MC_VERSIONS = "[1.10.2]";
    public static final Item.ToolMaterial DIRT = EnumHelper.addToolMaterial("DIRT",3, 0,1.0F,9999.0F, 30);

    public static final String CLIENT_PROXY_CLASS = "com.ikraybill.dirtsword.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.ikraybill.dirtsword.proxy.ServerProxy";
    public static final String GUI_FACTORY_CLASS = "com.ikraybill.dirtsword.client.gui.GuiFactory";
}
