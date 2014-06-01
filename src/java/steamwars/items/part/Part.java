package steamwars.items.part;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import steamwars.SteamWars;
import steamwars.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Part extends Item
	{
	public Part(int id, String unlocalizedName)
		{
		super(id);
		setCreativeTab(SteamWars.tabSteamwars);
		setMaxStackSize(64);
		setUnlocalizedName(unlocalizedName);
		}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
		{
		return true;
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
		this.itemIcon = icon.registerIcon(ModInfo.ID + ":/part/" + this.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
		}
	}