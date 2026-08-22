package org.example.wleku.wlekus_chat.OtherEvents

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.example.wleku.wlekus_chat.Wlekus_chat
import org.bukkit.Sound

class playerPingEvent(private var plugin: Wlekus_chat) : Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    fun onPlayerPing(event: AsyncPlayerChatEvent) {
        val message = event.message

        if (plugin.config.getBoolean("pingEvent") == true) {
            for (target in Bukkit.getOnlinePlayers()) {
                if (message.contains(target.name)) {
                    event.message =
                        message.replace("${target.name}", "${plugin.config.getString("pingColor")}${target.name}§r")
                    target.playSound(target.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F)

                    val replace = plugin.config.getString("barMessage")
                        ?.replace("%target%", "${target.name}")
                        ?.replace("%sender%", "${event.player.name}")

                    target.sendActionBar(Component.text("$replace"))
                }
            }
        }
    }
}