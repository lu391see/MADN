package de.htwg.se.madn.model
import scala.collection.mutable.ListBuffer

case class Board(Field:Field[Cell]){
  def createplayers():List[Player] = {
    val playerlistsize = scala.io.StdIn.readLine("Wieviele Spieler spielen?")
    var player_counter: Int = 1
    var buf = new ListBuffer[Player]()
    for (i <- 0 until playerlistsize.toInt) {
      buf += new Player(scala.io.StdIn.readLine("Type your Name: "), player_counter)
      player_counter += 1
    }
    val players = buf.toList
  }
  createplayers()
}
