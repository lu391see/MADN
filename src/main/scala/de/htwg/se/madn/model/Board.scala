package de.htwg.se.madn.model
import scala.collection.mutable.ListBuffer

case class Board(fields : Field[Cell]){
  //implement wie Field, Board ist List aus Fields
  def CreatePlayers(): List[Player] = {
    val PlayerListSize = scala.io.StdIn.readLine("Wieviele Spieler spielen?")
    var player_counter: Int = 1
    var buf = new ListBuffer[Player]()
    for (i <- 0 until PlayerListSize.toInt) {
      buf += new Player(scala.io.StdIn.readLine("Type your Name: "), player_counter)
      player_counter += 1
    }
    val players = buf.toList
    players
  }
  def CreateHouses(number : Int): Unit = {
    for(i <- 0 until number){
      addHouse(new Field[Cell](4, Cell(0)))
    }
  }
  def addHouse (Field:Field[Cell]): Board = {
    var buf = new ListBuffer[Field[Cell]]
    for (i <- 0 to Board.length){
      buf += Board(i)
    }
    buf += Field
    Board = new Board(buf.toList)
  }
}
