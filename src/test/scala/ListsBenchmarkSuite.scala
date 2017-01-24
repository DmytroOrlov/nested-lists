import org.scalameter.api.{Bench, Gen}

/**
  * Created by dorlov on 24/01/17.
  */
trait ListsBenchmarkSuite extends Bench.ForkedTime {
  val maxSize = 30
  val fieldIndexes: Gen[Int] = Gen.range("Field Count")(1, maxSize, 1)
}
