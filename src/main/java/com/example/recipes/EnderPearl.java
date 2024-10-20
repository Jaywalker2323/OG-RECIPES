package com.example.recipes;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.NamespacedKey;

public class EnderPearl implements Listener {
    
    public EnderPearl(JavaPlugin plugin) {
        ItemStack enderPearl = new ItemStack(Material.ENDER_PEARL);
        NamespacedKey key = new NamespacedKey(plugin.getName().toLowerCase(), "ender_pearl_recipe");
        ShapedRecipe recipe = new ShapedRecipe(key, enderPearl);
        
        recipe.shape("SSS", "SSS", "SSS");
        recipe.setIngredient('S', Material.SNOWBALL);
        
        plugin.getServer().addRecipe(recipe);
        plugin.getLogger().info("Ender Pearl crafting recipe registered.");
    }
}
