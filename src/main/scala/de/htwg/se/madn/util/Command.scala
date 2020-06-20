package de.htwg.se.madn.util

trait Command {

  def doStep:Unit
  def undoStep:Unit
  def redoStep:Unit
}
