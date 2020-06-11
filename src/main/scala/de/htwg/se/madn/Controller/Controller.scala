package de.htwg.se.madn.controller

import de.htwg.se.madn.model.{Cell, Field, Player, Dice}
import de.htwg.se.madn.util.Observable

class Controller(var field: Field[Cell]) extends Observable{
  def move(player: Player, input: String, dice: Dice, game: Field[Cell]): Field[Cell] = {
    var board : Field[Cell] = game
    if (player.pins(input.toInt - 1).position + dice.t1 < player.defaultPosition + 40) {
      board = board.replaceCell(player.pins(input.toInt - 1).position, Cell(0))
      player.pins(input.toInt - 1).addPosition(dice.t1)
      board.replaceCell(player.pins(input.toInt).position, Cell(player.pins(input.toInt - 1).index))
    }
    else {
      player.hasWon = true
      board.replaceCell(player.pins(input.toInt - 1).position, Cell(0))
    }
  }
}
