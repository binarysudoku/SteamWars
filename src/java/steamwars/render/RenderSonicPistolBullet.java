package steamwars.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import steamwars.entity.projectile.EntitySonicPistolBullet;
import steamwars.items.Items;

public class RenderSonicPistolBullet extends Render
	{
	private float field_77002_a;
	
	public RenderSonicPistolBullet(float par1)
		{
		this.field_77002_a = par1;
		}
	
	public void doRenderBullet(EntitySonicPistolBullet entityBullet, double par2, double par4, double par6, float par8, float par9)
		{
		GL11.glPushMatrix();
		this.bindEntityTexture(entityBullet);
		GL11.glTranslatef((float) par2, (float) par4, (float) par6);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		float f2 = this.field_77002_a;
		GL11.glScalef(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
		Tessellator tessellator = Tessellator.instance;
		Icon icon = Items.sonicPistolBullet.getIconFromDamage(0);
		float f3 = icon.getMinU();
		float f4 = icon.getMaxU();
		float f5 = icon.getMinV();
		float f6 = icon.getMaxV();
		float f7 = 1.0F;
		float f8 = 0.5F;
		float f9 = 0.25F;
		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, -0.1F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		tessellator.addVertexWithUV((double) (0.0F - f8), (double) (0.0F - f9), 0.0D, (double) f3, (double) f6);
		tessellator.addVertexWithUV((double) (f7 - f8), (double) (0.0F - f9), 0.0D, (double) f4, (double) f6);
		tessellator.addVertexWithUV((double) (f7 - f8), (double) (1.0F - f9), 0.0D, (double) f4, (double) f5);
		tessellator.addVertexWithUV((double) (0.0F - f8), (double) (1.0F - f9), 0.0D, (double) f3, (double) f5);
		tessellator.draw();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		}
	
	protected ResourceLocation getBulletTextures(EntitySonicPistolBullet entityBullet)
		{
		return TextureMap.locationItemsTexture;
		}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity entityBullet)
		{
		return this.getBulletTextures((EntitySonicPistolBullet) entityBullet);
		}
	
	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity entityBullet, double par2, double par4, double par6, float par8, float par9)
		{
		this.doRenderBullet((EntitySonicPistolBullet) entityBullet, par2, par4, par6, par8, par9);
		}
	}