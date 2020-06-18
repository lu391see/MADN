package de.htwg.se.madn.model
import scala.collection.mutable.ListBuffer

case class Board(board: List[Field[Cell]]) {
  def createPlayers(): List[Player] = {
    val playerListSize = scala.io.StdIn.readLine("Wieviele Spieler spielen?")
    var player_counter: Int = 1
    var buf = new ListBuffer[Player]()
    for (i <- 0 until playerListSize.toInt) {
      buf += new Player(scala.io.StdIn.readLine("Type your Name: "), player_counter)
      player_counter += 1
    }
    val players = buf.toList
    players
  }
  board
}
