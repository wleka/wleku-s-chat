package org.example.wleku.wlekus_chat.OtherEvents

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.example.wleku.wlekus_chat.Wlekus_chat

class playerPingEvent(private var plugin: Wlekus_chat) : Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    fun onPlayerPing(event: AsyncPlayerChatEvent) {
        val message = event.message

        if (plugin.config.getBoolean("pingEvent") == true) {
            for (player in Bukkit.getOnlinePlayers()) {
                if (message.contains(player.name)) {
                    event.message =
                        message.replace("${player.name}", "${plugin.config.getString("pingColor")}${player.name}§r")
                }
            }
        }
    }
}