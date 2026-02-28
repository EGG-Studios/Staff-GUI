package org.eggstudios.staffGUI

import org.bukkit.plugin.java.JavaPlugin
import org.eggstudios.staffGUI.commands.StaffCommand

class StaffGUI : JavaPlugin() {
    lateinit var staffCommand: StaffCommand

    override fun onEnable() {
        staffCommand = StaffCommand()
        registerCommand()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun registerCommand() {
        getCommand("staff")?.apply {
            setExecutor(staffCommand)
            tabCompleter = staffCommand
        }
        logger.info("Command has been registered!")
    }
}
