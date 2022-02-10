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
