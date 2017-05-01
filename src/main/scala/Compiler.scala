import cats.~>
import fs2.Task


object Compiler {
  import IOActions._

  def ioCompiler(strategy: () => Shape): Action ~> Task = new (Action ~> Task) {
    override def apply[A](fa: Action[A]): Task[A] = fa match {
      case PlayRound(s1, s2) => Task.delay { Rules.winner(s1, s2) }
      case AskForShape => Task.delay { println("Your shape") } flatMap { _ ⇒ inShape }
      case AskAIForShape => Task.delay { val shape = strategy.apply(); println(s" against $shape"); shape }
      case EndGame(Score(player, ai)) => Task.delay { println(s"Total score is $player : $ai . Bye bye") }
      case NextRound => Task.delay { println("Do you  want to continue") } flatMap { _ ⇒ inYesNo }
    }
  }
}
