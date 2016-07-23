package codeforces.contests601_700.problemset630

import scala.io.StdIn

object Divisibility {

  def main(args: Array[String]) {
    val n = StdIn.readLong()
    val x = 2 * 3 * 2 * 5 * 7 * 2 * 3
    print(n / x)
  }

}
