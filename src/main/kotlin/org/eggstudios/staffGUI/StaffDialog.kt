package org.eggstudios.staffGUI

import io.papermc.paper.dialog.Dialog
import io.papermc.paper.registry.data.dialog.ActionButton
import io.papermc.paper.registry.data.dialog.DialogBase
import io.papermc.paper.registry.data.dialog.action.DialogAction
import io.papermc.paper.registry.data.dialog.body.DialogBody
import io.papermc.paper.registry.data.dialog.input.DialogInput
import io.papermc.paper.registry.data.dialog.type.DialogType
import net.kyori.adventure.text.Component
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player

class StaffDialog(val player: Player, val target: OfflinePlayer) {
    fun createDialog(): Dialog{
        val targetB = DialogInput.text("target", Component.text("Player name")).initial(target.name.toString()).build()
        val actions = mutableListOf<ActionButton>()

        if (target.isBanned) {
            actions.add(ActionButton.builder(Component.text("Unban"))
                .tooltip(Component.text("Click to unban this player"))
                .action(DialogAction.commandTemplate("pardon \$(target)"))
                .build())
        } else {
            actions.add(ActionButton.builder(Component.text("Kick"))
                .tooltip(Component.text("Click to kick this player"))
                .action(DialogAction.commandTemplate("pardon \$(target)"))
                .build())

            actions.add(ActionButton.builder(Component.text("Ban"))
                .tooltip(Component.text("Click to ban this player"))
                .action(DialogAction.commandTemplate("ban \$(target)"))
                .build())
        }

        val dialog = Dialog.create { builder -> builder.empty()
            .base(DialogBase.builder(Component.text(target.name.toString()))
                .inputs(listOf(targetB))
                .body(listOf(DialogBody.plainMessage(Component.text("HI"))))
                .build())
            .type(DialogType.multiAction(actions).build()) }

        return dialog
    }
}