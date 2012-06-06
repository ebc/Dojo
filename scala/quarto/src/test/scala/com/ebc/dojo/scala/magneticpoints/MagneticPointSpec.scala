package com.ebc.dojo.scala.magneticpoints

import org.specs2._
import specification._

class MagneticPointSpec extends Specification {

  def is =
    "The Magnetic points" ^
      p ^
      "Given coordinates 50,50" ^ givenCoord ^
      "and the radius is 5" ^ andRadius ^
      "when the mouse pointer is on 49,50" ^ whenMouse ^
      "the result should be 50,50" ^ thenResult ^
      end ^
      "Given coordinates 50,50" ^ givenCoord ^
      "and the radius is 5" ^ andRadius ^
      "when the mouse pointer is on 0,0" ^ whenMouse ^
      "the result should be 0,0" ^ thenResult ^
      end ^
      "Given coordinates 50,50" ^ givenCoord ^
      "and coordinates 100,50" ^ givenCoord ^
      "and the radius is 5" ^ twoCoordsAndRadius ^
      "when the mouse pointer is on 101,48" ^ whenMouse ^
      "the result should be 100,50" ^ thenResult ^
      end ^
      "Given coordinates 50,50" ^ givenCoord ^
      "and coordinates 100,50" ^ givenCoord ^
      "and the radius is 5" ^ twoCoordsAndRadius ^
      "when the mouse pointer is on 101,48" ^ whenMouse ^
      "the result should be 100,50" ^ thenResult ^
      end

  type Coord = (Int, Int)
  type Coords = List[Coord]
  type Radius = Int
  type Plane = (Coords, Radius)
  type Setup = (Plane, Coord)

  val coordPattern: String = ".*coordinates (\\d+),\\s*(\\d+)"

  object givenCoord extends Given[Coord](coordPattern) {
    def extract(text: String) = {
      val (x, y) = extract2(text)
      (x.toInt, y.toInt)
    }
  }

  val radiusPattern: String = ".*radius is (\\d+)"

  object andRadius extends When[Coord, Plane](radiusPattern) {
    def extract(coord: Coord, text: String) = {
      List(coord) -> extract1(text).toInt
    }
  }

  object twoCoordsAndRadius extends When[(Coord, Coord), Plane](radiusPattern) {
    def extract(coords: (Coord, Coord), text: String) = {
      List(coords._1, coords._2) -> extract1(text).toInt
    }
  }

  val mousePattern: String = ".*mouse pointer is on (\\d+),\\s*(\\d+)"

  object whenMouse extends When[Plane, Setup](mousePattern) {
    def extract(plane: Plane, text: String) = {
      val (x, y) = extract2(text)
      plane ->(x.toInt, y.toInt)
    }
  }

  val resultPattern: String = ".*result should be (\\d+),\\s*(\\d+)"

  object thenResult extends Then[Setup](resultPattern) {
    def extract(setup: Setup, text: String) = {
      val (x, y) = extract2(text)
      val ((magneticPoints, radius), mousePoint) = setup
      new MagneticPoint drawedPoint(magneticPoints, radius, mousePoint) must beEqualTo((x.toInt, y.toInt))
    }
  }

}
