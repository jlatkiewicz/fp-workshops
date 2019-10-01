package basics

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  //ex. 0 observe the pattern matching and recursive calls
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  //ex. 1 implement tail for removing the first element of a list

  //ex. 2 implement setHead for replacing the first element of a list with a value

  //ex. 3 implement drop and switch tail implementation to use drop
  def drop[A](l: List[A], n: Int): List[A] = ???

  //ex. 4 implement dropWhile, switch drop implementation to use dropWhile
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = ???

  //ex. 5 what is the difference between above dropWhile and below?
  def dropWhile2[A](as: List[A])(f: A => Boolean): List[A] = ???

  //ex. 6 look at the sum and product functions, then implement foldRight.
  // After that implement sum and product in terms of foldRight
  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => ???
    case Cons(x, xs) => ???
  }

  //ex. 7 compute length of a list using foldRight
  def length[A](as: List[A]): Int = ???

  //thought experiment - see what happens when you do this foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))
  //what do you think about relationship between foldRight and List data constructor?

  //ex. 8 foldRight is NOT tail-recursive and can result in stack-overflow
  //implement foldLeft in tail-recursive way
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = ???

  //ex. 9 write sum, product and length using foldLeft

  //ex. 10 write a function that reverses a list using either of the two folds

  //ex. 11 write foldRight in terms of foldLeft

  //ex. 12 Implement append in terms of either foldLeft or foldRight.

  //ex. 13 Hard: Write a function that concatenates a list of lists into a single list.
  // Its runtime should be linear in the total length of all lists.
  // Try to use functions we have already defined.

}
