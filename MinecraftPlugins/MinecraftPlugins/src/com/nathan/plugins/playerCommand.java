package com.nathan.plugins;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class playerCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(args[0].equals("gravity")) {
			player.setGravity(false);
			player.sendMessage("Gravity is now disabled.");
		}
		
		if (args[0].equals("reset_gravity")) {
			player.setGravity(true);
			player.sendMessage("Gravity is now reenabled.");
		}
		
		if (args[0].equals("invisible")) {
			player.setInvisible(true);
			player.sendMessage("You are now invisible.");
		}
		
		if (args[0].equals("reset_invisible")) {
			player.setInvisible(false);
			player.sendMessage("You are now visible.");
		}
		
		if (args[0].equals("burn")) {
			player.setFireTicks(20*20);
			player.sendMessage("You are now burning.");
		}
		
		if (args[0].equals("poison")) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 600, 1));
			player.sendMessage("You are now poisoned.");
		}
		
		if (args[0].equals("hamburger")) {
			player.getInventory().addItem(new ItemStack(Material.BREAD, 2));
			player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 1));
			player.sendMessage("You have now been given a hamburger.");
		}
		
		if (args[0].equals("bomb")) {
			for(int i = 0; i < 100; i++) 
			{
				@SuppressWarnings("unused")
				Entity bomb = (TNTPrimed) Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
			}
			player.sendMessage("WARNING: Bomb is primed! Leave the vicinity!");
		}
		
		if (args[0].equals("name")) {
			player.setDisplayName("Dumb");
			player.sendMessage("You are Dumb.");
		}
		
		if (args[0].equals("netherite_pack")) {
			player.getInventory().addItem(Items.Shiny_Netherite_Sword);
			player.getInventory().addItem(Items.Shiny_Netherite_Axe);
			player.getInventory().addItem(Items.Shiny_Netherite_Pickaxe);
			player.getInventory().addItem(Items.Shiny_Netherite_Shovel);
			player.sendMessage("You have been given a special Shiny pack.");
		}
		
		if (args[0].equals("trolldier")) {
			player.getInventory().addItem(Items.Rocket_Jumper);
			player.getInventory().addItem(Items.Market_Gardener);
			player.sendMessage("You have been given a Rocket Jumping pack.");
		}
		
		if (args[0].equals("sniper")) {
			player.getInventory().addItem(Items.Sniper_Rifle);
			player.sendMessage("You have been given a Sniper Rifle.");
		}
		
		return false;
	}

}
