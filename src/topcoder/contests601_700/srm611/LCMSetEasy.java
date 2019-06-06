package topcoder.contests601_700.srm611;

public class LCMSetEasy {

  public String include(int[] s, int x) {
    int lcm = 1;
    for (int a : s) if (x % a == 0) {
      lcm = lcm(lcm, a);
    }
    return lcm == x ? "Possible" : "Impossible";
  }
  
  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  private int lcm(int a, int b) {
    int gcd = gcd(a, b);
    return b * (a / gcd);
  }

}
