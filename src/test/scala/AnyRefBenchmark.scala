import anyref.Lists

object AnyRefBenchmark extends ListsBenchmarkSuite {
  measure method "construction" in {
    using(fieldIndexes) in { x =>
      Lists(Seq.fill(x)(Lists(x.toString)): _*)
    }
  }
}
