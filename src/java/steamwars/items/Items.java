package steamwars.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import steamwars.SteamWars;
import steamwars.items.armor.GhostBoots;
import steamwars.items.armor.GhostChest;
import steamwars.items.armor.GhostGoggles;
import steamwars.items.armor.GhostLegs;
import steamwars.items.armor.WarpChest;
import steamwars.items.part.Part;
import steamwars.items.part.PowerCore;
import steamwars.items.weapon.ArcCannon;
import steamwars.items.weapon.ArcCaster;
import steamwars.items.weapon.ArcPistol;
import steamwars.items.weapon.Bullet;
import steamwars.items.weapon.FluxBolter;
import steamwars.items.weapon.FluxCycler;
import steamwars.items.weapon.FluxPistol;
import steamwars.items.weapon.PlasmaCannon;
import steamwars.items.weapon.PlasmaGun;
import steamwars.items.weapon.PlasmaPistol;
import steamwars.items.weapon.PsiCannon;
import steamwars.items.weapon.PsiGun;
import steamwars.items.weapon.PsiPistol;
import steamwars.items.weapon.PulseBlaster;
import steamwars.items.weapon.PulsePistol;
import steamwars.items.weapon.PulseRifle;
import steamwars.items.weapon.SonicBlaster;
import steamwars.items.weapon.SonicPistol;
import steamwars.items.weapon.SonicThumper;
import steamwars.lib.Ids;
import steamwars.lib.Names;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items
	{
	// component
	public static Item calibrationMirror;
	public static Item dynamo;
	public static Item fluxFilter;
	public static Item focusCrystal;
	public static Item fusionCoil;
	public static Item handle;
	public static Item heatSink;
	public static Item phaseAmp;
	public static Item powerCore;
	public static Item projectorMatrix;
	public static Item resonator;
	public static Item thaumicCircuit;
	public static Item thaumicRelay;
	public static Item thaumValve;
	public static Item thaumWire;
	public static Item triggerAssembly;
	
	// weapon
	
	// weapon pulse
	public static Item pulsePistol;
	public static Item pulseBlaster;
	public static Item pulseRifle;
	// weapon flux
	public static Item fluxPistol;
	public static Item fluxBolter;
	public static Item fluxCycler;
	// weapon plasma
	public static Item plasmaPistol;
	public static Item plasmaGun;
	public static Item plasmaCannon;
	// weapon psi
	public static Item psiPistol;
	public static Item psiGun;
	public static Item psiCannon;
	// weapon arc
	public static Item arcPistol;
	public static Item arcCaster;
	public static Item arcCannon;
	// weapon sonic
	public static Item sonicPistol;
	public static Item sonicBlaster;
	public static Item sonicThumper;
	
	// ammo pulse
	public static Item pulsePistolBullet;
	public static Item pulseBlasterBullet;
	public static Item pulseRifleBullet;
	// ammo flux
	public static Item fluxPistolBullet;
	public static Item fluxBolterBullet;
	public static Item fluxCyclerBullet;
	// ammo plasma
	public static Item plasmaPistolBullet;
	public static Item plasmaGunBullet;
	public static Item plasmaCannonBullet;
	// ammo psi
	public static Item psiPistolBullet;
	public static Item psiGunBullet;
	public static Item psiCannonBullet;
	// ammo arc
	public static Item arcPistolBullet;
	public static Item arcCasterBullet;
	public static Item arcCannonBullet;
	// ammo sonic
	public static Item sonicPistolBullet;
	public static Item sonicBlasterBullet;
	public static Item sonicThumperBullet;
	
	// ghost tech
	
	public static ItemArmor ghostGoggles;
	public static ItemArmor ghostChest;
	public static ItemArmor ghostLegs;
	public static ItemArmor ghostBoots;
	
	public static ItemArmor warpChest;
	
	public static void init()
		{
		// component
		calibrationMirror = new Part(Ids.calibrationMirror, "calibrationMirror");
		dynamo = new Part(Ids.dynamo, "dynamo");
		fluxFilter = new Part(Ids.fluxFilter, "fluxFilter");
		focusCrystal = new Part(Ids.focusCrystal, "focusCrystal");
		fusionCoil = new Part(Ids.fusionCoil, "fusionCoil");
		handle = new Part(Ids.handle, "handle");
		heatSink = new Part(Ids.heatSink, "heatSink");
		phaseAmp = new Part(Ids.phaseAmp, "phaseAmp");
		powerCore = new PowerCore(Ids.powerCore);
		projectorMatrix = new Part(Ids.projectorMatrix, "projectorMatrix");
		resonator = new Part(Ids.resonator, "resonator");
		thaumicCircuit = new Part(Ids.thaumicCircuit, "thaumicCircuit");
		thaumicRelay = new Part(Ids.thaumicRelay, "thaumicRelay");
		thaumValve = new Part(Ids.thaumValve, "thaumValve");
		thaumWire = new Part(Ids.thaumWire, "thaumWire");
		triggerAssembly = new Part(Ids.triggerAssembly, "triggerAssembly");
		
		// weapon pulse
		pulsePistol = new PulsePistol(Ids.pulsePistol);
		pulseBlaster = new PulseBlaster(Ids.pulseBlaster);
		pulseRifle = new PulseRifle(Ids.pulseRifle);
		// weapon flux
		fluxPistol = new FluxPistol(Ids.fluxPistol);
		fluxBolter = new FluxBolter(Ids.fluxBolter);
		fluxCycler = new FluxCycler(Ids.fluxCycler);
		// weapon plasma
		plasmaPistol = new PlasmaPistol(Ids.plasmaPistol);
		plasmaGun = new PlasmaGun(Ids.plasmaGun);
		plasmaCannon = new PlasmaCannon(Ids.plasmaCannon);
		// weapon psi
		psiPistol = new PsiPistol(Ids.psiPistol);
		psiGun = new PsiGun(Ids.psiGun);
		psiCannon = new PsiCannon(Ids.psiCannon);
		// weapon arc
		arcPistol = new ArcPistol(Ids.arcPistol);
		arcCaster = new ArcCaster(Ids.arcCaster);
		arcCannon = new ArcCannon(Ids.arcCannon);
		// weapon sonic
		sonicPistol = new SonicPistol(Ids.sonicPistol);
		sonicBlaster = new SonicBlaster(Ids.sonicBlaster);
		sonicThumper = new SonicThumper(Ids.sonicThumper);
		
		// ammo pulse
		pulsePistolBullet = new Bullet(Ids.pulsePistolBullet, "pulsePistolBullet");
		pulseBlasterBullet = new Bullet(Ids.pulseBlasterBullet, "pulseBlasterBullet");
		pulseRifleBullet = new Bullet(Ids.pulseRifleBullet, "pulseRifleBullet");
		// ammo flux
		fluxPistolBullet = new Bullet(Ids.fluxPistolBullet, "fluxPistolBullet");
		fluxBolterBullet = new Bullet(Ids.fluxBolterBullet, "fluxBolterBullet");
		fluxCyclerBullet = new Bullet(Ids.fluxCyclerBullet, "fluxCyclerBullet");
		// ammo plasma
		plasmaPistolBullet = new Bullet(Ids.plasmaPistolBullet, "plasmaPistolBullet");
		plasmaGunBullet = new Bullet(Ids.plasmaGunBullet, "plasmaGunBullet");
		plasmaCannonBullet = new Bullet(Ids.plasmaCannonBullet, "plasmaCannonBullet");
		// ammo psi
		psiPistolBullet = new Bullet(Ids.psiPistolBullet, "psiPistolBullet");
		psiGunBullet = new Bullet(Ids.psiGunBullet, "psiGunBullet");
		psiCannonBullet = new Bullet(Ids.psiCannonBullet, "psiCannonBullet");
		// ammo arc
		arcPistolBullet = new Bullet(Ids.arcPistolBullet, "arcPistolBullet");
		arcCasterBullet = new Bullet(Ids.arcCasterBullet, "arcCasterBullet");
		arcCannonBullet = new Bullet(Ids.arcCannonBullet, "arcCannonBullet");
		// ammo sonic
		sonicPistolBullet = new Bullet(Ids.sonicPistolBullet, "sonicPistolBullet");
		sonicBlasterBullet = new Bullet(Ids.sonicBlasterBullet, "sonicBlasterBullet");
		sonicThumperBullet = new Bullet(Ids.sonicThumperBullet, "sonicThumperBullet");
		
		// ghost tech
		ghostGoggles = new GhostGoggles(Ids.ghostGoggles, SteamWars.steamTech, 0, 0, "ghostGoggles");
		ghostChest = new GhostChest(Ids.ghostChest, SteamWars.steamTech, 1, 1, "ghostChest");
		ghostLegs = new GhostLegs(Ids.ghostLegs, SteamWars.steamTech, 1, 2, "ghostLegs");
		ghostBoots = new GhostBoots(Ids.ghostBoots, SteamWars.steamTech, 1, 3, "ghostBoots");
		
		warpChest = new WarpChest(Ids.warpChest, SteamWars.steamTech, 1, 3, "warpChest");
		}
	
	public static void addNames()
		{
		// part
		LanguageRegistry.addName(calibrationMirror, Names.calibrationMirror_name);
		LanguageRegistry.addName(dynamo, Names.dynamo_name);
		LanguageRegistry.addName(fluxFilter, Names.fluxFilter_name);
		LanguageRegistry.addName(focusCrystal, Names.focusCrystal_name);
		LanguageRegistry.addName(fusionCoil, Names.fusionCoil_name);
		LanguageRegistry.addName(handle, Names.handle_name);
		LanguageRegistry.addName(heatSink, Names.heatSink_name);
		LanguageRegistry.addName(phaseAmp, Names.phaseAmp_name);
		LanguageRegistry.addName(powerCore, Names.powerCore_name);
		LanguageRegistry.addName(projectorMatrix, Names.projectorMatrix_name);
		LanguageRegistry.addName(resonator, Names.resonator_name);
		LanguageRegistry.addName(thaumicCircuit, Names.thaumicCircuit_name);
		LanguageRegistry.addName(thaumicRelay, Names.thaumicRelay_name);
		LanguageRegistry.addName(thaumValve, Names.thaumValve_name);
		LanguageRegistry.addName(thaumWire, Names.thaumWire_name);
		LanguageRegistry.addName(triggerAssembly, Names.triggerAssembly_name);
		
		// weapon pulse
		LanguageRegistry.addName(pulsePistol, Names.pulsePistol_name);
		LanguageRegistry.addName(pulseBlaster, Names.pulseBlaster_name);
		LanguageRegistry.addName(pulseRifle, Names.pulseRifle_name);
		// weapon flux
		LanguageRegistry.addName(fluxPistol, Names.fluxPistol_name);
		LanguageRegistry.addName(fluxBolter, Names.fluxBolter_name);
		LanguageRegistry.addName(fluxCycler, Names.fluxCycler_name);
		// weapon plasma
		LanguageRegistry.addName(plasmaPistol, Names.plasmaPistol_name);
		LanguageRegistry.addName(plasmaGun, Names.plasmaGun_name);
		LanguageRegistry.addName(plasmaCannon, Names.plasmaCannon_name);
		// weapon psi
		LanguageRegistry.addName(psiPistol, Names.psiPistol_name);
		LanguageRegistry.addName(psiGun, Names.psiGun_name);
		LanguageRegistry.addName(psiCannon, Names.psiCannon_name);
		// weapon arc
		LanguageRegistry.addName(arcPistol, Names.arcPistol_name);
		LanguageRegistry.addName(arcCaster, Names.arcCaster_name);
		LanguageRegistry.addName(arcCannon, Names.arcCannon_name);
		// weapon sonic
		LanguageRegistry.addName(sonicPistol, Names.sonicPistol_name);
		LanguageRegistry.addName(sonicBlaster, Names.sonicBlaster_name);
		LanguageRegistry.addName(sonicThumper, Names.sonicThumper_name);
		
		// ammo pulse
		LanguageRegistry.addName(pulsePistolBullet, Names.pulsePistolBullet_name);
		LanguageRegistry.addName(pulseBlasterBullet, Names.pulseBlasterBullet_name);
		LanguageRegistry.addName(pulseRifleBullet, Names.pulseRifleBullet_name);
		// ammo flux
		LanguageRegistry.addName(fluxPistolBullet, Names.fluxPistolBullet_name);
		LanguageRegistry.addName(fluxBolterBullet, Names.fluxBolterBullet_name);
		LanguageRegistry.addName(fluxCyclerBullet, Names.fluxCyclerBullet_name);
		// ammo plasma
		LanguageRegistry.addName(plasmaPistolBullet, Names.plasmaPistolBullet_name);
		LanguageRegistry.addName(plasmaGunBullet, Names.plasmaGunBullet_name);
		LanguageRegistry.addName(plasmaCannonBullet, Names.plasmaCannonBullet_name);
		// ammo psi
		LanguageRegistry.addName(psiPistolBullet, Names.psiPistolBullet_name);
		LanguageRegistry.addName(psiGunBullet, Names.psiGunBullet_name);
		LanguageRegistry.addName(psiCannonBullet, Names.psiCannonBullet_name);
		// ammo arc
		LanguageRegistry.addName(arcPistolBullet, Names.arcPistolBullet_name);
		LanguageRegistry.addName(arcCasterBullet, Names.arcCasterBullet_name);
		LanguageRegistry.addName(arcCannonBullet, Names.arcCannonBullet_name);
		// ammo sonic
		LanguageRegistry.addName(sonicPistolBullet, Names.sonicPistolBullet_name);
		LanguageRegistry.addName(sonicBlasterBullet, Names.sonicBlasterBullet_name);
		LanguageRegistry.addName(sonicThumperBullet, Names.sonicThumperBullet_name);
		
		// ghost tech
		LanguageRegistry.addName(ghostGoggles, Names.ghostGoggles_name);
		LanguageRegistry.addName(ghostChest, Names.ghostChest_name);
		LanguageRegistry.addName(ghostLegs, Names.ghostLegs_name);
		LanguageRegistry.addName(ghostBoots, Names.ghostBoots_name);
		
		LanguageRegistry.addName(warpChest, Names.warpChest_name);
		}
	
	public static String getUnwrappedUnlocalizedName(String unlocalizedName)
		{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
		}
	}