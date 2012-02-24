import org.specs2._
import specification._
import Calc._

class CalcTest extends Specification 
  with matcher.ParserMatchers {
	
	def is =
	"Uma calculadora"                 ^
	"Deve calcular 0 == 0" ! e1     ^
	"Deve calcular 0 != 1" ! e2     ^
	"Deve calcular 1010 == 1010" ! e3 ^
	"Deve calcular 1+1 == 2" ! soma ^
	"Deve calcular 2-1 == 1" ! menos ^
	"Deve calcular 2*2 == 4" ! mult ^
	"Deve calcular 2/2 == 1" ! div ^
	"Deve calcular ${2+2+1} == ${5}" ! comp ^
 	end

    def comp = new GivenThen {  
    	  def extract(text: String) = { 
    	  	  val (expr, res) = extract2(text)
    	  	  operation must succeedOn(expr).withResult(res.toInt)  
    	}
    }

	def e1 = zero must succeedOn("0")
	def e2 = zero must failOn("1")
	def e3 = ten must succeedOn("1010").withResult(10)

	def soma = number must succeedOn("1+1").withResult(2)
	def menos = operation must succeedOn("2-1").withResult(1)
	def mult = operation must succeedOn("2*2").withResult(4)
	def div = operation must succeedOn("2/2").withResult(1)

	val parsers = Calc
}