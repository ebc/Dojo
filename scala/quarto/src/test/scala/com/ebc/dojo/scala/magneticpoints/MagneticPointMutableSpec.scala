package com.ebc.dojo.scala.magneticpoints

import org.specs2.mutable._
//import specification._
import org.specs2.specification.Fragments

class MagneticPointSpec extends Specification {
    class context extends Fragments {
        var magneticPoints: List[(Int, Int)] = Nil
        var mousePoint: (Int, Int) = (0,0)
        var radius = 0

        def toTuple(s: Seq[String]) = (s(0).toInt, s(1).toInt)
        def withNumbers = groupAs("\\d+")
        def givenMagneticPoints = withNumbers { s: Seq[String] => magneticPoints ::= toTuple(s) }
        def givenRadius = withNumbers { s: String => radius = s.toInt }
        def whenMouse = withNumbers { s: Seq[String] => mousePoint = toTuple(s) }
        def checkResult = withNumbers { s: Seq[String] =>
            val expected = toTuple(s)
            val point = new MagneticPoint
            point drawedPoint (magneticPoints, radius, mousePoint) must beEqualTo(expected)
        }

    }

    "Magnetic points attract close clicks"   >> new context {
        "Given coordinates 50,50"            << givenMagneticPoints
        "and the radius is 5"                << givenRadius
        "when the mouse pointer is on 49,50" << whenMouse
        "the result should be 50,50"         << checkResult
    }

    "Magnetic points do not attract distant clicks" >> new context {
      "Given coordinates 50,50"                     << givenMagneticPoints
      "and the radius is 5"                         << givenRadius
      "when the mouse pointer is on 0,0"            << whenMouse
      "the result should be 0,0"                    << checkResult
    }

    "Clicks are only attracted to magnetic points in radius" >> new context {
      "Given coordinates 50,50"                              << givenMagneticPoints
      "and coordinates 100,50"                               << givenMagneticPoints
      "and the radius is 5"                                  << givenRadius
      "when the mouse pointer is on 101,48"                  << whenMouse
      "the result should be 100,50"                          << checkResult
    }
    "Clicks are attracted to the closest magnetic point" >> new context {
      "Given coordinates 50,50"                          << givenMagneticPoints
      "and coordinates 51,51"                            << givenMagneticPoints
      "and the radius is 5"                              << givenRadius
      "when the mouse pointer is on 51,52"               << whenMouse
      "the result should be 51,51"                       << checkResult
    }
}
