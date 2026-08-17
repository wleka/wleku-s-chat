package org.example.wleku.wlekus_chat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Wlekus_chat extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getLogger().warning("Plugin wleku's chat has enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getLogger().warning("Plugin wleku's chat has disabled");
    }
}
