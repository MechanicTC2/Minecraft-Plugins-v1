package com.nathan.plugins;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class OtherStuff{
	
	Location HouseA = new Location(Bukkit.getWorld("world"), 268, 105, 356);
	Location HouseB = new Location(Bukkit.getWorld("world"), 260, 95, 364);
	
	Cuboid HouseLocation = new Cuboid(HouseA, HouseB);
	
	Location GardenA = new Location(Bukkit.getWorld("world"), 220, 114, 522);
	Location GardenB = new Location(Bukkit.getWorld("world"), 216, 103, 528);
	
	Cuboid GardenLocation = new Cuboid(GardenA, GardenB);
	
	Location DeathLocation = new Location(Bukkit.getWorld("world"), 0, 0, 0);
}
