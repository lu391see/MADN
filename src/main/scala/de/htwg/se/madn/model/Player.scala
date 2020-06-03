package de.htwg.se.madn.model

case class Player(name: String,
                  team: Int, defaultPosition: Int) {
  var hasWon :Boolean = false
  //def this(name: String) = this(name, team, defaultPosition, false)
  val pin1 = new Pin(1*team)
  pin1.addPosition(10*team)
  val pin2 = new Pin(2*team)
  pin2.addPosition(10*team)
  val pin3 = new Pin(3*team)
  pin3.addPosition(10*team)
  val pin4 = new Pin(4*team)
  pin4.addPosition(10*team)
}
