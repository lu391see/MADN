

case class Cell(value:Int) {
  def isSet:Boolean = value != 0
}

val cell1 = Cell(2)
cell1.isSet

val cell2 = Cell(0)
cell2.isSet

//case class Field(cells: LinkedList[Cell])

// TODO: Figure die Feld Nummer abspeichert
// TODO: Liste mit Feldern (Nummer, (x, y), belegt-bool, /*farbe)
// TODO: move methode die Kordinaten anhand der Feld Nummer ändert
// TODO: Matrix die das Spielfeld ausgibt


val field = Array(Int, (Int, Int), Boolean)
var y:Array[(Int, Int, Int, Boolean)] = new Array[(Int, Int, Int, Boolean)](121)

for(n <-0 to 10) {  // y-Koordinate
  for (i <- 0 to 10) {  // x-Koordinate
    y(n + i) = (0, i, n, false)
    if (n == 0 & i > 3 & i<7 ) print("x ")
    else if (n > 0 & n<4 & (i == 5 | i == 7)) print("x ")
    else if (n == 5 & ((i > 0 & i < 5) | i > 6)) print("x ")
    else print("  ")
  }
  print("\n")
  print("test")

  def main(args: Array[String]): Unit = {
    val player1 = scala.io.StdIn.readLine("1st Player, type your Name: ")
    val string1 = "Hello, " + player1 + ". Welcome to Mensch Aergere Dich Nicht!"
    val player2 = scala.io.StdIn.readLine("2nd Player, type your Name: ")
    val string2 = "Hello, " + player2 + ". Welcome to Mensch Aergere Dich Nicht!"
    println(s(
      """$string1
        |$string2
        |Watch out $player1 you will face $player2""".stripMargin))
  }





}
