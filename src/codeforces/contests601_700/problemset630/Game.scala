package codeforces.contests601_700.problemset630

import scala.io.StdIn

object Game {

  def main(args: Array[String]) {
    val n = StdIn.readLong()
    print(2 - (n % 2))
  }

}
