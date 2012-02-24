package com.ebc.dojo.scala.magneticpoints

import com.ebc.dojo.scala.magneticpoints.MagneticPoint
import org.specs2.mutable._

class MagneticPointSpec extends Specification {

  "The Magnetic points" should {
    "given coordinates 50,50 and the radius is 5 and the mouse pointer is on 49,50 the result should be 50,50" in {
      new MagneticPoint drawedPoint(Array((50, 50)), 5, (49, 50)) must beEqualTo((50, 50))

    }

    "given coordinates 50,50 and the radius is 5 and the mouse pointer is on 0,0 the result should be 0,0" in {
      new MagneticPoint drawedPoint(Array((50, 50)), 5, (0, 0)) must beEqualTo((0, 0))
    }

    """given coordinates 50,50 and 100,50 and the radius is 5
       and the mouse pointer is on 101,48 the result should be 100,50""" in {
      new MagneticPoint drawedPoint(Array((50, 50), (100, 50)), 5, (101, 48)) must beEqualTo((100, 50))
    }


    """given coordinates 50,50 and 100,50 and the radius is 5
       and the mouse pointer is on 101,48 the result should be 51,51""" in {
      new MagneticPoint drawedPoint(Array((50, 50), (51, 51)), 5, (51, 52)) must beEqualTo((51, 51))
    }
  }
}
