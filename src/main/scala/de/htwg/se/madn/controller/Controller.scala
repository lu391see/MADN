package de.htwg.se.madn.controller

import de.htwg.se.madn.model.{Cell, Dice, Field, Pin, Player}
import de.htwg.se.madn.util.Observable
// TODO: BUGFIXING (WERFEN)

class Controller(var board: Field[Cell]) extends Observable{
  def move(player: Player, input: String, dice: Dice, playerlist: Array[Player]): Unit = {
    val pin = player.pins(input.toInt -1)
    val newPinPos = pin.position + dice.t1
    if(newPinPos > 40) {
      if (board.cell(newPinPos - 40).isSet) {
        val myTeam : Int = pin.index / 10
        val occupantTeam : Int = Pin(board.cell(newPinPos).value).index / 10
        if(myTeam != occupantTeam) {
          //set old occupants position to default
          val calcTeam = board.cell(newPinPos).value / 10
          Pin(board.cell(newPinPos).value).setPosition(playerlist(calcTeam).defaultPosition)

          //Pin(board.cell(player.pins(input.toInt - 1).position + dice.t1).value).position = 0
          board = board.replaceCell(pin.position, Cell(0))
          board = board.replaceCell(newPinPos - 40, Cell(pin.index))
          board = board.replaceCell(pin.position, Cell(0))
          pin.addPosition(dice.t1)
        }
      }
      else {
        board = board.replaceCell(newPinPos - 40, Cell(pin.index))
        board = board.replaceCell(pin.position, Cell(0))
        pin.addPosition(dice.t1)
        //player.pins(input.toInt - 1).addPosition(-40)
      }
    }
    else {
      if (board.cell(newPinPos) != Cell(0)) {
        val myTeam : Int = pin.index / 10
        val occupantTeam : Int = Pin(board.cell(newPinPos).value).index / 10
        if(myTeam != occupantTeam) {
          //set old occupants position to default
          val calcTeam = board.cell(newPinPos).value / 10
          Pin(board.cell(newPinPos).value).setPosition(playerlist(calcTeam).defaultPosition)

          board = board.replaceCell(pin.position, Cell(0))
          board = board.replaceCell(newPinPos, Cell(pin.index))
          pin.addPosition(dice.t1)
          }
        }
      else {
        board = board.replaceCell(pin.position, Cell(0))
        board = board.replaceCell(newPinPos, Cell(pin.index))
        pin.addPosition(dice.t1)
      }
    }
    board
    notifyObservers
  }
}