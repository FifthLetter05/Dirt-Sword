package com.ikraybill.dirtsword.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes
{
    public static void init()
    {
        // dirt sword recipe
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.dirtSword),
                "d", "d", "s",
                'd', "dirt", 's', "stickWood"));
    }
}
