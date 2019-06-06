package topcoder.contests601_700.srm611;

public class LCMSet {

  public String equal(int[] A, int[] B) {
    return valid(A, B) && valid(B, A) ? "Equal" : "Not equal";
  }
  
  private boolean valid(int[] A, int[] B) {
    for (int a : A) {
      int lcm = 1;
      for (int b : B) if (a % b == 0) {
        lcm = lcm(lcm, b);
      }
      if (lcm != a) return false;
    }
    return true;
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  private int lcm(int a, int b) {
    int gcd = gcd(a, b);
    return b * (a / gcd);
  }

}
