case class Cell(value:Int) {
  def isSet:Boolean = value !=0
}

val cell1 = Cell(2)
cell1.isSet
val cell2 = Cell(3)
cell1.isSet

case class Matrix[T] (rows:Vector[Vector[T]]) {
  def this(size:Int, filling:T) = this(Vector.tabulate(size,size){(row,col) => filling})
  val size = rows.size
  def cell(row:Int, col:Int):T = rows(row)(col)
  def replaceCell(row:Int, col:Int, cell:T):Matrix[T] = copy(rows.updated(row, rows(row).updated(col, cell)))
  def fill (filling:T):Matrix[T] = copy(Vector.tabulate(size, size){(row, col) => filling})
}
val matrix = Matrix(Vector(Vector(cell1, cell2)))
val matrix1 = new Matrix[Cell](11, Cell(0))




matrix.rows(0)(0).value
matrix.size
matrix.cell(0,0).value

val replaced = matrix.replaceCell(0,0, Cell(4))
replaced.cell(0,0).value

val filledWithEmptyCells = new Matrix(Vector(Vector(cell1,cell2))).fill(Cell(0))
filledWithEmptyCells.cell(0,0).value

case class Grid(cells:Matrix[Cell]) {
  def this(size:Int) = this(new Matrix[Cell](size, Cell(0)))
  val size:Int = cells.size
  def cell(row:Int, col:Int):Cell = cells.cell(row,col)
  def set(row:Int, col:Int, value:Int):Grid = copy(cells.replaceCell(row, col, Cell(value)))

}

val grid1 = new Grid(4)
grid1.size

grid1.cell(0,0).isSet
val grid2 = grid1.set(0,0,1)
grid2.cell(0,0).isSet

def output(grid: Grid):String = {
  var s = ""
  for (vec <- grid.cells.rows) {
    for (cell <- vec) {
      s += cell.value
    }
  }
  s += "|"
  val st = s
}
output(grid1)
