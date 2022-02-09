//Created by Nathan Kwok, DO NOT EDIT

package com.aaron.plugins;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class Misc {

@SuppressWarnings("deprecation")
	public ItemStack customPizza() {
		ItemStack item = new ItemStack(Material.PLAYER_HEAD);
		GameProfile profile = new GameProfile(UUID.randomUUID(), null);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Pizza Slice");
		List <String> lore = new ArrayList<>();
		lore.add("§7Red Sauce");
		lore.add("§7Cheese");
		lore.add("§7Mushrooms");
		lore.add("§7Steak");
		lore.add("§7White Bread");
		meta.setLore(lore);
		ShapedRecipe pizza = new ShapedRecipe(item);
		pizza.shape("BSB","MSA","CAC");
		pizza.setIngredient('B', Material.BREAD);
		pizza.setIngredient('M', Material.BROWN_MUSHROOM);
		pizza.setIngredient('A', Material.COOKED_BEEF);
		pizza.setIngredient('C', Material.BLAZE_ROD);
		pizza.setIngredient('S', Material.RED_CONCRETE);
		profile.getProperties().put("textures", new Property("textures","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZlZjFjMjVmNTE2ZjJlN2Q2Zjc2Njc0MjBlMzNhZGNmM2NkZjkzOGNiMzdmOWE0MWE4YjM1ODY5ZjU2OWIifX19="));
        try {
            Field field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        } 
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        item.setItemMeta(meta);
        Bukkit.getServer().addRecipe(pizza);
		return item;
	}
	@SuppressWarnings("deprecation")
	public ItemStack grapplingHook() {
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Grappling Hook");
		List <String> lore = new ArrayList<>();
		lore.add("§7Instructions:");
		lore.add("§7Hold right click, then let go to zoom!");
		meta.setLore(lore);
		ShapedRecipe grapplinghook = new ShapedRecipe(item);
		grapplinghook.shape("III", "IDI", " S ");
		grapplinghook.setIngredient('I', Material.IRON_INGOT);
		grapplinghook.setIngredient('D', Material.DISPENSER);
		grapplinghook.setIngredient('S', Material.STICK);
		Bukkit.getServer().addRecipe(grapplinghook);
        item.setItemMeta(meta);
		return item;
	}
}