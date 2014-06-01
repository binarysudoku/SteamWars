package steamwars.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import steamwars.entity.mob.EntityGhost;
import steamwars.items.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGhost extends RenderLiving
	{
	private static ResourceLocation textures = new ResourceLocation("steamwars:textures/models/mob/ghost.png");
	
	
	
	public RenderGhost(ModelBase par1ModelBase, float par2)
		{
		super(par1ModelBase, par2);
		}
	
	protected ResourceLocation getTextures(EntityGhost par1EntityGhost)
		{
		return textures;
		}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity par1Entity)
		{
		return this.getTextures((EntityGhost) par1Entity);
		}
	}