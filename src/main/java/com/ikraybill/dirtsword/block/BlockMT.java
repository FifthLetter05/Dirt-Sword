package com.ikraybill.dirtsword.block;

import com.ikraybill.dirtsword.creativetab.CreativeTabMT;
import com.ikraybill.dirtsword.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMT extends Block
{
    public BlockMT(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabMT.MT_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
