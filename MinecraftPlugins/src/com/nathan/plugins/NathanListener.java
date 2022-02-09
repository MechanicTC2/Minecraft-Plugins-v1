package com.nathan.plugins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.projectiles.ProjectileSource;

public class NathanListener extends OtherStuff implements Listener {
	
	
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if(HouseLocation.contains(player.getLocation()) == true) {
			player.sendMessage("You are in HouseLocation!");
		}
		
		if(GardenLocation.contains(player.getLocation()) == true) {
			player.sendMessage("You are in GardenLocation!");
		}
	}
	
	//@EventHandler
	public void onPlayerBreakBlock(BlockBreakEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		double bX = event.getBlock().getLocation().getX();
		double bY = event.getBlock().getLocation().getY();
		double bZ = event.getBlock().getLocation().getZ();
		
		for (int i=0; i < 5; i++) {
			for (int n=0; n < 5; n++) {
				for (int m=0; m < 5; m++) {
					Location MineLocation = new Location(Bukkit.getWorld("world"), bX + m, bY + i, bZ + n);
					MineLocation.getBlock().setType(Material.AIR);
					player.spawnParticle(Particle.EXPLOSION_LARGE, bX + m, bY + i, bZ + n, 1);
				}
			}
		}
		player.sendMessage("Kaboom!");
	}
	
	@EventHandler
	public void OnPlayerDeath(PlayerDeathEvent event) {
		
		Player player = (Player) event.getEntity();
		
		double bX = event.getEntity().getLocation().getX();
		double bY = event.getEntity().getLocation().getY();
		double bZ = event.getEntity().getLocation().getZ();
		
		DeathLocation = new Location(Bukkit.getWorld("world"), bX, bY, bZ);
		player.sendMessage("Your death coordinates are " + bX + " " + bY + " " + bZ + ".");
	}
	
	@EventHandler
	public void OnPlayerRespawn(PlayerRespawnEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		event.setRespawnLocation(DeathLocation);
		player.sendMessage("You have been teleported to your death location.");
	}
	
	@EventHandler
	public void OnPlayerThrowEgg(PlayerEggThrowEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (event.isHatching() == true) {
			Entity TNT = Bukkit.getWorld("world").spawnEntity(event.getEgg().getLocation(), EntityType.PRIMED_TNT);
	        TNTPrimed CustomFuseTNT = (TNTPrimed) TNT;
	        CustomFuseTNT.setFuseTicks(1);
		}
	}
	
	@EventHandler
    public void OnEntitySpawn(EntitySpawnEvent event) {
        if(event.getEntityType().equals(EntityType.CHICKEN)) {
            event.setCancelled(true);
        }
    }
	
	@EventHandler
	public void OnWeatherChange(WeatherChangeEvent event) {
		if(event.toWeatherState()) {
			event.setCancelled(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onEntityShoot(EntityShootBowEvent event) {
        Entity projectile = event.getProjectile();
        
        if (projectile instanceof Arrow) {
            Arrow arrow = (Arrow) projectile;
            ProjectileSource shooter = arrow.getShooter();
            if (shooter != null) {
                if (shooter instanceof Player) {
                    Player player = (Player) shooter;
                    
                    if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Rocket Jumper")) {
                    	arrow.remove();
                        Snowball snowball = player.launchProjectile(Snowball.class);
                        snowball.setVelocity(player.getLocation().getDirection().multiply(1.2));
                        snowball.setVisualFire(true);
                        snowball.addPassenger(player);
                        
                        //if (snowball.getPassengers() == null) {
                        	//snowball.remove();
                        //}
                        //want to remove snowball if nobody is on it
                        
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
	
	@EventHandler
	public void onSpyglassShoot(PlayerInteractEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (event.getItem().getType() == Material.SPYGLASS) {
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
					  public void run() {
						  Arrow arrow = player.launchProjectile(Arrow.class);
							arrow.setVelocity(player.getLocation().getDirection().multiply(1000));
							arrow.setDamage(15);
							event.setCancelled(true);
					  }
				}, 3*20L);
			}
		}
	}
}