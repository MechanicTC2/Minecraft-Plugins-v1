package com.nathan.fps;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.nathan.fps.Cuboid.CuboidDirection;

public class playerCommand extends OtherStuff implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if (flash_drive == true) {
			
			targetfile = "E:\\ServerMC\\";
		}
		
		else {
			
			targetfile = "C:\\Users\\Ninja\\Desktop\\MC\\ServerMC\\";
		}
		
		
		if(args[0].equals("short_circuit")) {
	        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
	        SkullMeta meta = (SkullMeta) skull.getItemMeta();
	        GameProfile profile = new GameProfile(UUID.randomUUID(),null);
	        meta.setDisplayName("§6Short Circuit");
			List <String> lore = new ArrayList<>();
			lore.add("§8Level 5 Robot Arm");
			lore.add("§1Alt-Fire: Launches a projectile-consuming");
			lore.add("§1energy ball. Costs 65 metal.");
			lore.add("§1No reload necessary.");
			lore.add("§4Per shot: -5 ammo.");
			lore.add("§4 Uses metal for ammo.");
			meta.setLore(lore);
			meta.addEnchant(Enchantment.DURABILITY, 100, true);
			meta.addEnchant(Enchantment.DAMAGE_ALL, 0, true);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

	        //https://freshcoal.com/maincollection

	        profile.getProperties().put("textures", new Property("textures","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTViZWM3NmQ2NWE4NjhhNWJlNTE3M2QzYjllMTc3NWI1NDA0NmY2MjAzNWMxNTUyNDQwZWRlOTk3M2E5MGUxIn19fQ="));
	        Field field;
	        try {
	            field = meta.getClass().getDeclaredField("profile");
	            field.setAccessible(true);
	            field.set(meta, profile);
	        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException x) {
	            x.printStackTrace();

	        }
	        skull.setItemMeta(meta);

	        player.getInventory().addItem(skull);
		}
		
		if (args[0].equals("tp")) {
			
			if (args[1].equals("Arena")) {
				player.teleport(InsideArena);
			}
			
			if (args[1].equals("Arena_Teleporter")) {
				player.teleport(OutsideArenaPortal);
			}
			
			if (args[1].equals("ArenaPlayer")) {
				player.teleport(ArenaPlayer3);
			}
		}
		
		if (args[0].equals("reset")) {
			
			if (args[1].equals("stairs")) {
				
				for (Block block : StairsSurrounding) {
					block.setType(Material.AIR);
				}
				
				for (Block block : Stairs) {
					block.setType(Material.POLISHED_ANDESITE);
				}
			}
			
			if (args[1].equals("lava")) {
				
				for (Block block : LavaPit) {
					block.setType(Material.POLISHED_ANDESITE);
				}
				
				for (Block block : Lava) {
					block.setType(Material.LAVA);
				}
			}
			
			if (args[1].equals("box")) {
				
				for (Block block : ResetBox) {
					block.setType(Material.AIR);
				}
			}
			
			if (args[1].equals("arena")) {
				
				for (Block block : ArenaPlayer) {
					block.setType(Material.STONE);
				}
				
				for (Block block : ArenaInside) {
					block.setType(Material.AIR);
					
				}
			}
		}
		
		if (args[0].equals("armorstand")) {
			ArmorStand stand = (ArmorStand)Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            stand.setSmall(false);
            stand.setBasePlate(false);
            stand.setArms(false);
            stand.setGravity(false);
            stand.setVisible(false);
            stand.setCustomName("Label");
            stand.setCustomNameVisible(true);
            
		}
		
		if (args[0].equals("enable_gravity")) {
			player.setGravity(true);
		}
		
		if (args[0].equals("house")) {
			
			Location houseLocation1 = player.getLocation().add(4, 0, 0);
			Location houseLocation2 = player.getLocation().add(8, 4, 4);
			Location space1 = player.getLocation().add(5, 1, 1);
			Location space2 = player.getLocation().add(7, 4, 3);
			Cuboid houseCuboid = new Cuboid(houseLocation1, houseLocation2);
			Cuboid spaceCuboid = new Cuboid(space1, space2);
			
			for (Block block : houseCuboid) {
				block.setType(Material.OAK_PLANKS);
			}
			
			for (Block block : spaceCuboid) {
				block.setType(Material.AIR);
			}		
		}
		
		if (args[0].equals("file")) {
			
			if (args[1].equals("create")) {
				createFile(targetfile + "playerLives.txt");
				createFile(targetfile + "playerInteracts.txt");
			}
			   
			if (args[1].equals("write_all_players")) {
				
				for (OfflinePlayer players : Bukkit.getServer().getOfflinePlayers()) {
		    		  playernames.add(players.getName());
		    		  for (String names : playernames) {
		    			  writeToFile("playerNames.txt", names);
		    		  }
		    	 }
			}
			
			if (args[1].equals("read")) {
			
				readFile("playerLives.txt");
			}
			
			if (args[1].equals("clear")) {
				
				File fileInteracts = new File("playerInteracts.txt");

				fileInteracts.delete();
				System.out.println(fileInteracts.getName() + "was deleted.");
				createFile(/*"C:\\Users\\Ninja\\Desktop\\Minecraft\\Server\\playerInteracts.txt"*/ "E:\\ServerMC\\playerInteracts.txt");
				
			}
		}
		
		return false;
	}

}
