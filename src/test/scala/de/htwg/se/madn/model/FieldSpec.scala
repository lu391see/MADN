package de.htwg.se.madn.model
import org.scalatest.{Matchers, WordSpec}

class FieldSpec extends WordSpec with Matchers {
  "Matrix is an immutable data type that contains a two-dimentional Vector of Cells."
  "A Matrix" when {
    "empty " should {
      "be created by using a dimention and a sample cell" in {
        val matrix = new Field[Cell](2, Cell(0))
        matrix.size should be(2)
      }
      "for test purposes only be created with a Vector of Vectors" in {
        val testMatrix = Field(List(Cell(0)))
        testMatrix.size should be(1)
      }
    }
    "filled" should {
      val matrix = new Field[Cell](2, Cell(5))
      "give access to its cells" in {
        matrix.cell(0) should be(Cell(5))
        matrix.cell(1) should be(Cell(5))
      }
      "replace cells and return a new data structure" in {
        val returnedMatrix = matrix.replaceCell(0, Cell(4))
        matrix.cell(0) should be(Cell(5))
        returnedMatrix.cell(0) should be(Cell(4))
        returnedMatrix.cell(1) should be(Cell(5))
      }
      "be filled using fill operation" in {
        val returnedMatrix = matrix.fill(Cell(3))
        returnedMatrix.cell(0) should be(Cell(3))
        returnedMatrix.cell(1) should be(Cell(3))
      }
      "String contain only 5s" in {
        matrix.toString contains "[5]"
      }
    }
  }
}
