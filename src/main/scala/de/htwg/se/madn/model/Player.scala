package de.htwg.se.madn.model

case class Player(name: String, override val index: Int, override val position: Int,
                  override val team: Int, override val defaultPosition: Int,
                  override val hasWon: Boolean = false) extends lPlayer {

  def this(name: String) = this(name, player_counter, 0, player_counter, false)
  val pins: List(0, 0, 0, 0) //Erstellt Liste mit Pins (Spielfiguren für Player)
  pins.zipWithIndex //Outcome: List((0, 0), (0, 0), (0, 0), (0, 0)) der Form List((Position, Index), ...)


  }
}
