package codeforces.contests601_700.problemset630

import scala.io.StdIn

object Forecast {

  def main(args: Array[String]) {
    val Array(a, b, c) = StdIn.readLine().split("\\s").map(_.toInt)
    val d = Math.sqrt(b * b - 4 * a * c)
    val x1 = -(b + d) / (2 * a)
    val x2 = -(b - d) / (2 * a)
    println(Math.max(x1, x2))
    println(Math.min(x1, x2))
  }

}
