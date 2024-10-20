package com.example.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.NamespacedKey;

public class NameTag implements Listener {
    private final JavaPlugin plugin;

    public NameTag(JavaPlugin plugin) {
        this.plugin = plugin;
        registerRecipe();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private void registerRecipe() {
        ItemStack nameTag = new ItemStack(Material.NAME_TAG);
        NamespacedKey key = new NamespacedKey(plugin, "name_tag");

        ShapedRecipe recipe = new ShapedRecipe(key, nameTag);
        recipe.shape(" P ", "PIP", " P ");
        recipe.setIngredient('P', Material.PAPER);
        recipe.setIngredient('I', Material.IRON_INGOT);

        Bukkit.addRecipe(recipe);
        plugin.getLogger().info("NameTag crafting recipe registered.");
    }

    public void onCraft(CraftItemEvent event) {
        // Optionally handle crafting events
    }
}
