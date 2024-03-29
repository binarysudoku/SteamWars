package steamwars.proxies;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import steamwars.items.Items;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler
	{
	
	public void onPlayerTick(EntityPlayer player)
		{
		if (player.getCurrentItemOrArmor(4) != null)
			{
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			
			if (helmet.getItem() == Items.ghostGoggles)
				{
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 30, 0));
				}
			}
		}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
		{
		if (type.equals(EnumSet.of(TickType.PLAYER)))
			{
			onPlayerTick((EntityPlayer) tickData[0]);
			}
		}
	
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
		{
		// TODO Auto-generated method stub
		
		}
	
	@Override
	public EnumSet<TickType> ticks()
		{
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
		}
	
	@Override
	public String getLabel()
		{
		// TODO Auto-generated method stub
		return null;
		}
	
	}
