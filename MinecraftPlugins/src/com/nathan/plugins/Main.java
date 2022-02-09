package com.nathan.plugins;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	// JC -- 
	 private static Plugin plugin;
	@Override
	public void onEnable() {
		plugin = this;
		System.out.println("Your plugin is now enabled. - Nathan");
		getServer().getPluginManager().registerEvents(new NathanListener(), this);
		getCommand("player").setExecutor(new playerCommand());
		getCommand("entity").setExecutor(new entityCommand());
		getCommand("building").setExecutor(new buildingCommand());
		Items.init();
	}
	
	@Override
	public void onDisable() {
		System.out.println("Your plugin is now disabled. - Nathan");
	}
	
	//JC--Added code
	 public static Plugin getPlugin() {
		    return plugin;
		  }

}
