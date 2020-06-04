package de.htwg.se.madn.model
import org.scalatest.{Matchers, WordSpec}

class DiceSpec extends WordSpec with Matchers{
  "A Dice " when {
    "thrown" should {
      val dice = new Dice()
      "have a value between 1 and 6" in {
        dice.t1.isInstanceOf[Int]
        dice.t1.toString matches "1|2|3|4|5|6"
      }
    }
  }
}
