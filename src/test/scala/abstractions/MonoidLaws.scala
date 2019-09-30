package abstractions

import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Properties}

abstract class MonoidLaws[A: Monoid : Arbitrary]
  extends Properties("Monoid") {

  property("left identity") = forAll { a: A =>
    Monoid[A].op(a, Monoid[A].zero) == a
  }

  property("right identity") = forAll { a: A =>
    Monoid[A].op(Monoid[A].zero, a) == a
  }

  property("associativity") = forAll { (a: A, b: A, c: A) =>
    Monoid[A].op(a, Monoid[A].op(b, c)) == Monoid[A].op(Monoid[A].op(a, b), c)
  }
}

object StringMonoidLaws extends MonoidLaws[String]
object AdditionMonoidLaws extends MonoidLaws[Int]
object ListMonoidLaws extends MonoidLaws[List[Int]]