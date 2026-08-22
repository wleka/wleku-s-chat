package org.example.wleku.wlekus_chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.wleku.wlekus_chat.JoinQuitReplace.JoinEvent;
import org.example.wleku.wlekus_chat.JoinQuitReplace.QuitEvent;
import org.example.wleku.wlekus_chat.OtherEvents.ChatEvents;
import org.example.wleku.wlekus_chat.OtherEvents.LocateEvent;
import org.example.wleku.wlekus_chat.OtherEvents.banwordEvent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class Wlekus_chat extends JavaPlugin {

    private static Wlekus_chat instance;

    Map<String, Object> config = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    File dataFolder = getDataFolder();

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;

        saveDefaultConfig();

        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        config.put("banwords", "pepega");

        try {
            File outputFile = new File(dataFolder, "banwords.yml");

            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            mapper.writeValue(outputFile, config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getPluginManager().registerEvents(new ChatEvents(), this);
        Bukkit.getPluginManager().registerEvents(new LocateEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new banwordEvent(), this);

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
