package de.htwg.se.madn.model
import org.scalatest.{Matchers, WordSpec}

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "set to Lukas" should {
      val player = Player("Lukas", 1)
      "have a name" in {
        player.name should be("Lukas")
      }
      "have a nice String representation" in {
        player.toString should be("Player 1: Lukas")
      }
      "not set to Winner yet" in {
        player.hasWon should be(false)
      }
      "have 4 pins with number in front of index" in {
        player.team should be(1)
        player.pin1.index should be(11)
        player.pin1.position should be(0)
        //player.pin1 should be (Pin(11))
        player.pin2.index should be(12)
        player.pin4.index should be(14)
      }
    }
  }


}