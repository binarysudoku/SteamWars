package steamwars.proxies;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy
	{
	public void initRenderers()
		{
		
		}
	
	public void initSounds()
		{
		
		}
	
	public void registerRenderInformation()
		{
		// No rendering for servers.
		}
	
	public void registerServerTickHandler()
		{
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
		}
	}