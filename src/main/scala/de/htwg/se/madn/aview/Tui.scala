package de.htwg.se.madn.aview

import de.htwg.se.madn.controller.Controller
import de.htwg.se.madn.model.{Cell, Dice, Field, Player}
import de.htwg.se.madn.util.Observer

class Tui(controller: Controller, players : Array[Player]) extends Observer {
  override def update: Unit = println(controller.board.toString)
  controller.add(this)
  var s = ""
  def processInputLine(input: String, player: Player, dice: Dice): Unit = {
    input match {
      case "q" =>
      case "1"|"2"|"3"|"4" => controller.move(player, input, dice, players)
      case _   =>
        /* s = input + " is no valid entry"
        val new_input = scala.io.StdIn.readLine(s + "\n")
        processInputLine(new_input, player, dice)*/
    }
  }
}