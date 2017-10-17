package com.ikraybill.dirtsword.item;

import com.ikraybill.dirtsword.reference.Reference;
import com.ikraybill.dirtsword.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
        World world = attacker.worldObj;
        target.setHealth(0);
        if(!world.isRemote){
            LogHelper.info(target.getClass());
            Class<? extends EntityLivingBase> targetClass = target.getClass();
            Constructor<?> targetConstructor;
            EntityLivingBase targetCopy[] = new EntityLivingBase[2];
            for (int i = 0; i < 2; i++) {
                try{
                    targetConstructor = targetClass.getConstructor(World.class);
                    targetCopy[i] = (EntityLivingBase)targetConstructor.newInstance(world);
                } catch (IllegalAccessException e) {
                    LogHelper.error("illegal access");
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    LogHelper.error("can't instantiate");
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    LogHelper.error("invocation error");
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    LogHelper.error("No such method");
                    e.printStackTrace();
                } finally {
                    targetCopy[i].setPosition(target.posX, target.posY,target.posZ);
                    targetCopy[i].setHeldItem(EnumHand.MAIN_HAND,target.getHeldItemMainhand());
                    targetCopy[i].setHeldItem(EnumHand.OFF_HAND,target.getHeldItemOffhand());
                    targetCopy[i].setItemStackToSlot(EntityEquipmentSlot.FEET,target.getItemStackFromSlot(EntityEquipmentSlot.FEET));
                    targetCopy[i].setItemStackToSlot(EntityEquipmentSlot.LEGS,target.getItemStackFromSlot(EntityEquipmentSlot.LEGS));
                    targetCopy[i].setItemStackToSlot(EntityEquipmentSlot.CHEST,target.getItemStackFromSlot(EntityEquipmentSlot.CHEST));
                    targetCopy[i].setItemStackToSlot(EntityEquipmentSlot.HEAD,target.getItemStackFromSlot(EntityEquipmentSlot.HEAD));
                    if (target instanceof EntityZombie){
                        ((EntityZombie)targetCopy[i]).setVillagerType(((EntityZombie) target).getVillagerTypeForge());
                        ((EntityZombie)targetCopy[i]).setChild(target.isChild());
                        ((EntityZombie)targetCopy[i]).setZombieType(((EntityZombie) target).getZombieType());
                    }
                    if (target instanceof EntitySkeleton){
                        ((EntitySkeleton)targetCopy[i]).setSkeletonType(((EntitySkeleton) target).getSkeletonType());
                    }
                    if (target instanceof EntityAgeable){
                        ((EntityAgeable)targetCopy[i]).setGrowingAge(((EntityAgeable) target).getGrowingAge());
                    }
                    world.spawnEntityInWorld(targetCopy[i]);
                }
            }
        }
        return super.hitEntity(stack, target, attacker);
    }
}
