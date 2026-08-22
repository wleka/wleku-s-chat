package org.example.wleku.wlekus_chat.OtherEvents

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.example.wleku.wlekus_chat.Wlekus_chat
import org.bukkit.event.player.AsyncPlayerChatEvent

class banwordsEvent(private var plugin: Wlekus_chat): Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    fun onBanword(event: AsyncPlayerChatEvent) {
        var message = event.message
        var config = plugin.config.getString("replaceMessage").toString()

        event.message = message.replace("pepega", "${config}")
    }
}