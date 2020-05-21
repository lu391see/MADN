package de.htwg.se.madn.model

case class Matrix[T](rows:Vector[Vector[T]]) {
  def this(size: Int, filling: T) = this(Vector.tabulate(size, size) { (row, col) => filling })

  val size: Int = rows.size

  def fill(filling:T):Matrix[T] = copy(Vector.tabulate(size, size){(row, col) => filling})

  def cell(row: Int, col: Int): T = rows(row)(col)

  def replaceCell(row: Int, col: Int, cell: T): Matrix[T] = copy(rows.updated(row, rows(row).updated(col, cell)))

  override def toString: String = {
    var s = ""
    for {row <- 0 until size} yield {s+= "\n"; for {col <- 0 until size} yield s += cell(row, col).toString}
    s
  }
}
