object Parser {
  def getShape(input: String): Shape = input match {
    case x if x.toLowerCase.startsWith("r") ⇒ Rock
    case x if x.toLowerCase.startsWith("s") ⇒ Scissors
    case x if x.toLowerCase.startsWith("p") ⇒ Paper
    case _ ⇒ Rock // actually return Option or validation , and reiterate until get the right one
  }

  def yesNo(input: String): Boolean = input match {
    case x if x.toLowerCase.startsWith("y") ⇒ true
    case _ ⇒ false
  }

}
