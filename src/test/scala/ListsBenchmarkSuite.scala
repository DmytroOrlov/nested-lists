import org.scalameter.api.{Bench, Gen}

trait ListsBenchmarkSuite extends Bench.ForkedTime {
  val maxSize = 30
  val fieldIndexes: Gen[Int] = Gen.range("Field Count")(1, maxSize, 1)
}
