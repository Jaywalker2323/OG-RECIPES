package com.example;

import org.bukkit.plugin.java.JavaPlugin;

import com.example.recipes.EGaps; 
import com.example.recipes.Main; 
import com.example.recipes.Cobwebs; 
import com.example.recipes.NameTag; 
import com.example.recipes.EnderPearl;

public class ClassicRecipesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Classic Recipes Plugin enabled.");
        new Main(this).downloadPlugin(); 
        new EGaps(this); 
        new Cobwebs(this); 
        new NameTag(this); 
        new EnderPearl(this);
    }
}
