package de.htwg.se.madn.controller

import de.htwg.se.madn.model.{Dice, Player}
import de.htwg.se.madn.util.Command

class MoveCommand(/*board: Board*/player: Player, input: String, distance: Int, playerlist: Array[Player], controller: Controller) extends Command {
  override def doStep: Unit =    /*controller.board =*/ controller.move(player, input, distance, playerlist)

  override def undoStep: Unit = /*controller.board =*/ controller.move(player, input, distance, playerlist) // TODO: won't work this way

  override def redoStep: Unit = /*controller.board =*/ controller.move(player, input, distance, playerlist)
}
