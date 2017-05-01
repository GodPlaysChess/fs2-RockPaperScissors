import cats.{Id, ~>}
import org.scalatest.{FlatSpec, Matchers}

class ProgrammTest extends FlatSpec with Matchers with TestInterpreter {

  "Programm" should "work for one round" in {
    Programm.startGame.foldMap(testInterpreter) shouldBe Score(1, 0)
  }

}

trait TestInterpreter extends TestStrategy{
  val testInterpreter = new (Action ~> Id) {
    override def apply[A](fa: Action[A]) = fa match {
      case PlayRound(s1, s2) => Rules.winner(s1, s2)
      case AskForShape => Paper
      case EndGame(_) => ()
      case NextRound => false
      case AskAIForShape => testStrategy
    }
  }
}

trait TestStrategy {
  val testStrategy = Rock
}
