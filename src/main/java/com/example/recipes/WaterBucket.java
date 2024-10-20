package com.example.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class WaterBucket implements Listener {
    private final JavaPlugin plugin;

    public WaterBucket(JavaPlugin plugin) {
        this.plugin = plugin;
        registerRecipe();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private void registerRecipe() {
        ItemStack waterBucket = new ItemStack(Material.WATER_BUCKET);
        ShapedRecipe recipe = new ShapedRecipe(waterBucket);

        recipe.shape("BGB", "BMB", "BGB");
        recipe.setIngredient('B', Material.BLUE_DYE);
        recipe.setIngredient('G', Material.GLASS_BOTTLE); 
        recipe.setIngredient('M', Material.BUCKET); 

        Bukkit.addRecipe(recipe);
        plugin.getLogger().info("Water Bucket recipe registered.");
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
    }
}
