object Calc extends scala.util.parsing.combinator.RegexParsers {
	def zero: Parser[Int] = "0" ^^ (_.toInt)
	def one: Parser[Int] = "1" ^^ (x => x.toInt)
	def bin: Parser[Any] = zero | one
	def number: Parser[Int] = "\\d(\\+|\\-)\\d".r ^^ {
		case expr => expr.charAt(0).asDigit + 
							 expr.charAt(2).asDigit		
	}

	def digit: Parser[Int] = "\\d".r ^^ (_.toInt)
	def operator: Parser[String] = "(\\+|-|\\*|/)".r 

	def operation: Parser[Int] = digit ~ ( operator ~ digit ).+ ^^ {
		case a ~ List("+" ~ c,xs@_*) => a + c + soma(xs) 
		case a ~ List("-" ~ c) => a - c
		case a ~ List("*" ~ c) => a * c 
		case a ~ List("/" ~ c) => a / c
	}

	def soma(lista: Seq[~[String, Int]]): Int = {
		lista match {
			case Seq(operator ~ digit) => digit 
		}
	} 





	def zeros = zero.*
	def zerozeros = zero.+

	def ten: Parser[Int] = one ~ zero ~ one ~ zero ^^ {
		case a ~ b ~ c ~ d => a * 8 + b * 4 + c * 2 + d 
	}

}