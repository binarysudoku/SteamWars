package steamwars.blocks;


public class Blocks
	{
	
	public static void init()
		{
		}
	
	public static void addNames()
		{
		}
	
	public static String getUnwrappedUnlocalizedName(String unlocalizedName)
		{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
		}
	}