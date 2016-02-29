package codeforces.contests600_699.problemset630

import scala.io.StdIn

object CrackingTheCode {

  def main(args: Array[String]) {
    val MOD = 100000
    val n = StdIn.readLong()
    val res = Array(n / 10000, (n / 100) % 10, n % 10, (n / 10) % 10, (n / 1000) % 10)
    val k = res(0) * 10000 + res(1) * 1000 + res(2) * 100 + res(3) * 10 + res(4)
    def pow(n : Int) : Long = {
      if (n == 0) 1
      else (k * pow(n - 1)) % MOD
    }
    println("%05d".format(pow(5)))
  }

}
