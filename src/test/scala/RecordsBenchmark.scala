import rec.Lists

object RecordsBenchmark extends ListsBenchmarkSuite {
  measure method "construction" in {
    using(fieldIndexes) in { x =>
      Lists(Seq.fill(x)(Lists(x.toString)): _*)
    }
  }
}
