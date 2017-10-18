package com.ikraybill.dirtsword.item;

import com.ikraybill.dirtsword.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
        if(!world.isRemote){
            //LogHelper.info();
            EntityLivingBase targetCopy[] = new EntityLivingBase[2];
            for (int i = 0; i < 2; i++) {
                targetCopy[i] = copyEntity(target, world);
                world.spawnEntityInWorld(targetCopy[i]);
            }
        }
        target.setHealth(0);
        if (!(attacker instanceof EntityPlayer && ((EntityPlayer) attacker).capabilities.isCreativeMode)) {
            stack.damageItem(2, attacker);
        }
        return super.hitEntity(stack, target, attacker);
    }

    private EntityLivingBase copyEntity(EntityLivingBase entity, World worldIn){

        Entity entityCopyBase = EntityList.createEntityByName(entity.getName(), worldIn);
        EntityLivingBase entityCopy = (EntityLivingBase) entityCopyBase;
        assert entityCopy != null;
        entityCopy.readEntityFromNBT(entity.serializeNBT());
        entityCopy.setPosition(entity.posX, entity.posY,entity.posZ);
        entityCopy.setHealth(entity.getMaxHealth());

        return entityCopy;
    }
}
