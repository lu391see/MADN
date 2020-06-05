package de.htwg.se.madn.controller

import de.htwg.se.madn.model.{Cell, Field}
import de.htwg.se.madn.util.Observable

class Controller(var field: Field[Cell]) extends Observable{

}
