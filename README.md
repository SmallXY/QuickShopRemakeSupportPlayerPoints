# QuickShop-Reremake Support PlayerPoints

## by SmallXY(小玄易)


## Original author's sign
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/e33e2fafe3ac4d4eb9048d154bbd874e)](https://www.codacy.com/gh/PotatoCraft-Studio/QuickShop-Reremake/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=PotatoCraft-Studio/QuickShop-Reremake&amp;utm_campaign=Badge_Grade)
[![CodeFactor](https://www.codefactor.io/repository/github/potatocraft-studio/quickshop-reremake/badge)](https://www.codefactor.io/repository/github/potatocraft-studio/quickshop-reremake)
![BuildStatus](https://ci.codemc.io/job/PotatoCraft-Studio/job/QuickShop-Reremake/21/badge/icon)
![TestsPassed](https://img.shields.io/jenkins/tests?compact_message&jobUrl=https://ci.codemc.io/job/PotatoCraft-Studio/job/QuickShop-Reremake)
![Contributors](https://img.shields.io/github/contributors/potatocraft-studio/QuickShop-Reremake)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2FPotatoCraft-Studio%2FQuickShop-Reremake.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2FPotatoCraft-Studio%2FQuickShop-Reremake?ref=badge_shield)
---
![Java](https://img.shields.io/badge/java-version%208%2B%20(currently%20is%208--16)-orange)
![MC](https://img.shields.io/badge/minecraft-java%20edition%201.15%2B-blueviolet)
![Ver](https://img.shields.io/spiget/version/62575?label=version)
![Downloads](https://img.shields.io/spiget/downloads/62575?label=downloads)
![Rating](https://img.shields.io/spiget/rating/62575?label=rating)
---


## EN

QuickShop is a **FREE** shop plugin that allows players to easily sell/buy any items from a chest without any commands. In fact,
none of the commands that QuickShop provides are ever needed by a player. QuickShop-Reremake is a **FREE** fork of QuickShop
NotLikeMe with more features, bug fixes and other improvements.  
QuickShop-Reremake is made by PotatoCraft Studio

## CN

QuickShop是一个**免费**商店插件，允许玩家在没有任何命令的情况下轻松地从箱子里出售/购买任何物品。事实
Quickhop提供的任何命令都不是玩家所需要的。QuickhopReremake是Quickhop的**免费**分支
NotLikeMe具有更多功能、错误修复和其他改进。
Quickhop Reremake由PotatoCraft工作室制作
Quickhop Reremake Support PlayerPoints 由 Cyanbukkit - 小玄易 制作 

from [KaiKikuchi's QuickShop upstream repository](https://github.com/KaiKikuchi/QuickShop).

## Original author's Support

| <a href="https://discord.gg/bfefw2E"/> <img src="/.github/icons/Discord.svg" width="100" height="100" />| <a href="https://github.com/PotatoCraft-Studio/QuickShop-Reremake/issues"><img src="/.github/icons/Github.png" width="100" height="100" />|
| :---: | :---: |
| [**Discord**](https://discord.gg/bfefw2E) | [**Github Issues**](https://github.com/PotatoCraft-Studio/QuickShop-Reremake/issues) |

## Features EN

- Easy to use
- Toggleable Display Item on top of the chest
- NBT Data, Enchantment, Tool Damage, Potion, and Mob Egg support
- Unlimited chest support
- Blacklist support & bypass permissions
- Shops that buy and sell items at the same time (Using double chests)
- Customisable permission checks
- UUID support
- Better shop protection [Reremake]
- Item display name i18n [Reremake]
- Enchantment display name i18n [Reremake]
- A cool item preview [Reremake]
- World/region protection plugins support [Reremake]
- ProtocolLib based Virtual DisplayItem support [Reremake]
- Powerful API [Reremake]
- Optimized performance [Reremake]

## features CN

- 易于使用
- 箱子顶部的可切换显示项
- NBT数据、魔法、工具伤害、药剂和怪物蛋支持
- 箱子无限制支撑
- 黑名单支持和绕过权限
- 同时买卖物品的商店（使用双箱子）
- 可自定义权限检查
- UUID支持
- 更好的保护[重新制造]
- 项目显示名称i18n[重新标记]
- 魔法显示名称i18n[重制]
- 很酷的项目预览[重新制作]
- 世界/地区保护插件支持[Reremake]
- 基于ProtocolLib的虚拟显示项支持[Reremake]
- 强大的API[重做]
- 优化性能[重新制造]

## Downloads

| <a href="https://www.spigotmc.org/resources/62575/"><img src="/.github/icons/Spigot.png" width="100" height="90" /></a> | <a href="https://dev.bukkit.org/projects/quickshop-reremake"><img src="/.github/icons/Bukkit.png" width="100" height="100" /></a></a> | <a href="https://www.mcbbs.net/thread-1426607-1-1.html"><img src="/.github/icons/MCBBS.png" width="100" height="100" /></a> | <a href="https://ci.codemc.io/job/PotatoCraft-Studio/job/QuickShop-Reremake-SNAPSHOT/"><img src="/.github/icons/Jenkins.svg" width="85" height="100" /></a> |
 |:-----------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                                       **Spigot**                                                        |                                                             **BukkitDev**                                                             |                                                         **中国本土化简介**                                                         |                                                                         **Jenkins**                                                                         |

## Contribute

If you're a developer, you can contribute to the QuickShop code! Just make a fork and install the Lombok plugin,
then make a pull request when you're done! Please try to
follow [Google Java Style](https://google.github.io/styleguide/javaguide.html). Also do not increase the plugin version
number. Thank you very much!

To compile the QuickShop and debug it by yourself, please follow these steps:

0. Make sure you're using Java16 JDK in your PATH.
1. Compile main-project without signature by using debug profile: `mvn install -Pdebug`
2. Start your server with extra flag to skip the QuickShop signature
   checks: `-Dorg.maxgamer.quickshop.util.envcheck.skip.SIGNATURE_VERIFY`

## Maven

```XML

<repository>
    <id>quickshop-repo</id>
    <url>https://repo.codemc.io/repository/maven-public/</url>
</repository>

<dependency>
<groupId>org.maxgamer</groupId>
<artifactId>QuickShop</artifactId>
<version>{VERSION}</version>
<scope>provided</scope>
</dependency>
```

## Bstats

[![BigImage](https://bstats.org/signatures/bukkit/QuickShop-Reremake.svg)](https://bstats.org/plugin/bukkit/QuickShop-Reremake/3320)

## License

[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2FPotatoCraft-Studio%2FQuickShop-Reremake.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2FPotatoCraft-Studio%2FQuickShop-Reremake?ref=badge_large)

## Developer API

```java
Plugin plugin = Bukkit.getPluginManager().getPlugin("QuickShop");
if(plugin != null){
    QuickShopAPI api = (QuickShopAPI)plugin;
    api.xxxx;
}
```
