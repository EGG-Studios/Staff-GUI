package org.eggstudios.staffGUI.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import org.eggstudios.staffGUI.dialogs.StaffDialog

class StaffCommand : CommandExecutor, TabCompleter {
    override fun onCommand(
        p0: CommandSender,
        p1: Command,
        p2: String,
        p3: Array<out String>
    ): Boolean {
        if (p0 is Player) {
            val target = Bukkit.getOfflinePlayer(p3[0])
            val dialog = StaffDialog(p0, target).createDialog()
            p0.showDialog(dialog)
        }
        return false
    }

    override fun onTabComplete(
        p0: CommandSender,
        p1: Command,
        p2: String,
        p3: Array<out String>
    ): List<String>? {
        if (p3.size == 1) {
            val input = p3[0].lowercase()

            return Bukkit.getOfflinePlayers().mapNotNull { it.name }.filter { it.startsWith(input) }
        }

        return null
    }
}