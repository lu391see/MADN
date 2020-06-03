package de.htwg.se.madn
import model._

object Madn {
  def main(args: Array[String]): Unit = {
    val playerarraysize = scala.io.StdIn.readLine("Wieviele Spieler spielen?")
    var player_counter: Int = 1
    val players:Array[Player] = new Array[Player](playerarraysize.toInt)
    players(player_counter - 1) = new Player(scala.io.StdIn.readLine("Type your Name: "), player_counter -1, (player_counter - 1) * 10)
    val string1 = "Hello, " + players(0).name + ", Welcome to 'Mensch Aergere Dich Nicht'!"


    player_counter += 1

    players(player_counter - 1) = new Player(scala.io.StdIn.readLine("2nd Player, type your Name: "), player_counter -1, (player_counter - 1)* 10)
    val string2 = "Hello, " + players(1).name + ", Welcome to 'Mensch Aergere Dich Nicht'!"


    var s = ""
    s = "|" + string1 + "\n|" + string2 + "\n|" +
      s"""The game will start with 2 player(s).
         |Be careful $players(1).name + , you will face $players(0).name!\n"""
    val game = new Field[Cell](40, Cell(0))
    s += game.toString
    println(s.stripMargin)


    var turn_counter = 0


    var input: String = ""


    while(input != "q") {
      println(players(turn_counter).name)
      val Dice = new Dice()
      input = scala.io.StdIn.readLine("Choose which pin should move %d tiles\n" , Dice.t1)

      input match {
        case "q" => println("quiiting game!")
        case "1" => if(players(turn_counter).pin1.position + Dice.t1 < players(turn_counter).defaultPosition + 40) {
                      players(turn_counter).pin1.addPosition(Dice.t1)
                      println(players(turn_counter).pin1.position)
                    }
                    else {
                      players(turn_counter).hasWon = true
                    }
        case "2" => if(players(turn_counter).pin2.position + Dice.t1 < players(turn_counter).defaultPosition + 40) {
                      players(turn_counter).pin2.addPosition(Dice.t1)
                      println(players(turn_counter).pin2.position)
                    }
                    else {
                      players(turn_counter).hasWon = true
                    }
        case "3" =>if(players(turn_counter).pin3.position + Dice.t1 < players(turn_counter).defaultPosition + 40) {
                      players(turn_counter).pin3.addPosition(Dice.t1)
                      println(players(turn_counter).pin3.position)
                    }
                    else {
                      players(turn_counter).hasWon = true
                    }
        case "4" =>if(players(turn_counter).pin4.position + Dice.t1 < players(turn_counter).defaultPosition + 40) {
                      players(turn_counter).pin4.addPosition(Dice.t1)
                      println(players(turn_counter).pin4.position)
                    }
                    else {
                      players(turn_counter).hasWon = true
                    }
        case _   => println("error, exiting game!")
                    input = "q"
      }
      if(players(turn_counter).hasWon) {
        println(players(turn_counter).name + " has won")
        input = "q"//spiel beenden
      }
      turn_counter += 1
      if(turn_counter == player_counter) {
        turn_counter = turn_counter - player_counter
      }
    }
  }
}
