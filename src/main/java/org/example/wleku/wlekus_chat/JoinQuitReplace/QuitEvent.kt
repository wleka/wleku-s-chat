package org.example.wleku.wlekus_chat.JoinQuitReplace

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.example.wleku.wlekus_chat.Wlekus_chat

class QuitEvent(private val plugin: Wlekus_chat): Listener {
    @EventHandler
    fun onJoin(event: PlayerQuitEvent) {
        if (plugin.config.getBoolean("quitReplace") == true) {
            val player = event.player

            val config = plugin.config.getString("quitMessage").toString()
            val replace = config.replace("%player%", player.name)

            event.quitMessage = replace
        }
    }
}