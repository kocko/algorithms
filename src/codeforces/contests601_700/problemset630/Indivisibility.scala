package codeforces.contests601_700.problemset630

import scala.io.StdIn

object Indivisibility {

  def main(args: Array[String]) {
    val n = StdIn.readLong()
    print (n - (n / 2) - (n / 3) - (n / 5) - (n / 7)
             + (n / 6) + (n / 10) + (n / 14) + (n / 15) + (n / 21) + (n / 35)
             - (n / 30) - (n / 42) - (n / 105) - (n / 70)
             + (n / 210))
  }

}
