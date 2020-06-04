package de.htwg.se.madn.model
import scala.util.Random

case class Dice() {
  val t1: Int = Random.nextInt(6) + 1
}