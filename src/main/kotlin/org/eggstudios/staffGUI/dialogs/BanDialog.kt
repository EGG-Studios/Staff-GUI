package org.eggstudios.staffGUI.dialogs

import io.papermc.paper.dialog.Dialog
import io.papermc.paper.registry.data.dialog.DialogBase
import io.papermc.paper.registry.data.dialog.body.DialogBody
import io.papermc.paper.registry.data.dialog.type.DialogType
import net.kyori.adventure.text.Component
import org.bukkit.OfflinePlayer

class BanDialog(var target: OfflinePlayer) {
    // TODO: Logic for the ban dialog
    fun createDialog() {
//        val dialog = Dialog.create { builder -> builder.empty()
//            .base(
//                DialogBase.builder(Component.text(target.name.toString()))
//                .inputs(listOf(targetB))
//                .body(listOf(DialogBody.plainMessage(Component.text("HI"))))
//                .build())
//            .type(DialogType.multiAction(actions).build()) }
    }
}