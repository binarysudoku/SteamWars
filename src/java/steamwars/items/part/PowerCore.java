package steamwars.items.part;

import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import steamwars.SteamWars;
import steamwars.entity.projectile.EntityPowerCore;
import steamwars.items.Items;
import steamwars.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PowerCore extends Item
	{
	public PowerCore(int id)
		{
		super(id);
		setCreativeTab(SteamWars.tabSteamwars);
		setMaxStackSize(64);
		setUnlocalizedName("powerCore");
		}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName)
		{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
		}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
		{
		if (!par2World.isRemote)
			{
			EntityPowerCore entitycore = new EntityPowerCore(par2World, par3EntityPlayer);
			par2World.spawnEntityInWorld(entitycore);
			par3EntityPlayer.inventory.consumeInventoryItem(Items.powerCore.itemID);
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
			}
		return par1ItemStack;
		}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
		{
		super.registerIcons(icon);
		this.itemIcon = icon.registerIcon(ModInfo.ID + ":/part/" + this.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
		}
	}