package steamwars.proxies;

import net.minecraftforge.common.MinecraftForge;
import steamwars.entity.mob.EntityGhost;
import steamwars.entity.projectile.EntityArcCannonBullet;
import steamwars.entity.projectile.EntityArcCasterBullet;
import steamwars.entity.projectile.EntityArcPistolBullet;
import steamwars.entity.projectile.EntityFluxBolterBullet;
import steamwars.entity.projectile.EntityFluxCyclerBullet;
import steamwars.entity.projectile.EntityFluxPistolBullet;
import steamwars.entity.projectile.EntityPlasmaCannonBullet;
import steamwars.entity.projectile.EntityPlasmaGunBullet;
import steamwars.entity.projectile.EntityPlasmaPistolBullet;
import steamwars.entity.projectile.EntityPowerCore;
import steamwars.entity.projectile.EntityPsiCannonBullet;
import steamwars.entity.projectile.EntityPsiGunBullet;
import steamwars.entity.projectile.EntityPsiPistolBullet;
import steamwars.entity.projectile.EntityPulseBlasterBullet;
import steamwars.entity.projectile.EntityPulsePistolBullet;
import steamwars.entity.projectile.EntityPulseRifleBullet;
import steamwars.entity.projectile.EntitySonicBlasterBullet;
import steamwars.entity.projectile.EntitySonicPistolBullet;
import steamwars.entity.projectile.EntitySonicThumperBullet;
import steamwars.lib.Sounds;
import steamwars.model.ModelGhost;
import steamwars.render.RenderArcCannonBullet;
import steamwars.render.RenderArcCasterBullet;
import steamwars.render.RenderArcPistolBullet;
import steamwars.render.RenderFluxBolterBullet;
import steamwars.render.RenderFluxCyclerBullet;
import steamwars.render.RenderFluxPistolBullet;
import steamwars.render.RenderGhost;
import steamwars.render.RenderPlasmaCannonBullet;
import steamwars.render.RenderPlasmaGunBullet;
import steamwars.render.RenderPlasmaPistolBullet;
import steamwars.render.RenderPowerCore;
import steamwars.render.RenderPsiCannonBullet;
import steamwars.render.RenderPsiGunBullet;
import steamwars.render.RenderPsiPistolBullet;
import steamwars.render.RenderPulseBlasterBullet;
import steamwars.render.RenderPulsePistolBullet;
import steamwars.render.RenderPulseRifleBullet;
import steamwars.render.RenderSonicBlasterBullet;
import steamwars.render.RenderSonicPistolBullet;
import steamwars.render.RenderSonicThumperBullet;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
	{
	public void registerRenderInformation()
		{
		// pulse
		RenderingRegistry.registerEntityRenderingHandler(EntityPulsePistolBullet.class, new RenderPulsePistolBullet(0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPulseBlasterBullet.class, new RenderPulseBlasterBullet(0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPulseRifleBullet.class, new RenderPulseRifleBullet(0.3F));
		// flux
		RenderingRegistry.registerEntityRenderingHandler(EntityFluxPistolBullet.class, new RenderFluxPistolBullet(0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFluxBolterBullet.class, new RenderFluxBolterBullet(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFluxCyclerBullet.class, new RenderFluxCyclerBullet(0.3F));
		// plasma
		RenderingRegistry.registerEntityRenderingHandler(EntityPlasmaPistolBullet.class, new RenderPlasmaPistolBullet(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPlasmaGunBullet.class, new RenderPlasmaGunBullet(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPlasmaCannonBullet.class, new RenderPlasmaCannonBullet(0.6F));
		// psi
		RenderingRegistry.registerEntityRenderingHandler(EntityPsiPistolBullet.class, new RenderPsiPistolBullet(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPsiGunBullet.class, new RenderPsiGunBullet(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPsiCannonBullet.class, new RenderPsiCannonBullet(0.5F));
		// arc
		RenderingRegistry.registerEntityRenderingHandler(EntityArcPistolBullet.class, new RenderArcPistolBullet(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityArcCasterBullet.class, new RenderArcCasterBullet(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityArcCannonBullet.class, new RenderArcCannonBullet(0.5F));
		// sonic
		RenderingRegistry.registerEntityRenderingHandler(EntitySonicPistolBullet.class, new RenderSonicPistolBullet(0.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySonicBlasterBullet.class, new RenderSonicBlasterBullet(0.6F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySonicThumperBullet.class, new RenderSonicThumperBullet(1.0F));
		// misc
		RenderingRegistry.registerEntityRenderingHandler(EntityPowerCore.class, new RenderPowerCore(1.0F));
		
		// mob
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderGhost(new ModelGhost(), 0.5F));
		
		MinecraftForge.EVENT_BUS.register(new Sounds());
		}
	}