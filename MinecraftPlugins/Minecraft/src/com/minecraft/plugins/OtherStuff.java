package com.minecraft.plugins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.minecraft.plugins.Cuboid.CuboidDirection;

public class OtherStuff {
	int interval;
	int ammo = 17;
	public void createHole() {
		Location first = new Location(Bukkit.getWorld("world"), -700, 62, -365);
		Location second = new Location(Bukkit.getWorld("world"), -690, 52, -355 );
		Cuboid hole = new Cuboid(first, second);
		Cuboid barrier = hole.outset(CuboidDirection.Both, 1);
		
		for (Block block : barrier) {
			block.setType(Material.BARRIER);
		}
		for (Block block : hole) {
			block.setType(Material.AIR);
		}
	}
	public void resetPyramid() {
		Location first = new Location(Bukkit.getWorld("world"), -700, 62, -365);
		Location second = new Location(Bukkit.getWorld("world"), -690, 32, -355 );
		Location top = new Location(Bukkit.getWorld("world"), -690, 62, -355 );
		Cuboid hole = new Cuboid(first, second);
		Cuboid barrier = hole.outset(CuboidDirection.Both, 1);
		Cuboid ceiling = new Cuboid (first, top);
		
		for (Block block : barrier) {
			block.setType(Material.AIR);
		}
		for (Block block : hole) {
			block.setType(Material.AIR);
		}
		for (Block block : ceiling) {
			block.setType(Material.WATER);
		}
	}
	public void createPyramid() {
		Location bottom1 = new Location(Bukkit.getWorld("world"), -700, 52, -365);
		Location bottom2 = new Location(Bukkit.getWorld("world"), -690, 52, -355 );
		Location beacon_top = new Location (Bukkit.getWorld("world"), -695, 57, -360);
		Cuboid bottom = new Cuboid(bottom1, bottom2);
		Cuboid beacon = new Cuboid(beacon_top, beacon_top);
		for (interval = 0; interval < 5; interval++) {
			for (Block block : bottom.shift(CuboidDirection.Up, interval).inset(CuboidDirection.Horizontal, interval)) {
				block.setType(Material.NETHERITE_BLOCK);
			}
		}
		for (Block block : beacon) {
			block.setType(Material.BEACON);
		}
	}
	public ItemStack netherWand() {
		ItemStack item = new ItemStack(Material.BLAZE_ROD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Nether Wand");
		List <String> lore = new ArrayList<>();
		lore.add("Use this to spawn a");
		lore.add("Nether Portal anywhere!");
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack endWand() {
		ItemStack item = new ItemStack(Material.END_ROD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "End Wand");
		List <String> lore = new ArrayList<>();
		lore.add("Use this to spawn an");
		lore.add("End Portal anywhere!");
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
}
