package codeforces.contests601_700.problemset630

import scala.io.StdIn

object ARectangle {

  def main(args: Array[String]) {
    val in = StdIn.readLine().split("\\s+").map(_.toInt)

    val a = Math.abs(in(2) - in(0)) / 2 + 1
    val b = Math.abs(in(3) - in(1)) / 2 + 1
    println(a.toLong * b + (a - 1).toLong * (b - 1))
  }

}
