package de.htwg.se.madn.controller

import de.htwg.se.madn.model.{Cell, Dice, Field, Pin, Player}
import de.htwg.se.madn.util.Observable

class Controller(var board: Field[Cell]) extends Observable{
  def move(player: Player, input: String, dice: Dice): Unit = {
    //var board : Field[Cell] = game
    if (player.pins(input.toInt - 1).position + dice.t1 < player.defaultPosition + 40) {
      board = board.replaceCell(player.pins(input.toInt - 1).position, Cell(0))
    if (board.cell(player.pins(input.toInt - 1).position + dice.t1) != Cell(0)) {
      Pin(board.cell(player.pins(input.toInt - 1).position + dice.t1).value).position = 0
      board = board.replaceCell(player.pins(input.toInt - 1).position + dice.t1, Cell(player.pins(input.toInt - 1).index))
    }
    else
      player.pins(input.toInt - 1).addPosition(dice.t1)
      board = board.replaceCell(player.pins(input.toInt-1).position, Cell(player.pins(input.toInt - 1).index))
    }
    /*else {
      player.hasWon = true
      board.replaceCell(player.pins(input.toInt - 1).position, Cell(0))
    }*/
    board
    notifyObservers
  }
}