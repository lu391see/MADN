package de.htwg.se.madn
import de.htwg.se.madn.aview.Tui
import javax.swing.plaf.TextUI
import model._

object Madn {
  def main(args: Array[String]): Unit = {
    val playerarraysize = scala.io.StdIn.readLine("Wieviele Spieler spielen?")
    var player_counter: Int = 1
    val players:Array[Player] = new Array[Player](playerarraysize.toInt)
    players(player_counter - 1) = new Player(scala.io.StdIn.readLine("Type your Name: "), player_counter, (player_counter - 1) * 10)
    val string1 = "Hello, " + players(0).name + ", Welcome to 'Mensch Aergere Dich Nicht'!"


    player_counter += 1

    players(player_counter - 1) = new Player(scala.io.StdIn.readLine("2nd Player, type your Name: "), player_counter, (player_counter - 1)* 10)
    val string2 = "Hello, " + players(1).name + ", Welcome to 'Mensch Aergere Dich Nicht'!"


    var s = ""
    s = "|" + string1 + "\n|" + string2 + "\n|" +
      s"""The game will start with 2 player(s).
         |Be careful $players(1).name + , you will face $players(0).name!\n"""
    var game = new Field[Cell](40, Cell(0))
    val tui = new Tui
    println(s.stripMargin)

    var turn_counter = 0

    var input: String = ""


    while(input != "q") {

      val dice = Dice()
      println(players(turn_counter).name + " can walk " + dice.t1)
      input = scala.io.StdIn.readLine()
      game = tui.processInputLine(input, game, players(turn_counter), dice)

      if(players(turn_counter).hasWon) {
        println(players(turn_counter).name + " has won")
        input = "q"//spiel beenden
      }
      turn_counter += 1
      if(turn_counter == player_counter) {
        turn_counter = turn_counter - player_counter
      }
      println("Current Game Status:" + game.toString)
    }
  }
}
