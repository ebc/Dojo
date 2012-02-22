import org.specs2.specification.Scope
import org.specs2.mutable

class LogTest extends mutable.Specification {
  // Implement me on the 
  def accessMap(source: scala.io.Source): Map[String, Set[String]] = Map.empty

  "The access.log file" should {
    "contain two IP addresses" in new Log {
      new LogMap(source).urlsPerIP.keys must have size(2)
    }

    "contain 10.61.6.92" in new Log {
      new LogMap(source).urlsPerIP.keys must contain("10.61.6.92")
    }.pendingUntilFixed

    "contain 10.61.9.60" in new Log {
      new LogMap(source).urlsPerIP.keys must contain("10.61.9.60")
    }.pendingUntilFixed

    "have 34 URLs for 10.61.6.92" in new Log {
      new LogMap(source).urlsPerIP("10.61.6.92") must have size(34)
    }.pendingUntilFixed

    "have 34 URLs for 10.61.9.60" in new Log {
      new LogMap(source).urlsPerIP("10.61.9.60") must have size(34)
    }.pendingUntilFixed

    "contain /scaladoc/library/ for 10.61.6.92" in new Log {
      new LogMap(source).urlsPerIP("10.61.9.60") must contain("/scaladoc/library/")
    }.pendingUntilFixed
  }
}

trait Log extends Scope {
  def resource = getClass().getClassLoader().getResourceAsStream("access.log")
  def source = scala.io.Source fromInputStream resource
}

