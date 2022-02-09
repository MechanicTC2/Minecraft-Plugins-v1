package com.nathan.plugins;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;


public class Items {
	public static ItemStack Shiny_Netherite_Sword;
	public static ItemStack Shiny_Netherite_Axe;
	public static ItemStack Shiny_Netherite_Pickaxe;
	public static ItemStack Shiny_Netherite_Shovel;
	public static ItemStack Rocket_Jumper;
	public static ItemStack Market_Gardener;
	public static ItemStack Sniper_Rifle;
	
	public static void init() {
		createShiny_Netherite_Sword();
		createShiny_Netherite_Axe();
		createShiny_Netherite_Pickaxe();
		createShiny_Netherite_Shovel();
		createRocketJumper();
		createMarketGardener();
		createSniperRifle();
	}
	
	 public static void createShiny_Netherite_Sword() {
		ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§5Shiny Netherite Sword");
		List <String> lore = new ArrayList<>();
		lore.add("§7This Shiny Netherite Sword");
		lore.add("§7is the sharpest sword in history.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 5, true);
		meta.addEnchant(Enchantment.MENDING, 5, true);
		meta.addEnchant(Enchantment.SWEEPING_EDGE, 5, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Shiny_Netherite_Sword = item;
		
		ShapedRecipe SRSNS = new ShapedRecipe(NamespacedKey.minecraft("shiny_netherite_sword"), item);
		SRSNS.shape(" N ", " N ", " B ");
		SRSNS.setIngredient('N', Material.NETHERITE_BLOCK);
		SRSNS.setIngredient('B', Material.BLAZE_ROD);
		Bukkit.getServer().addRecipe(SRSNS);
	}
	 
	public static void createShiny_Netherite_Axe() {
		ItemStack item = new ItemStack(Material.NETHERITE_AXE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§5Shiny Netherite Axe");
		List <String> lore = new ArrayList<>();
		lore.add("§7This Shiny Netherite Axe");
		lore.add("§7is the sharpest axe in history.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 5, true);
		meta.addEnchant(Enchantment.MENDING, 5, true);
		meta.addEnchant(Enchantment.SWEEPING_EDGE, 5, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 50, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Shiny_Netherite_Axe = item;
		
		ShapedRecipe SRSNA = new ShapedRecipe(NamespacedKey.minecraft("shiny_netherite_axe"), item);
		SRSNA.shape("NN ", " B ", " B ");
		SRSNA.setIngredient('N', Material.NETHERITE_BLOCK);
		SRSNA.setIngredient('B', Material.BLAZE_ROD);
		Bukkit.getServer().addRecipe(SRSNA);
	}
	
	public static void createShiny_Netherite_Pickaxe() {
		ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§5Shiny Netherite Pickaxe");
		List <String> lore = new ArrayList<>();
		lore.add("§7This Shiny Netherite Pickaxe");
		lore.add("§7is the sharpest Pickaxe in history.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.SILK_TOUCH, 5, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 50, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.MENDING, 5, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Shiny_Netherite_Pickaxe = item;
		
		ShapedRecipe SRSNP = new ShapedRecipe(NamespacedKey.minecraft("shiny_netherite_pickaxe"), item);
		SRSNP.shape("NNN", " B ", " B ");
		SRSNP.setIngredient('N', Material.NETHERITE_BLOCK);
		SRSNP.setIngredient('B', Material.BLAZE_ROD);
		Bukkit.getServer().addRecipe(SRSNP);
	}
	
	public static void createShiny_Netherite_Shovel() {
		ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§5Shiny Netherite Shovel");
		List <String> lore = new ArrayList<>();
		lore.add("§7This Shiny Netherite Shovel");
		lore.add("§7is the sharpest shovel in history.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DIG_SPEED, 50, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.MENDING, 5, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Shiny_Netherite_Shovel = item;
		
		ShapedRecipe SRSNSH = new ShapedRecipe(NamespacedKey.minecraft("shiny_netherite_shovel"), item);
		SRSNSH.shape(" N ", " B ", " B ");
		SRSNSH.setIngredient('N', Material.NETHERITE_BLOCK);
		SRSNSH.setIngredient('B', Material.BLAZE_ROD);
		Bukkit.getServer().addRecipe(SRSNSH);
	}
	
	public static void createRocketJumper() {
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Rocket Jumper");
		List <String> lore = new ArrayList<>();
		lore.add("§7Level 1 Rocket Launcher");
		lore.add("§1+200% max primary ammo on wearer");
		lore.add("§1No self inflicted blast damage taken");
		lore.add("§4-100% damage penalty");
		lore.add("§4No random critical hits");
		lore.add("§4Wearer cannot carry the intelligence");
		lore.add("§4briefcase or PASS Time JACK");
		lore.add("§fA special rocket launcher for learning");
		lore.add("§frocket jump tricks and patterns.");
		lore.add("§fThis weapon deals ZERO damage.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY, 100, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, -50, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Rocket_Jumper = item;
		
		ShapedRecipe RJ = new ShapedRecipe(NamespacedKey.minecraft("rocket_jumper"), item);
		RJ.shape("OII", "OII", "BBB");
		RJ.setIngredient('I', Material.IRON_BLOCK);
		RJ.setIngredient('B', Material.BLAZE_ROD);
		RJ.setIngredient('O', Material.OBSIDIAN);
		Bukkit.getServer().addRecipe(RJ);
	}
	
	public static void createMarketGardener() {
		ItemStack item = new ItemStack(Material.IRON_SHOVEL);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Market Gardener");
		List <String> lore = new ArrayList<>();
		lore.add("§8Level 10 Shovel");
		lore.add("§1Deals crits while the wielder is rocket jumping");
		lore.add("§420% slower firing speed");
		lore.add("§4No random critical hits");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY, 100, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 25, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Market_Gardener = item;
		
		ShapedRecipe MG = new ShapedRecipe(NamespacedKey.minecraft("market_gardener"), item);
		MG.shape(" I ", " B ", " B ");
		MG.setIngredient('I', Material.IRON_BLOCK);
		MG.setIngredient('B', Material.BLAZE_ROD);
		Bukkit.getServer().addRecipe(MG);
	}
	
	public static void createSniperRifle() {
		ItemStack item = new ItemStack(Material.SPYGLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§7Sniper Rifle");
		List <String> lore = new ArrayList<>();
		lore.add("§8Level 1 Sniper Rifle");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY, 100, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Sniper_Rifle = item;
		
		ShapedRecipe SN = new ShapedRecipe(NamespacedKey.minecraft("sniper_rifle"), item);
		SN.shape(" G ", "BII", "  B");
		SN.setIngredient('I', Material.IRON_BLOCK);
		SN.setIngredient('B', Material.BLAZE_ROD);
		SN.setIngredient('G', Material.GLASS);
		Bukkit.getServer().addRecipe(SN);
	}
}
