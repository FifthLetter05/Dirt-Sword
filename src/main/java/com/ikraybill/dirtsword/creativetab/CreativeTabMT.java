package com.ikraybill.dirtsword.creativetab;

import com.ikraybill.dirtsword.reference.Reference;
import com.ikraybill.dirtsword.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMT {
    public static final CreativeTabs MT_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return ModItems.dirtSword;
        }
    };
}
