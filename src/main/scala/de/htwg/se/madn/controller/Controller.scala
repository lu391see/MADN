package de.htwg.se.madn.controller

import de.htwg.se.madn.model.{Cell, Dice, Field, Pin, Player}
import de.htwg.se.madn.util.Observable

class Controller(var board: Field[Cell]) extends Observable{
  def move(player: Player, input: String, dice: Dice, playerlist: List[Player]): Unit = {
    if(player.pins(input.toInt - 1).position + dice.t1 > player.defaultPosition + 40) {
      if (board.cell(player.pins(input.toInt - 1).position + dice.t1 - 40) != Cell(0)) {
        //isMyTeam: Drawing pin / pin at position
        val isMyTeam : Int = Pin(board.cell(player.pins(input.toInt - 1).position + dice.t1).value).index / player.pins(input.toInt - 1).index
        if(isMyTeam != 0) {
          //set old occupants position to default
          val calcTeam = board.cell(player.pins(input.toInt - 1).position + dice.t1).value / 10
          Pin(board.cell(player.pins(input.toInt - 1).position + dice.t1).value).addPosition(-(player.pins(input.toInt - 1).position + dice.t1))
          Pin(board.cell(player.pins(input.toInt - 1).position + dice.t1).value).addPosition(playerlist(calcTeam).defaultPosition)


          Pin(board.cell(player.pins(input.toInt - 1).position + dice.t1).value).position = 0
          board = board.replaceCell(player.pins(input.toInt - 1).position, Cell(0))
          board = board.replaceCell(player.pins(input.toInt - 1).position + dice.t1 - 40, Cell(player.pins(input.toInt - 1).index))
          player.pins(input.toInt - 1).addPosition(dice.t1)
          player.pins(input.toInt - 1).addPosition(-40)
        }
      }
      else {
        board = board.replaceCell(player.pins(input.toInt - 1).position + dice.t1 - 40, Cell(player.pins(input.toInt - 1).index))
        player.pins(input.toInt - 1).addPosition(dice.t1)
        player.pins(input.toInt - 1).addPosition(-40)
      }
    }
    else {
      if (board.cell(player.pins(input.toInt - 1).position + dice.t1) != Cell(0)) {
        //isMyTeam: Drawing pin / pin at position
        val isMyTeam : Int = Pin(board.cell(player.pins(input.toInt - 1).position + dice.t1).value).index / player.pins(input.toInt - 1).index
        if (isMyTeam != 0) {
          //set old occupants position to default
          val calcTeam = board.cell(player.pins(input.toInt - 1).position + dice.t1).value / 10
          Pin(board.cell(player.pins(input.toInt - 1).position + dice.t1).value).addPosition(-(player.pins(input.toInt - 1).position + dice.t1))
          Pin(board.cell(player.pins(input.toInt - 1).position + dice.t1).value).addPosition(playerlist(calcTeam).defaultPosition)

          board = board.replaceCell(player.pins(input.toInt - 1).position, Cell(0))
          board = board.replaceCell(player.pins(input.toInt - 1).position + dice.t1, Cell(player.pins(input.toInt - 1).index))
          player.pins(input.toInt - 1).addPosition(dice.t1)
          }
        }
      else {
        board = board.replaceCell(player.pins(input.toInt - 1).position, Cell(0))
        board = board.replaceCell(player.pins(input.toInt - 1).position + dice.t1, Cell(player.pins(input.toInt - 1).index))
        player.pins(input.toInt - 1).addPosition(dice.t1)
      }
    }


    board
    notifyObservers
  }
}