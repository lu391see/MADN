package de.htwg.se.madn.model


case class Player(name: String, team: Int) {
  //def this(name: String) = this(name, team, defaultPosition, false)
  val defaultPosition : Int = (team-1) * 10
  var house = new Field[Cell](4, Cell(0))
  var start = new Field[Cell](4, Cell(0))
  var hasWon :Boolean = false

  val pin1 = Pin(team * 10 + 1)
  pin1.addPosition(defaultPosition)

  val pin2 = Pin(team * 10 + 2)
  pin2.addPosition(defaultPosition)

  val pin3 = Pin(team * 10 + 3)
  pin3.addPosition(defaultPosition)

  val pin4 = Pin(team * 10 + 4)
  pin4.addPosition(defaultPosition)
  val pins = List(pin1, pin2, pin3, pin4)

  override def toString: String = {
    "Player " + team + ": " + name
  }
}