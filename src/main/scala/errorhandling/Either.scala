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


  //example usage

  case class Person(name: Name, age: Age)
  sealed class Name(val value: String)
  sealed class Age(val value: Int)

  def mkName(name: String): Either[String, Name] =
    if (name == "" || name == null) Left("Name is empty.") else Right(new Name(name))
  def mkAge(age: Int): Either[String, Age] = if (age < 0) Left("Age is out of range.") else Right(new Age(age))
  def mkPerson(name: String, age: Int): Either[String, Person] = mkName(name).map2(mkAge(age))(Person)


  //ex. 3 optional, design question
  //using this implementation map2 is only able to report one error, even if both age and name are invalid.
  //What would need to change to be able to report both errors? Would the change be in map2 or in mkPerson?
  //Or maybe an entirely new data structure that captures this requirement better than Either?
  //How would orElse, traverse and sequence behave differently for that data structure?
}