package de.htwg.se.madn.model
import org.scalatest.{Matchers, WordSpec}

class DiceSpec extends WordSpec with Matchers{
  "A Dice " when {
    "thrown" should {
      val dice = new Dice("yellow")
      "have a value between 1 and 6" in {
        dice.t1.isInstanceOf[Int]
        dice.t1.toString matches "1|2|3|4|5|6"
      }
      "when printed look like" in {
        dice.s1 matches s"$dice.recipient has thrown $dice.t1"
      }
      "recipient as Team" in {
        dice.recipient should be("yellow")
      }
    }
  }
}
