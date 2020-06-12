package de.htwg.se.madn.aview

import de.htwg.se.madn.controller.Controller
import de.htwg.se.madn.model.{Cell, Dice, Field, Player}
import de.htwg.se.madn.util.Observer

class Tui(controller: Controller) extends Observer {
  override def update: Boolean = {println(controller.board.toString);true}
  controller.add(this)

  def processInputLine(input: String, player: Player, dice: Dice): Unit = {
    input match {
      case "q" =>
      case "1"|"2"|"3"|"4" => controller.move(player, input, dice)
      case _   =>
        val new_input = scala.io.StdIn.readLine("No valid Pin, try again!\n")
        processInputLine(new_input, player, dice)
    }
  }
}
