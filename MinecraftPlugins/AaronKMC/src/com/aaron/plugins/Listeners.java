package com.aaron.plugins;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

public class Listeners implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void pizzaFunct(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Pizza Slice")) {
            	player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100, 5));
            	//player.getInventory().removeItem(new ItemStack(Material.matchMaterial(sign.getLine(1)), amount));

            	
            }
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
    public void grapplingHookFunct(EntityShootBowEvent event) {
        Entity projectile = event.getProjectile();
        
        if (projectile instanceof Arrow) {
            Arrow arrow = (Arrow) projectile;
            ProjectileSource shooter = arrow.getShooter();
            
            if (shooter != null) {
                if (shooter instanceof Player) {
                    Player player = (Player) shooter;
                    
                    if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Grappling Hook")) {
                    	arrow.remove();
                        Snowball snowball = player.launchProjectile(Snowball.class);
                        snowball.setVelocity(player.getLocation().getDirection().multiply(10));
                        snowball.setVisualFire(true);
                        snowball.addPassenger(player);
                    }
                }
            }
        }
    }
}