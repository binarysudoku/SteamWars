package steamwars.lib;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class Sounds
	{
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
		{
		// pulse
		event.manager.addSound("steamwars:pulse/empty.ogg");
		event.manager.addSound("steamwars:pulse/pistolcharge.ogg");
		event.manager.addSound("steamwars:pulse/pistolshot.ogg");
		event.manager.addSound("steamwars:pulse/pistolhit.ogg");
		
		event.manager.addSound("steamwars:pulse/riflecharge.ogg");
		// flux
		event.manager.addSound("steamwars:flux/empty.ogg");
		event.manager.addSound("steamwars:flux/pistolshot.ogg");
		event.manager.addSound("steamwars:flux/pistolhit.ogg");
		event.manager.addSound("steamwars:flux/cyclershot.ogg");
		event.manager.addSound("steamwars:flux/cyclerpowerdown.ogg");
		// plasma
		//event.manager.addSound("steamwars:plasma/empty.ogg");
		event.manager.addSound("steamwars:plasma/pistolcharge.ogg");
		event.manager.addSound("steamwars:plasma/pistolshot.ogg");
		//event.manager.addSound("steamwars:plasma/pistolhit.ogg");
		
		// psi
		event.manager.addSound("steamwars:arc/empty.ogg");
		// arc
		event.manager.addSound("steamwars:arc/empty.ogg");
		event.manager.addSound("steamwars:arc/pistolshot.ogg");
		
		event.manager.addSound("steamwars:arc/castershot.ogg");
		
		event.manager.addSound("steamwars:arc/cannoncharge.ogg");
		event.manager.addSound("steamwars:arc/cannonshot.ogg");
		// sonic
		
		// misc
		event.manager.addSound("steamwars:misc/coresplode.ogg");
		}
	}