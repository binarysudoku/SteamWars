package steamwars.items.weapon;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import steamwars.SteamWars;
import steamwars.entity.projectile.EntityPsiCannonBullet;
import steamwars.items.Items;
import steamwars.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PsiCannon extends Item
	{
	
	public PsiCannon(int id)
		{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
		this.setCreativeTab(SteamWars.tabSteamwars);
		setUnlocalizedName("psiCannon");
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
		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
			{
			return event.result;
			}
		par2World.playSoundAtEntity(par3EntityPlayer, "steamwars:pulse.pistolcharge", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
		
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		
		return par1ItemStack;
		}
	
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
		{
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
		
		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
			{
			return;
			}
		j = event.charge;
		
		float f = (float) j / 20.0F;
		
		f = (f * f + f * 2.0F) / 3.0F;
		
		if ((double) f < 0.1D)
			{
			return;
			}
		
		if (f > 1.0F)
			{
			f = 1.0F;
			}
		
		if (f > 0.5F)
			{
			if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Items.psiCannonBullet.itemID))
				{
				par1ItemStack.damageItem(1, par3EntityPlayer);
				par2World.playSoundAtEntity(par3EntityPlayer, "steamwars:pulse.pistolshot", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
				
				par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
				if (!par2World.isRemote)
					{
					EntityPsiCannonBullet entitybullet = new EntityPsiCannonBullet(par2World, par3EntityPlayer);
					entitybullet.setDamage(f);
					par2World.spawnEntityInWorld(entitybullet);
					par3EntityPlayer.inventory.consumeInventoryItem(Items.psiCannonBullet.itemID);
					}
				}
			else
				{
				par2World.playSoundAtEntity(par3EntityPlayer, "steamwars:pulse.empty", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
				}
			}
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