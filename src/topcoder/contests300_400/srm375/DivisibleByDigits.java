package topcoder.contests300_400.srm375;

public class DivisibleByDigits {

  public long getContinuation(int n) {
    long lcm = 1;
    long result = n;
    while (n > 0) {
      if (n % 10 != 0) {
        lcm = lcm(lcm, n % 10);
      }
      n /= 10;
    }
    long multiplier = 1;
    while (result % lcm != 0) {
      long rem = result % lcm;
      long addition = lcm - rem;
      if (addition >= multiplier) {
        multiplier *= 10;
        result *= 10;
      } else {
        result += addition;
        break;
      }
    }
    return result;
  }
  
  private long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }
  
  private long lcm(long a, long b) {
    long gcd = gcd(a, b);
    a /= gcd;
    return a * b;
  }

  public static void main(String[] args) {
    System.out.println(new DivisibleByDigits().getContinuation(464597517));
  }
}
