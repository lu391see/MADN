import de.htwg.se.madn.model.{Cell, Field}


case class Board(cells: Field[Cell]) {
  def this(size: Int) = this(new Field[Cell](size, Cell(0)))
  val size: Int = cells.size
  def cell(row: Int): Cell = cells.cell(row)
}