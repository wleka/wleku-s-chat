package org.example.wleku.wlekus_chat.JoinQuitReplace

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.example.wleku.wlekus_chat.Wlekus_chat

class JoinEvent(private val plugin: Wlekus_chat): Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        if (plugin.config.getBoolean("joinReplace") == true) {
            val player = event.player

            val config = plugin.config.getString("joinMessage").toString()
            val replace = config.replace("%player%", player.name)

            event.joinMessage = replace
        }
    }
}