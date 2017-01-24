package rec

import records.Rec

object Lists {
  implicit def string2Rec(s: String): Rec[ {def value: String}] = apply(s)

  def apply(vs: Rec[{def value: Any}]*): Rec[{def value: Seq[Rec[{def value: Any}]]}] = Rec("value" -> vs)

  def apply(s: String): Rec[ {def value: String}] = Rec("value" -> s)
}

object RecApp extends App {
  def printlnLists(lists: Rec[{def value: Any}]): Unit = {
    println(lists)

    def printRec(rs: Rec[{def value: Any}]): Unit = rs match {
      case Rec(value: String) => print(value)
      case Rec(value: Seq[Rec[{def value: Any}]]) =>
        print("Lists(")
        printRec(value.head)
        value.tail.foreach { v =>
          print(", ")
          printRec(v)
        }
        print(")")
    }

    lists match {
      case r@Rec(value: String) =>
        print("Lists(")
        printRec(r)
        println(")")
      case r =>
        printRec(r)
        println
    }
  }

  import Lists._

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
