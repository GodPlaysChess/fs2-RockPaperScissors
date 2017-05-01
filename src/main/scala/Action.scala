import cats.free.Free

sealed trait Action[A]
case class PlayRound(s1: Shape, s2: Shape) extends Action[Shape]
case object AskForShape extends Action[Shape]
case class EndGame(score: Score) extends Action[Unit]
case object NextRound extends Action[Boolean]
case object AskAIForShape extends Action[Shape]

import cats.free.Free.liftF

object Actions {
  type ActionFr[A] = Free[Action, A]

  def playRound(s1: Shape, s2: Shape): ActionFr[Shape] =
    liftF[Action, Shape](PlayRound(s1, s2))

  def askForShape: ActionFr[Shape] =
    liftF[Action, Shape](AskForShape)

  def askAiForShape: ActionFr[Shape] =
    liftF[Action, Shape](AskAIForShape)

  def endGame(score: Score): ActionFr[Unit] =
    liftF[Action, Unit](EndGame(score))

  def askForNextRound: ActionFr[Boolean] =
    liftF[Action, Boolean](NextRound)
}

case class Score(you: Int, ai: Int)

