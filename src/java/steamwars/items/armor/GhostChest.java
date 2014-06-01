package steamwars.items.armor;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import steamwars.SteamWars;
import steamwars.items.Items;
import steamwars.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GhostChest extends ItemArmor
	{
	// private String texturePath = ModInfo.ID +
	// ":/textures/models/armor/ghostGear_layer_1.png";
	private boolean hasWard;
	
	public GhostChest(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String name)
		{
		super(par1, par2EnumArmorMaterial, par3, par4);
		
		this.setMaxStackSize(1);
		this.setCreativeTab(SteamWars.tabSteamwars);
		this.setNoRepair();
		this.setUnlocalizedName(name);
		this.setWard(false);
		}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName)
		{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
		}
	
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
		{
		if (itemstack.itemID == Items.ghostGoggles.itemID || itemstack.itemID == Items.ghostChest.itemID || itemstack.itemID == Items.ghostBoots.itemID)
			{
			return ModInfo.ID + ":/textures/models/armor/ghostGear_layer_1.png";
			}
		else if (itemstack.itemID == Items.ghostLegs.itemID)
			{
			return ModInfo.ID + ":/textures/models/armor/ghostGear_layer_2.png";
			}
		else
			{
			return ModInfo.ID + ":/textures/models/armor/ghostGear_layer_2.png";
			}
		}
	
	public void setWard(boolean set)
		{
		this.hasWard = set;
		}
	
	public boolean getWard()
		{
		return this.hasWard;
		}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
		{
		super.registerIcons(icon);
		this.itemIcon = icon.registerIcon(ModInfo.ID + ":/misc/" + this.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
		}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
		{
		list.add("§5Abraxas Ward");
		}
	}