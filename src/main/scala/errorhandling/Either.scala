package errorhandling


//the biggest problem with option is that it does not tell us anything about the possible error that it encountered
//welcome Either that will try to solve the problem
sealed trait Either[+E, +A] {
  //for ex. 1
  def map[B](f: A => B): Either[E, B] = ???
  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B]  = ???
  def orElse[EE >: E,B >: A](b: => Either[EE, B]): Either[EE, B] = ???
  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = ???
}
case class Left[+E](value: E) extends Either[E, Nothing]
case class Right[+A](value: A) extends Either[Nothing, A]

//ex. 1 implement map, flatMap, orElse and map2 that operate on Right value

object Either {
  def mean(xs: IndexedSeq[Double]): Either[String, Double] =
    if (xs.isEmpty)
    Left("mean of empty list!")
  else
    Right(xs.sum / xs.length)

  def safeDiv(x: Int, y: Int): Either[Exception, Int] =
    try Right(x / y)
    catch { case e: Exception => Left(e) }

  def Try[A](a: => A): Either[Exception, A] =
    try Right(a)
    catch { case e: Exception => Left(e) }

  //ex. 2 implement sequence and traverse for Either, sequence implementation should use traverse
  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = ???
  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] = ???
}