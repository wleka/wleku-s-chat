package org.example.wleku.wlekus_chat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.wleku.wlekus_chat.JoinQuitReplace.JoinEvent;
import org.example.wleku.wlekus_chat.JoinQuitReplace.QuitEvent;
import org.example.wleku.wlekus_chat.OtherEvents.ChatEvents;
import org.example.wleku.wlekus_chat.OtherEvents.LocateEvent;

public final class Wlekus_chat extends JavaPlugin {

    private static Wlekus_chat instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new ChatEvents(), this);
        Bukkit.getPluginManager().registerEvents(new LocateEvent(this), this);

        Bukkit.getPluginManager().registerEvents(new JoinEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(this), this);

        Bukkit.getLogger().warning("Plugin wleku's chat has enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getLogger().warning("Plugin wleku's chat has disabled");
    }

    public static Wlekus_chat getInstance() {
        return instance;
    }
}
