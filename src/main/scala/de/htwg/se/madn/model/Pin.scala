package de.htwg.se.madn.model

case class Pin (index: Int){
  var position:Int = 0;
  def addPosition(add: Int): Unit = {
    position = position + add
  }
}
