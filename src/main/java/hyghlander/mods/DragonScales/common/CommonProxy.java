package hyghlander.mods.DragonScales.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import hyghlander.mods.DragonScales.common.events.PlayerTickHandler;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	public void preInit()
	{
		DragonScalesHandler.registerAll();
	}
	
	public void init()
	{
		DragonScalesHandler.registerRecipes();
		
		registerRenderThings();
		registerHandlers();
	}
	
	public void postInit()
	{
		
	}
	
	public void registerHandlers() {
		Object handler = new PlayerTickHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler);
	}
	
	public void registerRenderThings(){
		
	}

	public ModelBiped getArmorModel(int id) {
		return null;
	}
	
	public int getRenderType(String name) {
		return 0;
	}
}
