package anyref

class Lists private(val x: AnyRef)

object Lists {
  implicit def string2Lists(s: String): Lists = Lists(s)

  def apply(xs: Lists*): Lists = new Lists(xs)

  def apply(s: String): Lists = new Lists(s: AnyRef)
}

object AnyRefApp extends App {
  def printlnLists(lists: Lists): Unit = {
    println(lists)
  }

  println {
    Lists("s1")
  }
  printlnLists {
    Lists("s1", "s2")
  }
  printlnLists {
    Lists("s1", Lists("s2", "s3"))
  }
}
