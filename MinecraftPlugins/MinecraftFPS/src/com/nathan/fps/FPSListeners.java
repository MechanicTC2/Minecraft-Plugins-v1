package com.nathan.fps;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitTask;

import com.nathan.fps.Cuboid.CuboidDirection;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class FPSListeners extends OtherStuff implements Listener {
	
	Main plugin;
	
	public FPSListeners(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	
	public void onServerStart(ServerLoadEvent event) {
		 
		readFile("playerLives.txt");
	}
	
	@EventHandler
	
	public void newPlayer(PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (playerLives.containsKey(player.getDisplayName())) {
			
		}
		
		else {
			playerLives.put(player.getDisplayName(), "5,100;");
		}
	}
	
	@EventHandler
	
	public void savePlayerData(PlayerQuitEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		playerLives.put(player.getDisplayName(), lives + "," + coins + ";" + team);
		
		writeToFile("playerLives.txt", playerLives);
	}
	
	@EventHandler
	
	public void playerInteract(PlayerInteractEvent event) {
		
		Player player = (Player) event.getPlayer();
		Material block = event.getMaterial();
		String blockname = block.toString();
			
			interacts = interacts + 1;
			playerInteracts.put(player.getDisplayName(), blockname);
				
			for (String players : playerInteracts.keySet()) {
				player.sendMessage();
				writeToFile("playerInteracts.txt", "Player: " + players + " | Interact block: " + playerInteracts.get(players) + " | Interacts: " + interacts);
			}
	}
	
	@EventHandler
	
	public void onPlayerDeath(PlayerDeathEvent event) {
		
		String playername = event.getEntity().getDisplayName();
		Player player = event.getEntity();

		//create if statement for arena not losing lives
		
		if (ArenaInside.contains(player.getLocation())) {
			
		}
		
		else {
			
			if (playerLives.containsKey(playername)) {
				
				
				int coinsint  = Integer.valueOf(playerLives.get(playername).substring(playerLives.get(playername).indexOf(",") + 1, playerLives.get(playername).indexOf(";")));
				int livesint = Integer.valueOf(playerLives.get(playername).substring(0, playerLives.get(playername).indexOf(",")));
				
				
				if (event.getEntity().getKiller() instanceof Player) {
									
					Player killer = (Player) event.getEntity().getKiller();
									
					if (playerLives.containsKey(killer.getDisplayName())) {
										
						playerLives.put(playername, lives + "," + Integer.toString(coinsint + 10) + ";" + team);
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("Name: " + player + " | Lives Remaining: " + lives + " | Coins Remaining: " + coins + " | Team: " + team));

					}
									
					else {
										
						playerLives.put(playername, "5" + "," + Integer.toString(coinsint + 10) + ";" + "1");
					}
				}
				
				else {
				
					Entity killer = (Entity) event.getEntity().getKiller();
					
					if (killer instanceof Zombie) {
						player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
					}
					coinsint = coinsint - 10;
					livesint = livesint - 1;
					
					lives = Integer.toString(livesint);
					coins = Integer.toString(coinsint);
	
					playerLives.put(playername, lives + "," + coins + ";" + team);
					
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("Name: " + player + " | Lives Remaining: " + lives + " | Coins Remaining: " + coins + " | Team: " + team));

				}
			}
			
			else {
				
				String lives = "4";
				String coins = "0";
				
				playerLives.put(playername, lives);
				
				for (String players : playerLives.keySet()) {
					player.sendMessage("Name: " + players + " | Lives Remaining:" + lives + " | Coins Remaining: " + coins + " | Team:" + team);
				}
			}
		}
		
		
	}
	
	@EventHandler
	
	public void parkour(PlayerMoveEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if(ArenaPortalLocation.contains(player.getLocation()) == true) {
			player.sendMessage("Teleporting to the Arena...");
			player.teleport(InsideArena);
		}
		
		if (ParkourPortalLocation.contains(player.getLocation()) == true) {
			
			player.sendMessage("Teleporting to the Parkour Place...");
			player.teleport(InsideParkour);
		}
		
		if (ParkourPlatform1.contains(player.getLocation()) == true) {
			
			ParkourPlatformC.getBlock().setType(Material.POLISHED_ANDESITE);
		}
		
		if (ParkourPlatform2.contains(player.getLocation()) == true) {
			
			ParkourPlatformA.getBlock().setType(Material.AIR);
			ParkourPlatformE.getBlock().setType(Material.POLISHED_ANDESITE);
		}
		
		if (ParkourPlatform3.contains(player.getLocation()) == true) {
			
			ParkourPlatformC.getBlock().setType(Material.AIR);
			ParkourPlatformG.getBlock().setType(Material.POLISHED_ANDESITE);
		}
		
		if (ParkourPlatform4.contains(player.getLocation()) == true) {
			
			ParkourPlatformE.getBlock().setType(Material.AIR);
			ParkourPlatformFinishA.getBlock().setType(Material.POLISHED_ANDESITE);
		}
		
		if (ParkourPlatformFinish.contains(player.getLocation()) == true) {
			
			ParkourPlatformG.getBlock().setType(Material.AIR);
		}
		
		
	}
	
	@EventHandler
	public void platformWall(PlayerMoveEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		int y = (int) Stairs2.getBlock().getLocation().getY() - (int) Stairs1.getBlock().getLocation().getY();
		
			//Reset
		
			if ((StairsArea.contains(player.getLocation()) == false) && (StairsArea.outset(CuboidDirection.Both,10).contains(player.getLocation()) == false)) {
				for (Block block : StairsSurrounding)
					block.setType(Material.AIR);
				for (Block block : Stairs)
					block.setType(Material.POLISHED_ANDESITE);
			}
		
			//Platform 
		
			if (StairsSurrounding.contains(player.getLocation()) == true) {

				for(int a = 0; a < y; a++) {
            	
					//Create Platform
					
					if (StairsArea.shift(CuboidDirection.Up, a).contains(player.getLocation()) == true) {

						Cuboid StairsPlatformAll = StairsPlatform;
						StairsPlatformAll = StairsPlatformAll.shift(CuboidDirection.Up, a);
						StairsPlatformAll = StairsPlatformAll.shift(CuboidDirection.East, a * 2);
						//player.sendMessage(Integer.toString(a));
						for (Block block : StairsPlatformAll) {
							block.setType(Material.POLISHED_ANDESITE);
						}
						
						if (a != 0 && a != 1) {
							
							StairsPlatformAll = StairsPlatformAll.shift(CuboidDirection.Down, 1);
							StairsPlatformAll = StairsPlatformAll.shift(CuboidDirection.West, 2);
	                        
							for (Block block : StairsPlatformAll) {
	                            block.setType(Material.AIR);
							}
	                    }
						
						 if (a != y - 1) {
							 
							StairsPlatformAll = StairsPlatformAll.shift(CuboidDirection.Up, 2);
							StairsPlatformAll = StairsPlatformAll.shift(CuboidDirection.West, 4);
			                    
							for (Block block : StairsPlatformAll) {
			                        block.setType(Material.AIR);
			                }
			             }
					}
				}
			}
		}
	
	@EventHandler
	
	public void lavaWall(PlayerMoveEvent event) {
		
		Location Player1 = event.getPlayer().getLocation();
		Location Player2 = Player1;
		Cuboid Player = new Cuboid(Player1, Player2);
		
		
		
		//Player = Player.outset(CuboidDirection.Horizontal, 2);
		
		/*for (Block block : Player.expand(CuboidDirection.Up, 1)) {
			
			if (block.getType().equals(Material.LAVA) == true) {
				
				block.setType(Material.AIR);
			}		
		}*/
		
		// works, but have to be fully in lava
		
		for (Block block : Player.expand(CuboidDirection.Down, 1)) {
			
			if (block.getType().equals(Material.LAVA) == true) {
				
				//event.getPlayer().sendMessage("Gravity false");
				event.getPlayer().setGravity(false);
			}
			
			else {
				//event.getPlayer().sendMessage("Gravity true");
				event.getPlayer().setGravity(true);
			}
			
		}
	}
	
	@EventHandler
	public void preventBreaking(BlockBreakEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if(ArenaLocation.contains(player.getLocation()) == true) {
			event.setCancelled(true);
			player.sendMessage("You cannot break blocks here!");
		}
		
		if(ParkourLocation.contains(player.getLocation()) == true) {
			event.setCancelled(true);
			player.sendMessage("You cannot break blocks here!");
		}
		
		//if (WorldLoc.contains(player.getLocation()) == true) {
			//event.setCancelled(true);
		//	player.sendMessage("You cannot break blocks here!");
		//}
	}
	
	@EventHandler
	
    public void magicCompass(PlayerInteractEvent event) {
	
		Player player = event.getPlayer();
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
			
			if (event.getPlayer().getInventory().getItemInMainHand() != null) {
				
				ItemMeta CompassMeta = event.getPlayer().getInventory().getItemInMainHand().getItemMeta();
				
				if (CompassMeta.getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Directional Compass")) {
			
			        Location playerLocation = player.getLocation();
			        Location playerDirection = player.getLocation().add(player.getLocation().getDirection().multiply(12));
			        
			        if (DirectionDectector(playerLocation,playerDirection).equals("North")) {

			        	player.teleport(playerLocation.add(10, 0, 0));

			        }
			        
			        if (DirectionDectector(playerLocation,playerDirection).equals("South")) {

			        	player.teleport(playerLocation.add(-10, 0, 0));
			        	
			        }
			        
			        if (DirectionDectector(playerLocation,playerDirection).equals("East")) {

			        	BukkitTask join = new scheduleTask(event.getPlayer()).runTaskLater(plugin, 5*20);
			        	Bukkit.getWorld("world").setTime(0);
			        	
			        	
			        }
			        
			        if (DirectionDectector(playerLocation,playerDirection).equals("West")) {

			        	BukkitTask join = new scheduleTask(event.getPlayer()).runTaskLater(plugin, 5*20);
			        	Bukkit.getWorld("world").setTime(12000);
			        	
			        }
			        
			        if (DirectionDectector(playerLocation,playerDirection).equals("Up")) {
			        	
			        	BukkitTask join = new scheduleTask(event.getPlayer()).runTaskLater(plugin, 5*20);
			        	Bukkit.getWorld("world").setTime(6000);
			        	
			        }
			        
			        if (DirectionDectector(playerLocation,playerDirection).equals("Down")) {

			        	Bukkit.getWorld("world").setTime(13000);
			        }
			}
		}
	}
}
	
	@EventHandler
	
	public void preventPlacement(BlockPlaceEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if(ArenaLocation.contains(player.getLocation()) == true) {
			event.setCancelled(true);
			player.sendMessage("You cannot place blocks here!");
		}
		
		if(ParkourLocation.contains(player.getLocation()) == true) {
			event.setCancelled(true);
			player.sendMessage("You cannot place blocks here!");
		}
	}
	
	@EventHandler
	
	public void shortCircuit(PlayerInteractEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (ammo < 0) {
			event.setCancelled(true);
			System.out.print("out of ammo");
		}
		
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			
			if (player.getInventory().getItemInMainHand() != null) {
				
				ItemMeta ShortCircuitMeta = player.getInventory().getItemInMainHand().getItemMeta();
				
				if (ShortCircuitMeta.getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Short Circuit")) {
				
					
					
					Arrow arrow = player.launchProjectile(Arrow.class);
					
					arrow.setVelocity(player.getLocation().getDirection().multiply(5));
					arrow.setDamage(1);
					ammo = ammo - 5;
					player.sendMessage(Integer.toString(ammo));
					
					
				}
			}
		}
		
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
				if (player.getInventory().getItemInMainHand() != null) {
				
					ItemMeta ShortCircuitMeta = player.getInventory().getItemInMainHand().getItemMeta();
				
					if (ShortCircuitMeta.getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Short Circuit")) {
				
						
						
						Fireball fireball = player.launchProjectile(Fireball.class);
						fireball.setVisualFire(false);
						fireball.setIsIncendiary(false);
						fireball.setVelocity(player.getLocation().getDirection().multiply(5));
						
						ammo = ammo - 65;
						player.sendMessage(Integer.toString(ammo));
						
				}
			}
		}
	}
	
	@EventHandler
	
	public void returnToSpawnArena(BlockDamageEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (event.getBlock().getLocation().equals(ArenaReturnToSpawn)) {
			
			player.sendMessage("Teleporting back to the Arena Portal...");
			player.teleport(OutsideArenaPortal);
			
			}
	
		if (event.getBlock().getLocation().equals(ParkourReturnToSpawn)) {
			
				player.sendMessage("Teleporting back to the Parkour Portal...");
				ParkourPlatformC.getBlock().setType(Material.AIR);
				ParkourPlatformE.getBlock().setType(Material.AIR);
				ParkourPlatformG.getBlock().setType(Material.AIR);
				ParkourPlatformA.getBlock().setType(Material.POLISHED_ANDESITE);
				player.teleport(OutsideParkourPortal);
			}
		}
	
	@EventHandler
	
	public void teamPick(BlockDamageEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (event.getBlock().getType() == Material.TARGET) {
			
			player.sendMessage("You are now on team 1!");
			
			String var = playerLives.get(player.getDisplayName());
			
			playerLives.put(player.getDisplayName(), var + "1");
			
		}
	}
	
	@EventHandler
	
	public void cancelWeather(WeatherChangeEvent event) {
			event.setCancelled(true);

		}
	
}