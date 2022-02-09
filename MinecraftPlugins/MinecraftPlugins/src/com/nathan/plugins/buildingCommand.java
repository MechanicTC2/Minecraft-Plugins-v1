package com.nathan.plugins;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class buildingCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		double playerX = player.getLocation().getX();
		double playerY = player.getLocation().getY();
		double playerZ = player.getLocation().getZ();
		
		Location location = new Location(Bukkit.getWorld("world"), playerX, playerY, playerZ);
		
		if (args[0].equals("wooden_log")) {
			for (int n=0; n < 5; n++) {
				Location location1 = new Location(Bukkit.getWorld("world"), playerX, playerY, playerZ + n);
				location1.getBlock().setType(Material.OAK_LOG);
			}
		}
			
		if (args[0].equals("brick_wall")) {
			for (int i=0; i < 10; i++) {
				for (int n=0; n < 20; n++) {
					Location location1 = new Location(Bukkit.getWorld("world"), playerX, playerY + i, playerZ + n);
					location1.getBlock().setType(Material.BRICKS);
				}
			}
			player.sendMessage("A Brick Wall has spawned.");
		}
		
		
		if (args[0].equals("chest")) {
			location.getBlock().setType(Material.CHEST);
		}
		
		if (args[0].equals("cube")) {
			int xMax = Integer.parseInt(args[1]);
			int yMax = Integer.parseInt(args[2]);
			int zMax = Integer.parseInt(args[3]);
			
				for (int m=0; m < xMax; m++) {
					for (int i=0; i < yMax; i++) {
						for (int n=0; n < zMax; n++) {
							Location location1 = new Location(Bukkit.getWorld("world"), playerX + m, playerY + i, playerZ + n);
							location1.getBlock().setType(Material.DIAMOND_BLOCK);
						}
					}
				}
			player.sendMessage("A Diamond Cube has spawned.");
			}
		
		if (args[0].equals("hole")) {
			int xMax = Integer.parseInt(args[1]);
			int yMax = Integer.parseInt(args[2]);
			int zMax = Integer.parseInt(args[3]);
			
				for (int m=0; m < xMax; m++) {
					for (int i=0; i < yMax; i++) {
						for (int n=0; n < zMax; n++) {
							Location location1 = new Location(Bukkit.getWorld("world"), playerX + m, playerY - i, playerZ + n);
							location1.getBlock().setType(Material.AIR);
						}
					}
				}
			player.sendMessage("A Hole has spawned.");
			}
		
		if (args[0].equals("island")) {
			int xMax = Integer.parseInt(args[1]);
			int yMax = Integer.parseInt(args[2]);
			int zMax = Integer.parseInt(args[3]);
			
				for (int m=0; m < xMax; m++) {
					for (int i=0; i < yMax; i++) {
						for (int n=0; n < zMax; n++) {
							Location location1 = new Location(Bukkit.getWorld("world"), playerX + m, playerY - i, playerZ + n);
							location1.getBlock().setType(Material.AIR);
						}
					}
				}
				
			double PlayerX = playerX + (xMax/2);
			double PlayerY = playerY - (yMax/2);
			double PlayerZ = playerZ + (zMax/2);
			
			for (int k=0; k < xMax/2; k++ ) {
				for (int g=0; g < zMax/2; g++) {
					Location location1 = new Location(Bukkit.getWorld("world"), PlayerX, PlayerY, PlayerZ);
					location1.getBlock().setType(Material.OAK_PLANKS);
				}
			}
			
			player.sendMessage("An Island has spawned.");
			}
		
		return false;
	}
  }

