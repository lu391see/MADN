package de.htwg.se.madn.controller

import de.htwg.se.madn.model.{Dice, Player}
import de.htwg.se.madn.util.Command

class MoveCommand(/*board: Board*/player: Player, input: String, dice: Dice, playerlist: Array[Player], controller: Controller) extends Command {
  override def doStep: Unit =    /*controller.board =*/ controller.move(player, input, dice, playerlist)

  override def undoStep: Unit = /*controller.board =*/ controller.move(player, input, dice, playerlist) // TODO: won't work this way

  override def redoStep: Unit = /*controller.board =*/ controller.move(player, input, dice, playerlist)
}
