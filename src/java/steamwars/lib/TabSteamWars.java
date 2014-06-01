package steamwars.lib;

import steamwars.items.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabSteamWars extends CreativeTabs
	{
	
	public TabSteamWars(String tabLabel)
		{
		super(tabLabel);
		}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
		{
		return Items.sonicPistol;
		}
	}