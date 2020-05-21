package de.htwg.se.madn
import model._

object Madn {
  def main(args: Array[String]): Unit = {
    val player1 = scala.io.StdIn.readLine("Type your Name: ")
    val string1 = "Hello, " + player1 + ", Welcome to 'Mensch Aergere Dich Nicht'!"
    val player2 = scala.io.StdIn.readLine("2nd Player, type your Name: ")
    val string2 = "Hello, " + player2 + ", Welcome to 'Mensch Aergere Dich Nicht'!"
    var s = ""
    s = "|" + string1 + "\n|" + string2 + "\n|" +
      s"""The game will start with 2 player(s).
         |Be careful $player2, you will face $player1!\n"""
    val game = new Matrix[Cell](11, Cell(0))
    s += game.toString
    println(s.stripMargin)
  }
}
