package codeforces.contests601_700.problemset630

import scala.io.StdIn

object MooresLaw {

  def main(args: Array[String]) {
    val Array(n, t) = StdIn.readLine().split("\\s+").map(_.toInt)
    print(n * Math.pow(1.000000011, t))
  }

}
