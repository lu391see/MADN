import de.htwg.se.madn.model.{Cell, Field}


case class Board(cells: Field[Cell]) {
  def this(size: Int) = this(new Field[Cell](size, Cell(0)))
  val size: Int = cells.size
  def cell(row: Int): Cell = cells.cell(row)
}
var x = 10



var s = ""
val game = new Field[Cell](11, Cell(0))
s += game.toString
println(s.stripMargin)