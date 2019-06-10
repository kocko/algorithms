package topcoder.contests601_700.srm648;

public class AB {

  public String createString(int n, int k) {
    int half = n / 2;
    if (half * (n - half) < k) {
      return "";
    }
    char[] x = new char[n];
    for (int i = 0; i < half; i++) x[i] = 'A';
    for (int i = half; i < n; i++) x[i] = 'B';
    int count = half * (n - half);
    while (count > k) {
      for (int i = n - 2; i >= 0; i--) {
        if (x[i] == 'A' && x[i + 1] == 'B') {
          x[i] = 'B';
          x[i + 1] = 'A';
          count--;
          break;
        }
      }
    }
    return new String(x);
  }

}
