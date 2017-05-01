import Parser._
import cats.data.Validated.valid
import cats.data.Validated.invalid
import org.scalatest.{FlatSpec, Matchers}

class ParserTest extends FlatSpec with Matchers {

  "Parser" should "get the right shapes" in {
    getShape("s") shouldBe valid(Scissors)
    getShape("r") shouldBe valid(Rock)
    getShape("p") shouldBe valid(Paper)
  }

  it should "get the shape based on just lowercased first letter" in {
    getShape("sci") shouldBe valid(Scissors)
    getShape("Sci") shouldBe valid(Scissors)
  }

  it should "invalidate everything else" in {
    getShape(" sci") shouldBe invalid(WrongShape)
    getShape("Xxx") shouldBe invalid(WrongShape)
  }

  it should "parse y as true" in {
    yesNo("y") shouldBe true
    yesNo("Yioi") shouldBe true
  }

  it should "parse everything else as no" in {
    yesNo("qweqey") shouldBe false
    yesNo(" ") shouldBe false
  }



}
