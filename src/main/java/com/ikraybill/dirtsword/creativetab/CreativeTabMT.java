package com.ikraybill.dirtsword.creativetab;

import com.ikraybill.dirtsword.init.ModItems;
import com.ikraybill.dirtsword.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabMT {
    public static final CreativeTabs MT_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.dirtSword);
        }
    };
}
