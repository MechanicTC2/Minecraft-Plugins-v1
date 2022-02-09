//Created by Nathan Kwok, DO NOT EDIT

package com.aaron.plugins;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		System.out.println("Your plugin is now enabled. Make sure to thank Nathan Kwok.");
		getCommand("player").setExecutor(new playerCommand());
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Your plugin is now disabled. Make sure to thank Nathan Kwok.");
	}
}
