package de.htwg.se.madn.model
import scala.util.Random

case class Dice(recipient : String) {
  val t1: Int = Random.nextInt(6) + 1
  val s1 = recipient + " has thrown " + t1.toString
}
