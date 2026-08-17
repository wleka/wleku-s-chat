package org.example.wleku.wlekus_chat.OtherEvents

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

import org.example.wleku.wlekus_chat.Wlekus_chat

class LocateEvent(private val plugin: Wlekus_chat) : Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    fun onLocateEvent(event: AsyncPlayerChatEvent) {
        val player = event.player
        val message = event.message
        val config = plugin.config

        if (config.getBoolean("locEvent") == true) {

            val replacement = when(player.location.world.name) {
                config.getString("firstWorld") -> {
                    val loc = config.getString("locFormat")
                        ?.replace("%posX%", "${player.location.x.toInt()}")
                        ?.replace("%posY%", "${player.location.y.toInt()}")
                        ?.replace("%posZ%", "${player.location.z.toInt()}")

                    event.message.replace(":loc:", "${config.getString("firstColor")}${loc}§r")
                }
                config.getString("secondWorld") -> {
                    val loc = config.getString("locFormat")
                        ?.replace("%posX%", "${player.location.x.toInt()}")
                        ?.replace("%posY%", "${player.location.y.toInt()}")
                        ?.replace("%posZ%", "${player.location.z.toInt()}")

                    event.message.replace(":loc:", "${config.getString("secondColor")}${loc}§r")
                }
                config.getString("thirdWorld") -> {
                    val loc = config.getString("locFormat")
                        ?.replace("%posX%", "${player.location.x.toInt()}")
                        ?.replace("%posY%", "${player.location.y.toInt()}")
                        ?.replace("%posZ%", "${player.location.z.toInt()}")

                    event.message.replace(":loc:", "${config.getString("thirdColor")}${loc}§r")
                }
                else -> {
                    val loc = config.getString("locFormat")
                        ?.replace("%posX%", "${player.location.x.toInt()}")
                        ?.replace("%posY%", "${player.location.y.toInt()}")
                        ?.replace("%posZ%", "${player.location.z.toInt()}")

                    event.message.replace(":loc:", "§7${loc}§r")
                }
            }.toString()

            event.setMessage(replacement)

        }
    }
}