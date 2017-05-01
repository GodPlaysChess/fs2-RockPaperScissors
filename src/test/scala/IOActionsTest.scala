import org.scalatest.{FlatSpec, Matchers}
import fs2._
import IOActions._
import cats.data.State

import scala.util.Random

/**
  * This also can be rewritten by changing effect type in tests from Task to, say, Id
  * Then `unsafeRun` would be just gone
  * */
class IOActionsTest extends FlatSpec with Matchers {

  "Parse char" should "parse correctly" in {
    Stream.emit('c'.toByte).through(parseChar).runLog.unsafeRun().head shouldBe 'c'
  }

  "Shape" should "be valid eventually as well" in {
    inShape(Task.delay("r")).unsafeRun() shouldBe Rock
  }

  it should "be going until the valid one" in new RandomTasks {
    inShape(randomTask(Vector("invalid", "crap", "Rock"))).unsafeRun() shouldBe Rock
  }

}

trait RandomTasks {

  private def tasks: State[List[String], Task[String]] = for {
    str ← State.get[List[String]]
    _ ← State.set(str.tail)
  } yield Task.delay(str.head)

  def randomTask(sequence: Vector[String]): Task[String] = {
    Task.delay(sequence(Random.nextInt(sequence.length)))
  }


  def tasksFromSequence(sequence: List[String]): (List[String], Task[String]) = {
    tasks.run(sequence).value
  }

}
