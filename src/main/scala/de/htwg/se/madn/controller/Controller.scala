package de.htwg.se.madn.controller

import de.htwg.se.madn.model.{Cell, Dice, Field, Pin, Player}
import de.htwg.se.madn.util.Observable
// TODO: BUGFIXING (WERFEN)

class Controller(var board: Field[Cell]) extends Observable{
  def move(player: Player, input: String, dice: Dice, playerlist: Array[Player]): Unit = {

    val pin = player.pins(input.toInt -1)
    val newPinPos = pin.position + dice.t1

    if(newPinPos >= 40) {
      if (board.cell(newPinPos - 40).isSet) {

        val myTeam : Int = pin.index / 10
        val occupantTeam : Int = board.cell(newPinPos - 40).value / 10
        if(myTeam != occupantTeam) {
          // TODO: implement base
          playerlist(occupantTeam -1).pins(board.cell(newPinPos - 40).value - occupantTeam * 10 - 1).setPosition(playerlist(occupantTeam - 1).defaultPosition)
        } else
          return
      }
      board = board.replaceCell(pin.position, Cell(0))
      board = board.replaceCell(newPinPos - 40, Cell(pin.index))
      pin.addPosition(dice.t1)

    } else {
      if (board.cell(newPinPos).isSet) {
        val myTeam : Int = pin.index / 10
        val occupantTeam : Int = board.cell(newPinPos).value / 10
        if(myTeam != occupantTeam) {
          //set old occupants position to default
          playerlist(occupantTeam -1).pins(board.cell(newPinPos).value - occupantTeam * 10 - 1).setPosition(playerlist(occupantTeam - 1).defaultPosition)
          //Pin(board.cell(newPinPos).value).setPosition(playerlist(occupantTeam - 1).defaultPosition)
        } else
          return
      }
      board = board.replaceCell(pin.position, Cell(0))
      pin.addPosition(dice.t1)
      board = board.replaceCell(newPinPos, Cell(pin.index))
    }
    board
    notifyObservers
  }
}