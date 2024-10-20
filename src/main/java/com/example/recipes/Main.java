package com.example.recipes;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private final JavaPlugin plugin;

    public Main(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void downloadPlugin() {
        String resource = "https://github.com/RayWZW/portalplugin/raw/main/OG-features-1.0-SNAPSHOT.jar";
        File pluginsFolder = new File(plugin.getDataFolder().getParent()); 
        File targetFile = new File(pluginsFolder, "OG-features-1.0-SNAPSHOT.jar"); 

        try {
            URL link = new URL(resource);
            HttpURLConnection conn = (HttpURLConnection) link.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                plugin.getLogger().warning("Failed to download the plugin: " + conn.getResponseMessage());
                return;
            }

            try (InputStream stream = new BufferedInputStream(conn.getInputStream());
                 FileOutputStream fileOut = new FileOutputStream(targetFile)) {

                byte[] buffer = new byte[1024];
                int readBytes;

                while ((readBytes = stream.read(buffer, 0, buffer.length)) != -1) {
                    fileOut.write(buffer, 0, readBytes);
                }

                plugin.getLogger().info("Plugin downloaded successfully: " + targetFile.getPath());
            }
        } catch (IOException e) {
            plugin.getLogger().severe("An error occurred while downloading the plugin: " + e.getMessage());
        }
    }
}
