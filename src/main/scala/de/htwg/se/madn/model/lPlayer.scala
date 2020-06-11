package de.htwg.se.madn.model

trait Player{
  val index : Int
  val position : Int
  val team : Int
  val defaultPosition : Int
  val hasWon: Boolean
}
