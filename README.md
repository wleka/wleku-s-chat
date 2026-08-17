
# wleku's chat.
[Discord](https://discord.gg/A3vanjZpqW) | [Github](https://github.com/wleka/wleku-s-chat) | [Telegram author](https://t.me/wleku) | [Website author](https://wleku.blog)
___
**wleku's chat** — Plugin on chat for Minecraft server, supporting from 26.2 and high. If you have trouble with plugin or you want see for update, please join to [Our Discord server](https://discord.gg/A3vanjZpqW)
___
## Features
- Supporting banwords
- Supporting ping player, if you're send nick to chat, if it in online.
- Can send you're coordinated, `:loc:` replaced to you location
- Can change join/quit messages or disable him.
- Change format chat
___
## Config.yml
```
## wleku's chat config plugin
## Original author by wleku.

## Format chat event
format: "§7%player% §8> §f%message%"

welcomeEvent: true
welcomeMessage: ""

## Quit message replacement
quitReplace: true
quitMessage: "§c[-] %player% leaved from server"

## Join message replacement
joinReplace: true
joinMessage: "§a[+] %player% joined to server"

## :loc: event
locEvent : true
locFormat: "[ %X%, %Y%, %Z% ]"

## Ping players
pingEvent : true
pingFormat: "[ %X%, %Y%, %Z% ]"
```