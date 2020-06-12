package de.htwg.se.madn.aview

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import de.htwg.se.madn.model.{Dice, Field, Cell, Player}
import de.htwg.se.madn.controller.Controller

class TuiSpec extends AnyWordSpec with Matchers{
  "A Tui" should {
    val a: Player = Player("a", 1)
    val d: Dice = Dice()
    val controller = new Controller(new Field[Cell](40, Cell(0)))
    val tui = new Tui(controller)
    "do nothing on input  'q'" in {

      tui.processInputLine("q", a, d) should be ()
    }
    "call move on input 1,2,3 or 4" in {
      tui.processInputLine("3",a, d)
      controller.board.cell(d.t1).value should be(a.pins(2).index)
    }
    "do nothing on other input" in {
      tui.processInputLine("z", a, d) should be ()
    }
  }
}
