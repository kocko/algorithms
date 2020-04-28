package topcoder.tco.tco2020.round1;

public class EllysWhatDidYouGet {

  public int getCount(int n) {
    int result = 0;
    for (int x = 1; x <= 50; x++) {
      for (int y = 1; y <= 50; y++) {
        for (int z = 1; z <= 50; z++) {
          int s = sum((x + y) * z);
          boolean ok = true;
          for (int i = 2; i <= n; i++) {
            ok &= sum((i * x + y) * z) == s;
          }
          if (ok) result++;
        }
      }
    }
    return result;
  }

  private int sum(int x) {
    int result = 0;
    while (x > 0) {
      result += (x % 10);
      x /= 10;
    }
    return result;
  }

}
