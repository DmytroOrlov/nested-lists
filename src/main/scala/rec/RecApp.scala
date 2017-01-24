package rec

import records.Rec

object Lists {
  implicit def string2Rec(s: String): Rec[_] = Rec("value" -> s)

  def apply(vs: Rec[_]*): Rec[_] = Rec("value" -> vs)

  def apply(v: String): Rec[_] = Rec("value" -> v)
}

object RecApp extends App {
  def printlnLists(recs: Rec[_]): Unit = {
    println(recs)

    def printRec(rs: Rec[_]): Unit = rs match {
      case Rec(value: String) => print(value)
      case Rec(value: Seq[Rec[_]]) =>
        print("Lists(")
        printRec(value.head)
        value.tail.foreach { v =>
          print(", ")
          printRec(v)
        }
        print(")")
    }

    recs match {
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
