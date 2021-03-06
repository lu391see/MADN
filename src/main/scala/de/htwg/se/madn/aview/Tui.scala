package de.htwg.se.madn.aview

import de.htwg.se.madn.model.{Cell, Dice, Field, Player}

class Tui {
  def processInputLine(input: String, board: Field[Cell], player: Player, dice: Dice): Field[Cell] = {
    var game : Field[Cell] = board
    input match {
      case "q" => game
      case "1" => if(player.pin1.position + dice.t1 < player.defaultPosition + 40) {
        game = game.replaceCell(player.pin1.position, Cell(0))
        player.pin1.addPosition(dice.t1)
        game.replaceCell(player.pin1.position, Cell(player.pin1.index))
      }
      else {
        player.hasWon = true
        game.replaceCell(player.pin1.position, Cell(0))
      }
      case "2" => if(player.pin2.position + dice.t1 < player.defaultPosition + 40) {
        game = game.replaceCell(player.pin2.position, Cell(0))
        player.pin2.addPosition(dice.t1)
        game.replaceCell(player.pin2.position, Cell(player.pin2.index))
      }
      else {
        player.hasWon = true
        game.replaceCell(player.pin2.position, Cell(0))
      }
      case "3" =>if(player.pin3.position + dice.t1 < player.defaultPosition + 40) {
        game = game.replaceCell(player.pin3.position, Cell(0))
        player.pin3.addPosition(dice.t1)
        game.replaceCell(player.pin3.position, Cell(player.pin3.index))
      }
      else {
        player.hasWon = true
        game.replaceCell(player.pin3.position, Cell(0))
      }
      case "4" =>if(player.pin4.position + dice.t1 < player.defaultPosition + 40) {
        game = game.replaceCell(player.pin4.position, Cell(0))
        player.pin4.addPosition(dice.t1)
        game.replaceCell(player.pin4.position, Cell(player.pin4.index))
      }
      else {
        player.hasWon = true
        game.replaceCell(player.pin4.position, Cell(0))
      }
      case _   =>
        val new_input = scala.io.StdIn.readLine("No valid Pin, try again!\n")
        processInputLine(new_input, game, player, dice)
    }
  }
}
