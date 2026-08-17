package org.example.wleku.wlekus_chat.OtherEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.example.wleku.wlekus_chat.Wlekus_chat;

public class ChatEvents implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public static void onChat (AsyncPlayerChatEvent event) {
        Wlekus_chat plugin = Wlekus_chat.getInstance();

        Player player = event.getPlayer();
        String message = event.getMessage();
        String config = plugin.getConfig().getString("format").toString();

        String format = config.replace("%message%", message).replace("%player%", player.getName());

        event.setFormat(format);
    }
}
