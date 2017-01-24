package either

case class Lists(value: Either[Seq[Lists], String])

object Lists {
  implicit def string2Lists(s: String): Lists = Lists(Right(s))

  def apply(values: Lists*): Lists = Lists(Left(values))

  def apply(s: String): Lists = Lists(Right(s))
}

object EitherApp extends App {
  def printlnLists(lists: Lists): Unit = {
    println(lists)

    def printEither(vs: Lists): Unit = vs match {
      case Lists(Right(s)) => print(s)
      case Lists(Left(values)) =>
        print("Lists(")
        printEither(values.head)
        values.tail.foreach { v =>
          print(", ")
          printEither(v)
        }
        print(")")
    }

    lists match {
      case Lists(Right(s)) =>
        print("Lists(")
        printEither(s)
        println(")")
      case vs =>
        printEither(vs)
        println
    }
  }

  printlnLists {
    Lists("s1")
  }
  printlnLists {
    Lists("s1", "s2")
  }
  printlnLists {
    Lists("s1", Lists("s2", "s3"))
  }
}
