import org.scalatest.{FlatSpec, Matchers}
import Rules.winner

class RulesTest extends FlatSpec with Matchers {
  behavior of "Rules"

  "Paper" should "beat Rock and lose to Scissors" in {
    winner(Paper, Rock) shouldBe Paper
    winner(Paper, Scissors) shouldBe Scissors
    winner(Paper, Paper) shouldBe Paper
  }

  "Rock" should "beat Scissors and lose to Paper" in {
    winner(Rock, Rock) shouldBe Rock
    winner(Rock, Scissors) shouldBe Rock
    winner(Rock, Paper) shouldBe Paper
  }

  "Scissors" should "beat Paper and lose to Rock" in {
    winner(Scissors, Rock) shouldBe Rock
    winner(Scissors, Scissors) shouldBe Scissors
    winner(Scissors, Paper) shouldBe Scissors
  }

}
