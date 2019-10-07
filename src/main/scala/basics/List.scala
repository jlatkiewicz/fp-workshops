package basics

import abstractions.Main

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

  //ex. 4 implement dropWhile, hard: switch drop implementation to use dropWhile
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

  //ex. 11 Hard: write foldRight in terms of foldLeft

  //ex. 12 Implement append in terms of either foldLeft or foldRight.

  //ex. 13 Hard: Write a function that concatenates a list of lists into a single list.
  // Its runtime should be linear in the total length of all lists.
  // Try to use functions we have already defined.

  //ex. 14 Write a function that transforms a list of integers by adding 1 to each element.
  // (Reminder: this should be a pure function that returns a new List!)

  //ex. 15 Write a function that turns each value in a List[Double] into a String.
  // You can use the expression d.toString to convert some d: Double to a String.

  //ex. 16 Write map, switch above two functions to use map
  def map[A,B](as: List[A])(f: A => B): List[B] = ???

  //ex. 17 write filter
  def filter[A](as: List[A])(f: A => Boolean): List[A] = ???

  //ex. 18 write flatMap
  def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] = ???

  //ex. 19 switch filter implementation to use flatMap

  //ex. 20 Write a function that accepts two lists and constructs a new list by adding corresponding elements.
  // For example, List(1,2,3) and List(4,5,6) become List(5,7,9).

  //ex. 21 Generalize the function you just wrote so that it’s not specific to integers or addition. Name your generalized function zipWith.

  //ex. 21 Hard: Implement hasSubsequence for checking whether a List contains another List as a subsequence.
  // For instance, List(1,2,3,4) would have List(1,2), List(2,3), and List(4) as subsequences, among others.
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = ???
}
