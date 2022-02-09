package com.nathan.plugins;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.entity.Zombie;

public class entityCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if (args[0].equals("chicken")) {
			for (int i = 0; i < 10; i++) {
				Entity chicken = (Chicken) Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.CHICKEN);
			}
			player.sendMessage("10 Chickens have spawned.");
		}
		
		if (args[0].equals("zombie")) {
			for (int i = 0; i < 10; i++) {
				Entity zombie = (Zombie) Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.ZOMBIE);
			}
			player.sendMessage("10 Zombies have spawned. Leave the vicinity.");
		}
		
		if (args[0].equals("creeper")) {
			for (int i = 0; i < 10; i++) {
				Entity creeper = (Creeper) Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.CREEPER);
			}
			player.sendMessage("10 Creepers have spawned. Leave the vicinity.");
		}
		
		if (args[0].equals("fire_bear")) {
			Entity polar_bear = (PolarBear) Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.POLAR_BEAR);
			polar_bear.setFireTicks(20*30);
			player.sendMessage("A flaming Polar Bear has spawned.");
		}
		
		return false;
	}

}
