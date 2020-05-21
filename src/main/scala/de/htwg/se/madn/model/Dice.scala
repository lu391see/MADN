package de.htwg.se.madn.model
import scala.util.Random

case class Dice(instantThrow:Int) {
  val range: Int = Random.nextInt(5) + 1
  println("You rolled %d", range)
}
