package steamwars.entity.mob;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import steamwars.entity.particle.EntityGhostFX;
import steamwars.items.Items;

public class EntityGhost extends EntityMob implements IMob
	{
	private ChunkCoordinates currentFlightTarget;
	
	public EntityGhost(World par1World)
		{
		super(par1World);
		
		this.isImmuneToFire = true;
		this.experienceValue = 10;
		}
	
	protected void dropFewItems(boolean par1, int par2)
		{
		int j = this.rand.nextInt(2 + par2);
		int k;
		
		for (k = 0; k < j; ++k)
			{
			this.dropItem(Items.thaumWire.itemID, 1);
			}
		}
	
	protected String getDeathSound()
		{
		return "mob.blaze.death";
		}
	
	public void onLivingUpdate()
		{
		super.onLivingUpdate();
		
		this.motionX *= 0.6;
		this.motionY *= 0.4D;
		this.motionZ *= 0.6;
		}
	
	public boolean isInvisible()
		{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		if (player.getCurrentItemOrArmor(4) != null)
			{
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			
			if (helmet.getItem() == Items.ghostGoggles)
				{
				return false;
				}
			}
		return true;
		}
	
	public boolean allowLeashing()
		{
		return false;
		}
	
	protected void updateFallState(double par1, boolean par3)
		{
		}
	
	public boolean isAIEnabled()
		{
		return true;
		}
	
	/**
	 * Return whether this entity should NOT trigger a pressure plate or a
	 * tripwire.
	 */
	public boolean doesEntityNotTriggerPressurePlate()
		{
		return true;
		}
	
	protected void fall(float par1)
		{
		}
	
	public boolean canBePushed()
		{
		return false;
		}
	
	protected void collideWithEntity(Entity par1Entity)
		{
		}
	
	protected void collideWithNearbyEntities()
		{
		}
	
	public boolean canBeCollidedWith()
		{
		return false;
		}
	
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
		{
		return false;
		}
	
	protected int getDropItemId()
		{
		return Items.thaumWire.itemID;
		}
	
	protected boolean canTriggerWalking()
		{
		return false;
		}
	
	protected void updateAITasks()
		{
		super.updateAITasks();
		
		if (this.currentFlightTarget != null && (!this.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1))
			{
			this.currentFlightTarget = null;
			}
		
		if (this.currentFlightTarget == null || this.rand.nextInt(30) == 0 || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 4.0F)
			{
			this.currentFlightTarget = new ChunkCoordinates((int) this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int) this.posY + this.rand.nextInt(6) - 2, (int) this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
			}
		
		double d0 = (double) this.currentFlightTarget.posX + 0.5D - this.posX;
		double d1 = (double) this.currentFlightTarget.posY + 0.1D - this.posY;
		double d2 = (double) this.currentFlightTarget.posZ + 0.5D - this.posZ;
		this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
		this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
		this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
		float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
		float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
		this.moveForward = 0.5F;
		this.rotationYaw += f1;
		}
	
	public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData)
		{
		super.onSpawnWithEgg(par1EntityLivingData);
		return par1EntityLivingData;
		}
	}
