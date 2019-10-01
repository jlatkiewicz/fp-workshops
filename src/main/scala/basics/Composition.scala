package basics

object Composition {
  //ex. 1 implement curry
  def curry[A, B, C](f: (A, B) => C): A => B => C = ???

  //ex. 2 implement uncurry
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = ???

  //ex. 3 implement compose, so that (f compose g)(x) == f(g(x)) holds
  def compose[A, B, C](f: B => C, g: A => B): A => C = ???

  //ex. 4 implement andThen, so that (f andThen g)(x) == g(f(x)) holds
  def andThen[A, B, C](f: A => B, g: B => C): A => C = ???
}
