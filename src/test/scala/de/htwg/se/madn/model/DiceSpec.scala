package de.htwg.se.madn.model
import org.scalatest.{Matchers, WordSpec}

class DiceSpec extends WordSpec with Matchers{
  "A Dice " when {
    "thrown" should {
      val Dice = new Dice("yellow")
      "have a value between 1 and 6" in {
        Dice.t1 should (be > 0 and <7)
      }
    }
  }
}
