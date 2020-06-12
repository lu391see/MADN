package de.htwg.se.madn.controller
import org.scalatest.{Matchers, WordSpec}
import de.htwg.se.madn.model.{Dice, Field, Cell, Player}
import de.htwg.se.madn.util.Observer
import de.htwg.se.madn.controller.Controller
class ControllerSpec extends WordSpec with Matchers{
  "A Controller" when {
    "observed by an Observer" should {

      val controller = new Controller(new Field[Cell](40, Cell(0)))
      val observer = new Observer {
        var updated : Boolean = false
        def isUpdated: Boolean = updated
        override def update : Unit = updated = true
      }

      controller.add(observer)
      "notify its observer after moving" in{
        val a = new Player("a",1)
        controller.move(a, "1", new Dice)
        observer.updated should be(true)
      }
    }
  }

}
