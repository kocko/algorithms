package codeforces.contests600_699.problemset630

import scala.io.StdIn

object SelectionOfPersonnel {

  def main(args: Array[String]) {
    def f(n : Long) : Long = {
      if (n <= 1) 1
      else n * f(n - 1)
    }
    val n = StdIn.readInt()
    val a = f(n) / f(n - 5)
    val b = f(n) / f(n - 6)
    val c = f(n) / f(n - 7)
    print(a + b + c)
  }

}
