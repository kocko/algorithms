package topcoder.contests701_800.srm756;

public class NewBanknote {

  public int[] fewestPieces(int newBanknote, int[] amountsToPay) {
    int n = amountsToPay.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      long s = amountsToPay[i];
      long x = calculate(s);
      long best = x;
      for (int j = 1; j < x; j++) {
        if (s - (long) newBanknote * j >= 0) {
          best = Math.min(best, j + calculate(s - newBanknote * j));
        }
      }
      result[i] = (int) best;
    }
    return result;
  }

  private long calculate(long s) {
    long[] c = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000};
    long result = 0;
    for (int i = c.length - 1; i >= 0; i--) {
      result += s / c[i];
      s %= c[i];
    }
    return result;
  }
  
}
