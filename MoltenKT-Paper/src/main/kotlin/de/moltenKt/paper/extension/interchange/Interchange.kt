package de.moltenKt.paper.extension.interchange

import de.moltenKt.paper.app.MoltenCache
import de.moltenKt.paper.extension.paper.server
import org.bukkit.Bukkit
import org.bukkit.Bukkit.getPluginCommand
import org.bukkit.command.CommandSender
import org.bukkit.command.SimpleCommandMap

typealias InterchangeExecutor = CommandSender

typealias Parameters = Array<out String>

fun getInterchange(label: String, allowPluginIdentity: Boolean = true) =
    MoltenCache.registeredInterchanges.firstOrNull {
        it.label == label || (allowPluginIdentity && label == "${it.vendor.name.lowercase()}:${it.label}")
    }

/*
fun getServerCommand(label: String) =
    getPluginCommand(label) ?: Bukkit.getCommandMap().getCommand(label) ?: SimpleCommandMap(server).getCommand(label)*/