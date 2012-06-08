package com.ebc.dojo.scala.magneticpoints

import org.specs2._
import specification._

class MagneticPointImmutableSpec extends Specification {
  def is =
    "Magnetic Points Immutable Specification".title ^
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
      "and coordinates 100,50" ^ andCoord ^
      "and the radius is 5" ^ andRadius ^
      "when the mouse pointer is on 101,48" ^ whenMouse ^
      "the result should be 100,50" ^ thenResult ^
      end ^
      "Given coordinates 50,50" ^ givenCoord ^
      "and coordinates 51,51" ^ andCoord ^
      "and the radius is 5" ^ andRadius ^
      "when the mouse pointer is on 51,52" ^ whenMouse ^
      "the result should be 51,51" ^ thenResult ^
      end

  type Coord = (Int, Int)
  type Coords = List[Coord]
  type Radius = Int
  type Plane = (Coords, Radius)
  type Setup = (Plane, Coord)

  def toTuple(s: Seq[String]) = (s(0).toInt, s(1).toInt)
  val withNumbers = groupAs("\\d+")
  val givenCoord = withNumbers and { s: Seq[String] => List(toTuple(s)) }
  val andCoord = withNumbers and { (coords: Coords) => (s: Seq[String]) => (toTuple(s)) :: coords }
  val andRadius = withNumbers and { (coords: Coords) => (s: String) => coords -> s.toInt }
  val whenMouse = withNumbers and { (plane: Plane) => (s: Seq[String]) => plane -> toTuple(s) }
  val thenResult = withNumbers then { (setup: Setup) => (s: Seq[String]) =>
      val ((magneticPoints, radius), mousePoint) = setup
      new MagneticPoint drawedPoint (magneticPoints, radius, mousePoint) must beEqualTo(toTuple(s))
  }
}
