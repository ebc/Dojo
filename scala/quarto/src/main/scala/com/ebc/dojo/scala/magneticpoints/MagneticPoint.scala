package com.ebc.dojo.scala.magneticpoints

class MagneticPoint {
  def drawedPoint(magneticPoints: Seq[(Int, Int)], radius: Int, mousePoint: (Int, Int)): (Int, Int) = {
    var bestCandidate: Option[(Int, Int)] = None

    def getDistance(x: Int, y: Int): Int = {
      val diffx = x - mousePoint._1
      val diffy = y - mousePoint._2
      (diffx * diffx + diffy * diffy)
    }

    magneticPoints foreach {
      case (x, y) =>
        if (getDistance(x, y) <= radius * radius) {
          bestCandidate = bestCandidate map {
            case (bx, by) =>
              if (getDistance(x, y) < getDistance(bx, by)) (x, y)
              else (bx, by)
          } orElse Some((x, y))
        }
    }
    bestCandidate getOrElse mousePoint
  }
}

