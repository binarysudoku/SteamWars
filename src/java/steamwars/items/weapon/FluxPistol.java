package steamwars.items.weapon;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import steamwars.SteamWars;
import steamwars.entity.projectile.EntityFluxPistolBullet;
import steamwars.items.Items;
import steamwars.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FluxPistol extends Item
	{
	private double fired;
	
	public FluxPistol(int id)
		{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
		this.setCreativeTab(SteamWars.tabSteamwars);
		setUnlocalizedName("fluxPistol");
		this.fired = 0;
		}
	
	public boolean isFull3D()
		{
		return true;
		}
	
	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
		{
		return 64000;
		}
	
	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
		{
		return EnumAction.bow;
		}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
		{
		if (this.fired <= 4)
			{
			if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Items.fluxPistolBullet.itemID))
				{
				par1ItemStack.damageItem(1, par3EntityPlayer);
				par2World.playSoundAtEntity(par3EntityPlayer, "steamwars:flux.pistolshot", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
				
				par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
				if (!par2World.isRemote)
					{
					EntityFluxPistolBullet entitybullet = new EntityFluxPistolBullet(par2World, par3EntityPlayer);
					par2World.spawnEntityInWorld(entitybullet);
					par3EntityPlayer.inventory.consumeInventoryItem(Items.fluxPistolBullet.itemID);
					}
				par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
				}
			else
				{
				par2World.playSoundAtEntity(par3EntityPlayer, "steamwars:flux.empty", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
				}
			this.fired += 2;
			}
		return par1ItemStack;
		}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName)
		{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
		}
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
		{		
		if (this.fired > 0)
			{
			this.fired -= 0.1;
			}
		if (this.fired <= 0)
			{
			this.fired = 0;
			}
		}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
		{
		super.registerIcons(icon);
		this.itemIcon = icon.registerIcon(ModInfo.ID + ":/weapon/" + this.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
		}
	}