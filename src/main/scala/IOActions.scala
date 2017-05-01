import fs2.{Pipe, Task}

object IOActions {
  def input: Task[String] = fs2.io.stdin[Task](24).through(parseChar).take(1).runLog.map(_.mkString(""))

  def parseString[F[_]]: Pipe[F, Vector[Byte], String] = _.map(in ⇒ new String(in.toArray.map(_.toChar)))
  def parseChar: Pipe[Task, Byte, Char] = _.map(_.toChar)

  def inShape(in: Task[String]): Task[Shape] =
    in.map(Parser.getShape)
      .flatMap(
        _.fold(
          _ ⇒ {println("Incorrect shape. Please, select (R)ock, (P)aper or (S)cissors"); inShape(in)},
          s ⇒ Task.delay(s)))
      .map(shape ⇒ { println(shape); shape })

  def inYesNo: Task[Boolean] =
    input.map(Parser.yesNo)
}
