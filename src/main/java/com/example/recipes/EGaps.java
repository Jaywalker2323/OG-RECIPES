package com.example.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import com.example.ClassicRecipesPlugin;

public class EGaps implements Listener {
    private final JavaPlugin plugin;

    public EGaps(JavaPlugin plugin) {
        this.plugin = plugin;
        registerRecipe();
        Bukkit.getPluginManager().registerEvents(this, plugin); // Registering the event listener
    }

    private void registerRecipe() {
        ItemStack enchantedGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ShapedRecipe recipe = new ShapedRecipe(enchantedGoldenApple);

        recipe.shape("GGG", "GEG", "GGG");
        recipe.setIngredient('G', Material.GOLD_BLOCK);
        recipe.setIngredient('E', Material.APPLE);

        Bukkit.addRecipe(recipe);
        plugin.getLogger().info("Enchanted Golden Apple recipe registered.");
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        // Optionally handle crafting events
        // Example: plugin.getLogger().info("Crafted: " + event.getCurrentItem().getType());
    }

    public static void registerRecipes(ClassicRecipesPlugin classicRecipesPlugin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerRecipes'");
    }
}
