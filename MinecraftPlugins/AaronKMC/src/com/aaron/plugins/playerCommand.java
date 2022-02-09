//Created by Nathan Kwok, DO NOT EDIT

package com.aaron.plugins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class playerCommand extends Misc implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if (args[0].equals("give")) {
			
			if (args[1].equals("pizza")) {
				player.getInventory().addItem(customPizza());
				player.sendMessage("Item given.");
			}
			
			if (args[1].equals("grappling_hook")) {
				player.getInventory().addItem(grapplingHook());
				player.sendMessage("Item given.");
			}
		}
		return false;
	}

}
