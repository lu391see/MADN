package de.htwg.se.madn.model

case class Player(name: String,
                  team: Int, defaultPosition: Int) {
  var hasWon :Boolean = false
  //def this(name: String) = this(name, team, defaultPosition, false)
  val pin1 = new Pin(team * 10 + 1)
  pin1.addPosition(defaultPosition)

  val pin2 = new Pin(team * 10 + 2)
  pin2.addPosition(defaultPosition)

  val pin3 = new Pin(team * 10 + 3)
  pin3.addPosition(defaultPosition)

  val pin4 = new Pin(team * 10 + 4)
  pin4.addPosition(defaultPosition)
}
