case class Cell (x: Int, y: Int, IsEmpty: Boolean)

case class Field(cells: Array[Cell])
val a = Field(Array.ofDim[Cell](121))
def isBuilt(field1: Field):Unit = {
  for (a <- 0 to 120) {
    field1.cells(a) = new Cell(a / 11, a % 11, true)
  }
}
val b = isBuilt(a)
print(b)