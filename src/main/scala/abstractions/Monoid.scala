package abstractions

trait Monoid[A] {
  def zero: A
  def op(a1: A, a2: A): A
}

object Monoid {
  def apply[A: Monoid](implicit monoid: Monoid[A]): Monoid[A] = monoid

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    val zero = ""
    def op(s1: String, s2: String): String = s1 + s2
  }

  implicit val additionMonoid: Monoid[Int] = ???

  implicit def listMonoid[A]: Monoid[List[A]] = ???

  implicit class MonoidOps[A: Monoid](a1: A) {
    def op(a2: A): A = Monoid[A].op(a1, a2)
  }
}

object Main {
  import Monoid.MonoidOps

  def main(args: Array[String]): Unit = {
    println("Welcome to ".op("workshops."))
  }
}