package com.ikraybill.dirtsword.item;

import com.ikraybill.dirtsword.creativetab.CreativeTabMT;
import com.ikraybill.dirtsword.reference.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDirtSword extends ItemSword {


    public ItemDirtSword(){
        super(Reference.DIRT);
        setCreativeTab(CreativeTabMT.MT_TAB);
        String unlocalizedName = "dirt_sword";
        setRegistryName(unlocalizedName);
        setUnlocalizedName(unlocalizedName);
        setMaxStackSize(1);
        GameRegistry.register(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));

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
