package steamwars.entity.particle;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_GREATER;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glAlphaFunc;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glDepthMask;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import steamwars.items.Items;
import steamwars.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityGhostFX extends EntityFX
	{
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.ID, "textures/particle/ghost.png");
	
	public EntityGhostFX(World par1World, double x, double y, double z, double red, double green, double blue)
		{
		super(par1World, x, y, z, red, green, blue);
		
		this.setMaxAge((int)(rand.nextFloat()*60));
		this.setGravity(0);
		this.setScale(1);
		this.motionX = (rand.nextFloat()-0.5)/5;
		this.motionY = (rand.nextFloat()-0.5)/5;
		this.motionZ = (rand.nextFloat()-0.5)/5;
		}
	
	public void renderParticle(Tessellator tess, float partialTicks, float par3, float par4, float par5, float par6, float par7)
		{
		super.renderParticle(tess, partialTicks, par3, par4, par5, par6, par7);
		/*
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		glDepthMask(false);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glAlphaFunc(GL_GREATER, 0.003921569F);
		//tess.startDrawingQuads();
		tess.setBrightness(getBrightnessForRender(partialTicks));
		float scale = 0.1F * particleScale;
		float x = (float) (prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float) (prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float) (prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
		tess.addVertexWithUV(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 0, 0);
		tess.addVertexWithUV(x - par3 * scale + par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1, 0);
		tess.addVertexWithUV(x + par3 * scale + par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1, 1);
		tess.addVertexWithUV(x + par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 0, 1);
		//tess.draw();
		glDisable(GL_BLEND);
		glDepthMask(true);
		glAlphaFunc(GL_GREATER, 0.1F);
		*/
		}
	
	public int getFXLayer()
		{
		return 1;
		}
	
	public EntityGhostFX setMaxAge(int i)
		{
		particleMaxAge = i;
		return this;
		}
	
	public EntityGhostFX setGravity(int i)
		{
		particleGravity = i;
		return this;
		}
	
	public EntityGhostFX setScale(int i)
		{
		particleScale = i;
		return this;
		}
	}