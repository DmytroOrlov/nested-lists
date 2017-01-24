import either.Lists

object EitherBenchmark extends ListsBenchmarkSuite {
  measure method "construction" in {
    using(fieldIndexes) in { x =>
      Lists(Seq.fill(x)(Lists(x.toString)): _*)
    }
  }
}
