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
        this.getCommand("staffgui")?.setExecutor(staffCommand)
        logger.info("Command has been registered.")
    }
}
