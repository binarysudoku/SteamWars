package steamwars;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
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
import steamwars.items.Items;
import steamwars.lib.ModInfo;
import steamwars.lib.TabSteamWars;
import steamwars.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SteamWars
	{
	public static final String PROXY_LOCATION = "steamwars.proxies";
	
	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy", serverSide = ModInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs tabSteamwars = new TabSteamWars("tabSteamwars");

	public static EnumArmorMaterial steamTech;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
		{
		proxy.initRenderers();
		proxy.initSounds();
		}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
		{
		Items.init();
		Items.addNames();
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabSteamwars", "en_US", "Steam Wars");
		}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
		{
		steamTech = EnumHelper.addArmorMaterial("SteamTech", 12, new int[] {1, 3, 2, 1}, 25);
		
		int i = 0;
		// pulse
		EntityRegistry.registerModEntity(EntityPulsePistolBullet.class, "Pulse Pistol Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitypulsepistolbullet", "Pulse Pistol Bullet");
		EntityRegistry.registerModEntity(EntityPulseBlasterBullet.class, "Pulse Blaster Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitypulseblasterbullet", "Pulse Blaster Bullet");
		EntityRegistry.registerModEntity(EntityPulseRifleBullet.class, "Pulse Rifle Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitypulseriflebullet", "Pulse Rifle Bullet");
		// flux
		EntityRegistry.registerModEntity(EntityFluxPistolBullet.class, "Flux Pistol Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entityfluxpistolbullet", "Flux Pistol Bullet");
		EntityRegistry.registerModEntity(EntityFluxBolterBullet.class, "Flux Bolter Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entityfluxbolterbullet", "Flux Bolter Bullet");
		EntityRegistry.registerModEntity(EntityFluxCyclerBullet.class, "Flux Cycler Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entityfluxcyclerbullet", "Flux Cycler Bullet");
		// plasma
		EntityRegistry.registerModEntity(EntityPlasmaPistolBullet.class, "Plasma Pistol Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entityplasmapistolbullet", "Plasma Pistol Bullet");
		EntityRegistry.registerModEntity(EntityPlasmaGunBullet.class, "Plasma Gun Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entityplasmagunbullet", "Plasma Gun Bullet");
		EntityRegistry.registerModEntity(EntityPlasmaCannonBullet.class, "Plasma Cannon Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entityplasmacannonbullet", "Plasma Cannon Bullet");
		// psi
		EntityRegistry.registerModEntity(EntityPsiPistolBullet.class, "Psi Pistol Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitypsipistolbullet", "Psi Pistol Bullet");
		EntityRegistry.registerModEntity(EntityPsiGunBullet.class, "Psi Gun Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitypsigunbullet", "Psi Gun Bullet");
		EntityRegistry.registerModEntity(EntityPsiCannonBullet.class, "Psi Cannon Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitypsicannonbullet", "Psi Blaster Bullet");
		// arc
		EntityRegistry.registerModEntity(EntityArcPistolBullet.class, "Arc Pistol Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitypulsepistolbullet", "Arc Pistol Bullet");
		EntityRegistry.registerModEntity(EntityArcCasterBullet.class, "Arc Caster Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entityarccasterbullet", "Arc Caster Bullet");
		EntityRegistry.registerModEntity(EntityArcCannonBullet.class, "Arc Cannon Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entityarccannonbullet", "Arc Cannon Bullet");
		// sonic
		EntityRegistry.registerModEntity(EntitySonicPistolBullet.class, "Sonic Pistol Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitysonicpistolbullet", "Sonic Pistol Bullet");
		EntityRegistry.registerModEntity(EntitySonicBlasterBullet.class, "Sonic Blaster Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitysonicblasterbullet", "Sonic Blaster Bullet");
		EntityRegistry.registerModEntity(EntitySonicThumperBullet.class, "Sonic Thumper Bullet", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitysonicthumperbullet", "Sonic Cannon Bullet");
		// misc
		EntityRegistry.registerModEntity(EntityPowerCore.class, "Power Core", ++i, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("steamwars.projectile.entitypowercore", "Power Core");
		
		// entities
		EntityRegistry.registerModEntity(EntityGhost.class, "entityghost", ++i, this, 80, 3, true);
		registerEntityEgg(EntityGhost.class, i, 0xAAAAAA, 0xAAAAAA);
		EntityRegistry.addSpawn(EntityGhost.class, 0, 0, 4, EnumCreatureType.ambient, BiomeGenBase.forest, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.taiga);
		LanguageRegistry.instance().addStringLocalization("entity.steamwars.entityghost.name", "Apparition");
		
		proxy.registerRenderInformation();
		proxy.registerServerTickHandler();
		}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
		{
		}
	
	private void registerEntityEgg(Class<? extends Entity> entity, int id, int i, int j)
		{
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, i, j));
		}
	}