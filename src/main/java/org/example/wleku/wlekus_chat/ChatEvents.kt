package org.example.wleku.wlekus_chat

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent

class ChatEvents(private val plugin: Wlekus_chat): Listener {

    @EventHandler
    fun onEvent(event: PlayerChatEvent) {
        // event.isCancelled = true

        val player = event.player
        val message = event.message
        val config = plugin.config.getString("format").toString()

        val replace = config.replace("%message%", message)
            .replace("%player%", player.name)

        event.format = replace
    }
}