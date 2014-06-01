package steamwars.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPowerCore extends EntityThrowable
	{
	private int xTile = -1;
	private int yTile = -1;
	private int zTile = -1;
	private int inTile;
	protected boolean inGround;
	private int ticksInGround;
	private EntityLivingBase shootingEntity;
	
	public EntityPowerCore(World par1World)
		{
		super(par1World);
		}
	
	public EntityPowerCore(World par1World, EntityLivingBase entitylivingbase)
		{
		super(par1World, entitylivingbase);
		this.shootingEntity = entitylivingbase;
		this.motionX /= 2.0;
		this.motionY /= 2.0;
		this.motionZ /= 2.0;
		}
	
	public EntityPowerCore(World par1World, double par2, double par4, double par6)
		{
		super(par1World, par2, par4, par6);
		}
	
	@Override
	public void onUpdate()
		{
		super.onUpdate();
		
		// this.posX += this.motionX;
		// this.posY += this.motionY;
		// this.posZ += this.motionZ;
		
		for (int i = 0; i < 3; ++i)
			{
			this.worldObj.spawnParticle("reddust", this.posX + (rand.nextDouble() - 0.5D), this.posY + (rand.nextDouble() - 0.5D), this.posZ + (rand.nextDouble() - 0.5D), 1.0D, 1.0D, 1.0D);
			}
		}
	
	@Override
	public boolean canRenderOnFire()
		{
		return false;
		}
	
	protected void onImpact(MovingObjectPosition movingobjectposition)
		{
		this.worldObj.playSoundAtEntity(this, "steamwars:misc.coresplode", 4.0F, 1.0F / (this.rand.nextFloat() * 0.4F + 1.2F));
		
		for (int i = 0; i < 512; ++i)
			{
			this.worldObj.spawnParticle("magicCrit", this.posX + (rand.nextDouble() - 0.5D), this.posY + (rand.nextDouble() - 0.5D), this.posZ + (rand.nextDouble() - 0.5D), (rand.nextDouble() - 0.5D)*12, (rand.nextDouble() - 0.5D)*12, (rand.nextDouble() - 0.5D)*12);
			this.worldObj.spawnParticle("portal", this.posX + (rand.nextDouble() - 0.5D)*12, this.posY + (rand.nextDouble() - 0.5D)*12, this.posZ + (rand.nextDouble() - 0.5D)*12, 0.0D, 0.0D, 0.0D);
			}
		
		if (!this.worldObj.isRemote)
			{
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 6.0F, true);
			this.setDead();
			}
		}
	}