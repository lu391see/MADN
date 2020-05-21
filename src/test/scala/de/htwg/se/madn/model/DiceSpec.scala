package de.htwg.se.madn.model
import org.scalatest.{Matchers, WordSpec}

class DiceSpec extends WordSpec with Matchers{
  "A Dice " when { "thrown" should {
    val unthrownDice = Dice(1)
    "have a value 0" in {
      unthrownDice.roll should be(0)
    }
    "not be thrown" in {
      unthrownDice.isThrown should be(false)
    }
  }
  "set to a specific value" should {
    val thrownDice = Dice(0)
    "return that value" in {
      thrownDice.value should be () //randint
    }
    "be thrown" in {
      thrownDice.isThrown should be(true)
    }
  }

  }

}
