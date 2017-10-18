package com.ikraybill.dirtsword.item;

import com.ikraybill.dirtsword.reference.Reference;
import com.ikraybill.dirtsword.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.ikraybill.dirtsword.utility.Utility.copyEntity;

public class ItemDirtSword extends ItemSwordMT{


    public ItemDirtSword(){
        super(Reference.DIRT);
        String unlocalizedName = "dirtSword";
        setRegistryName(unlocalizedName);
        setUnlocalizedName(unlocalizedName);
        setMaxStackSize(1);
        GameRegistry.register(this);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        World world = target.worldObj;
        target.setHealth(0);
        if(!world.isRemote){
            LogHelper.info(target.getClass());
            EntityLivingBase targetCopy[] = new EntityLivingBase[2];
            for (int i = 0; i < 2; i++) {
                targetCopy[i] = copyEntity(target, world);
                world.spawnEntityInWorld(targetCopy[i]);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }
}
