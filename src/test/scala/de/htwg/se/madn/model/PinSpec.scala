package de.htwg.se.madn.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class PinSpec extends AnyWordSpec with Matchers{
  "A Pin" when {
    "set to 21" should {
      val pin21 = Pin(21)
      "have position" in {
        pin21.position should be(0)
      }
      "change position after add" in {
        pin21.addPosition(10)
        pin21.position should be(10)
      }
      "reduce position if over 40" in {
        pin21.addPosition(31)
        pin21.position should be(1)
      }
    }
  }
}
