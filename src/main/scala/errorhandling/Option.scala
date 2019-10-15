package errorhandling


//to keep referential transparency let's not use exceptions and try to handle error in a different, functional way
//introducing - Option. It will return Some(result) for operation that succeeds and None for operation that fails
sealed trait Option[+A] {
  //for ex. 1, use pattern matching
  def map[B](f: A => B): Option[B] = ???
  def getOrElse[B >: A](default: => B): B = ???
  //for ex. 1, do not use pattern matching
  def flatMap[B](f: A => Option[B]): Option[B] = ???
  def orElse[B >: A](ob: => Option[B]): Option[B] = ???
  def filter(f: A => Boolean): Option[A] = ???
}

case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]


// ex. 1 implement the above functions
// do not use pattern matching in any except map and getOrElse
// getOrElse returns the result inside the Some case of the Option, or if the Option is None, returns the given default value.
// orElse returns the first Option if it’s defined; otherwise, it returns the second Option.

object Option {

  def Try[A](a: => A): Option[A] =
  try Some(a)
  catch { case _: Exception => None }


  // ex. 2 Implement the variance function in terms of flatMap.
  // If the mean of a sequence is m, the variance is the mean of math.pow(x - m, 2) for each element x in the sequence.
  def variance(xs: Seq[Double]): Option[Double] = ???

  //our code base does not have to be be littered with Option in signatures, we can have lift function that
  // `lifts` a common function into one that operates on option values
  def lift[A,B](f: A => B): Option[A] => Option[B] = _ map f
  //for example
  val absO: Option[Double] => Option[Double] = lift(math.abs)

  //ex. 3
  //What if we want to combine results of two methods that can return an option?
  //For example getUserWithId(id): Option[User] and getCartByUserId(id): Option[Cart]
  //That are used for buildReport(User, Cart): Report?
  //Write a generic map2 function that combines two Option values using binary function
  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = ???

  //with that we could write
  // val optUser: Option[User] = getUserWithId(id)
  // val optCart: Option[Cart] = getCartByUserId(id)
  // val optReport = map2(optUser, optCart)(buildReport)

  //ex. 4 implement sequence, if every Option in List is Some: return Some(List), else return None
  def sequence[A](a: List[Option[A]]): Option[List[A]] = ???

  //with sequence we can do this
  def parseInts(a: List[String]): Option[List[Int]] = sequence(a map (i => Try(i.toInt)))

  //it will return Some only if every string in a list can be converted into an int
  //unfortunately it is inneficient since it traverses te list twice, first to convert String into Option[Int]
  //and then to combine results into Option[List[Int]]

  //ex. 5 implement traverse that will alleviate the problem above, do not use map and sequence
  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = ???

  //ex. 6 implement sequence in terms of traverse
}

