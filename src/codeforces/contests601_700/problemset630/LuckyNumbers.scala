package codeforces.contests601_700.problemset630

import scala.io.StdIn

object LuckyNumbers {

  def main (args: Array[String]) {
    def pow(n : Long, p : Long) : Long = {
      if (p == 1) n
      else n * pow(n, p - 1)
    }

    val n = StdIn.readInt()
    print(pow(2, n + 1) - 2)
  }

}
