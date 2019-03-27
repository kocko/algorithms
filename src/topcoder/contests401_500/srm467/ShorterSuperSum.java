package topcoder.contests401_500.srm467;

public class ShorterSuperSum {

  public int calculate(int k, int n) {
    if (k == 0) return n;
    int result = 0;
    for (int i = 1; i <= n; i++) {
      result += calculate(k - 1, i);
    }
    return result;
  }
  
}
