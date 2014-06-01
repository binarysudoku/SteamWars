package steamwars.entity.projectile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import steamwars.items.Items;

public class EntityPlasmaGunBullet extends EntityThrowable
	{
	private int xTile = -1;
	private int yTile = -1;
	private int zTile = -1;
	private int inTile;
	protected boolean inGround;
	private int ticksInGround;
	private EntityLivingBase shootingEntity;
	private static float damage;
	
	public EntityPlasmaGunBullet(World par1World)
		{
		super(par1World);
		}
	
	public EntityPlasmaGunBullet(World par1World, EntityLivingBase entitylivingbase)
		{
		super(par1World, entitylivingbase);
		this.motionX *= 1.5;
		this.motionY *= 1.5;
		this.motionZ *= 1.5;
		this.shootingEntity = entitylivingbase;
		}
	
	public EntityPlasmaGunBullet(World par1World, double par2, double par4, double par6)
		{
		super(par1World, par2, par4, par6);
		}
	
	public void setDamage(float f)
		{
		this.damage = f;
		}
	
	@Override
	public void onUpdate()
		{
		super.onUpdate();
		
		// this.posX += this.motionX;
		// this.posY += this.motionY;
		// this.posZ += this.motionZ;
		
		for (int i = 0; i < 2; ++i)
			{
			this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, 1.0D, 4.0D, 1.0D);
			}
		}
	
	protected float getGravityVelocity()
		{
		return 0.0F;
		}
	
	@Override
	public boolean canRenderOnFire()
		{
		return false;
		}
	
	protected void onImpact(MovingObjectPosition movingobjectposition)
		{
		if (movingobjectposition.entityHit != null)
			{
			movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this), 4 + ((int) (this.damage * 6)));
			movingobjectposition.entityHit.setFire(2);
			}
		
		AxisAlignedBB axisalignedbb = this.boundingBox.expand(1.0D, 1.0D, 1.0D);
		List list1 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		if (list1 != null && !list1.isEmpty())
			{
			Iterator iterator = list1.iterator();
			while (iterator.hasNext())
				{
				EntityLivingBase entitylivingbase = (EntityLivingBase) iterator.next();
				double d0 = this.getDistanceSqToEntity(entitylivingbase);
				entitylivingbase.attackEntityFrom(DamageSource.causeThrownDamage(this, this), 4 + ((int) (this.damage * 6)));
				entitylivingbase.setFire(2);
				}
			}
		
		this.worldObj.playSoundAtEntity(this, "steamwars:pulse.pistolhit", 0.6F, 1.0F / (this.rand.nextFloat() * 0.4F + 1.2F));
		
		for (int i = 0; i < 16; ++i)
			{
			this.worldObj.spawnParticle("fire", this.posX, this.posY, this.posZ, (this.rand.nextDouble() - 0.5), (this.rand.nextDouble() - 0.5), (this.rand.nextDouble() - 0.5));
			this.worldObj.spawnParticle("reddust", this.posX + (0.5 - this.rand.nextDouble()), this.posY + (0.5 - this.rand.nextDouble()), this.posZ + (0.5 - this.rand.nextDouble()), 0.0D, 4.0D, 0.0D);
			}
		
		for (int i = 0; i < 4; ++i)
			{
			this.worldObj.spawnParticle("iconcrack_" + Items.plasmaPistolBullet.itemID, this.posX, this.posY, this.posZ, (this.rand.nextDouble() - 0.5), (this.rand.nextDouble() - 0.5), (this.rand.nextDouble() - 0.5));
			}
		
		if (!this.worldObj.isRemote)
			{
			// this.worldObj.createExplosion(this, this.posX, this.posY,
			// this.posZ, 2.0F, true);
			this.setDead();
			}
		}
	}