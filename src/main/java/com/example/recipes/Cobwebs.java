package com.example.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Cobwebs implements Listener {
    private final JavaPlugin plugin;

    public Cobwebs(JavaPlugin plugin) {
        this.plugin = plugin;
        registerRecipe();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private void registerRecipe() {
        ItemStack cobweb = new ItemStack(Material.COBWEB);
        NamespacedKey key = new NamespacedKey(plugin, "cobweb"); // Create a unique key for the recipe
        ShapedRecipe recipe = new ShapedRecipe(key, cobweb); // Use the key in the constructor

        recipe.shape(" S ", "S S", " S ");
        recipe.setIngredient('S', Material.STRING);

        Bukkit.addRecipe(recipe);
        plugin.getLogger().info("Cobweb crafting recipe registered.");
    }

    public void onCraft(CraftItemEvent event) {
        // Optionally handle crafting events
    }
}
