import scala.util.Random

case class Dice(recipient : String) {
  val t1: Int = Random.nextInt(6) + 1
  val s1 = recipient + " has thrown " + t1.toString
  println(s1)
}

val d1 = new Dice("yellow")

val d2 = new Dice("blue")

val d3 = new Dice("red")

val d4 = new Dice("green")
