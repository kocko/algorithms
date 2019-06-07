package topcoder.contests601_700.srm616;

public class WakingUp {

  public int maxSleepiness(int[] period, int[] start, int[] volume, int D) {
    int max = 1;
    for (int p : period) {
      max = lcm(max, p);
    }
    int sleep = 0;
    int n = 0;
    for (int i = 1; i <= max; i++) {
      sleep += D;
      for (int j = 0; j < period.length; j++) {
        if (i % period[j] == start[j] % period[j]) {
          sleep -= volume[j];
        }
      }
      n = Math.min(n, sleep);
    }
    return (sleep < 0) ? -1 : -n;
  }
  
  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
  
  private int lcm(int a, int b) {
    int gcd = gcd(a, b);
    return a * (b / gcd);
  }

}
