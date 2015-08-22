package net.izenith.FrameAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FrameAPI extends JavaPlugin{

	public static FrameHandler frameHandler;
	
	@Override
	public void onEnable() {
		frameHandler = new FrameHandler();
		Bukkit.getPluginManager().registerEvents(frameHandler, this);
	}
	
	public FrameHandler getFrameHandler(){
		return frameHandler;
	}
	
}
