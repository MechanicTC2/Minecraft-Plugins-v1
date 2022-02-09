package com.nathan.fps;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class scheduleTask extends BukkitRunnable {

	Player p;
	
	public scheduleTask(Player player) {
		
		p = player;
	}
	
	@Override
	public void run() {
		p.giveExp(6946);
	}
}
