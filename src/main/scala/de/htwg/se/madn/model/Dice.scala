package de.htwg.se.madn.model
import scala.util.Random

case class Dice(recipient : String) {
  val t1: Int = Random.nextInt(6) + 1
  val s1 = recipient + " has thrown " + t1.toString
}

def Init(Player:String){
  Dice(Player)
  if(Dice.t1 = 6) {
    if(){ //Wenn Feld1 nicht belegt ist
      //player.move....
      //break
    }

  }
}

case class Move(recipient: String) {

}
