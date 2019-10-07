package basics

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {
  //ex. 1 write a function size that will count number of nodes in a tree

  //ex. 2 write maximum that returns the maximum element in Tree[Int]

  //ex. 3 write a function depth that returns the maximum path length from the root of a tree to any leaf

  //ex. 4 write map, analogous to the method on the same element on List

  //ex. 5 generalize size, maximum, depth and map with a new function called fold that will abstract over their similarities
}