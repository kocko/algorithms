package codeforces.contests600_699.problemset630

import scala.io.StdIn

object SelectionOfPersonnel {

  def main(args: Array[String]) {
    def f(s : BigInt, n : BigInt) : BigInt = {
      if (s == n) n
      else s * f(s + 1, n)
    }
    val n = StdIn.readInt()
    val a = f(n - 4, n) / f(1, 5)
    val b = f(n - 5, n) / f(1, 6)
    val c = f(n - 6, n) / f(1, 7)
    print(a + b + c)
  }

}
