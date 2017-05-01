import cats.data.Validated
import Validated._

object Parser {
  def getShape(input: String): Validated[ParseError, Shape] = input match {
    case x if x.toLowerCase.startsWith("r") ⇒ valid(Rock)
    case x if x.toLowerCase.startsWith("s") ⇒ valid(Scissors)
    case x if x.toLowerCase.startsWith("p") ⇒ valid(Paper)
    case _ ⇒ invalid(WrongShape)
  }

  def yesNo(input: String): Boolean = input match {
    case x if x.toLowerCase.startsWith("y") ⇒ true
    case _ ⇒ false
  }

}

trait ParseError
case object WrongShape extends ParseError
