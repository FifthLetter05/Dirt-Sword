package com.ikraybill.dirtsword.utility;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.lang.reflect.InvocationTargetException;

public class Utility {

    public static EntityLivingBase copyEntity(EntityLivingBase entity, World world){
        try {
            EntityLivingBase entityCopy = entity.getClass().getConstructor(World.class).newInstance(world);
            entityCopy.setPosition(entity.posX, entity.posY,entity.posZ);
            entityCopy.setHeldItem(EnumHand.MAIN_HAND,entity.getHeldItemMainhand());
            entityCopy.setHeldItem(EnumHand.OFF_HAND,entity.getHeldItemOffhand());
            entityCopy.setItemStackToSlot(EntityEquipmentSlot.FEET,entity.getItemStackFromSlot(EntityEquipmentSlot.FEET));
            entityCopy.setItemStackToSlot(EntityEquipmentSlot.LEGS,entity.getItemStackFromSlot(EntityEquipmentSlot.LEGS));
            entityCopy.setItemStackToSlot(EntityEquipmentSlot.CHEST,entity.getItemStackFromSlot(EntityEquipmentSlot.CHEST));
            entityCopy.setItemStackToSlot(EntityEquipmentSlot.HEAD,entity.getItemStackFromSlot(EntityEquipmentSlot.HEAD));
            if (entity instanceof EntityZombie){
                ((EntityZombie)entityCopy).setVillagerType(((EntityZombie) entity).getVillagerTypeForge());
                ((EntityZombie)entityCopy).setChild(entity.isChild());
                ((EntityZombie)entityCopy).setZombieType(((EntityZombie) entity).getZombieType());
            }
            if (entity instanceof EntitySkeleton){
                ((EntitySkeleton)entityCopy).setSkeletonType(((EntitySkeleton) entity).getSkeletonType());
            }
            if (entity instanceof EntityAgeable){
                ((EntityAgeable)entityCopy).setGrowingAge(((EntityAgeable) entity).getGrowingAge());
            }
            if (entity instanceof EntityVillager){
                ((EntityVillager)entityCopy).setProfession(((EntityVillager) entity).getProfessionForge());
            }
            return entityCopy;
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
