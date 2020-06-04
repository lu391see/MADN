package de.htwg.se.madn.model

case class Field[T](spots: List[T]) {
  def this(size: Int, filling: T) = this(List.tabulate(size) { row => filling })

  val size: Int = spots.size

  def fill(filling:T):Field[T] = copy(List.tabulate(size){row => filling})

  def cell(spot: Int): T = spots(spot)

  def replaceCell(spot: Int, cell: T): Field[T] = copy(spots.updated(spot, cell))

  override def toString: String = {
    var s = ""
    for {spot <- 0 until size} yield {s += cell(spot).toString}
    s
  }

}
