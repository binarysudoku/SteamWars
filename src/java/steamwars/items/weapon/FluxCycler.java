package steamwars.items.weapon;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import steamwars.SteamWars;
import steamwars.entity.projectile.EntityFluxCyclerBullet;
import steamwars.items.Items;
import steamwars.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FluxCycler extends Item
	{
	
	public FluxCycler(int id)
		{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
		this.setCreativeTab(SteamWars.tabSteamwars);
		setUnlocalizedName("fluxCycler");
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
		return 32000;
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
		if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Items.fluxCyclerBullet.itemID))
			{
			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, "steamwars:flux.cyclershot", 1.0F, 1.0F / (itemRand.nextFloat() * 0.6F + 1.2F));
			
			par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
			if (!par2World.isRemote)
				{
				EntityFluxCyclerBullet entitybullet = new EntityFluxCyclerBullet(par2World, par3EntityPlayer);
				par2World.spawnEntityInWorld(entitybullet);
				par3EntityPlayer.inventory.consumeInventoryItem(Items.fluxCyclerBullet.itemID);
				}
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
			}
		else
			{
			par2World.playSoundAtEntity(par3EntityPlayer, "steamwars:flux.empty", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
			}
		
		return par1ItemStack;
		}
	
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
		{
		par2World.playSoundAtEntity(par3EntityPlayer, "steamwars:flux.cyclerpowerdown", 0.8F, 1.0F / (itemRand.nextFloat() * 0.6F + 1.2F));
		}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName)
		{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
		}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
		{
		super.registerIcons(icon);
		this.itemIcon = icon.registerIcon(ModInfo.ID + ":/weapon/" + this.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
		}
	}