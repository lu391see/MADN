package de.htwg.se.madn.model
import org.scalatest.{Matchers, WordSpec}

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "set to Lukas" should {
      val player = Player("Lukas")
      "have a name" in {
        player.name should be("Lukas")
        //player.name.isInstanceOf[String]
      }
      "have a nice String representation" in {
        player.toString should be("Lukas")
      }
    }
  }


}