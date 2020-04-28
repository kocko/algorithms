package topcoder.tco.tco2020.round1;

import java.util.Arrays;
import java.util.TreeSet;

public class EllysDifferentPrimes {

  public int getClosest(int n) {
    init();
    int result;
    if (different.floor(n) == null) {
      result = different.ceiling(n);
    } else if (different.ceiling(n) == null) {
      result = different.floor(n);
    } else if (n - different.floor(n) <= different.ceiling(n) - n) {
      result = different.floor(n);
    } else {
      result = different.ceiling(n);
    }
    return result;
  }

  private final int MAX_N = 50123467;
  private boolean[] sieve = new boolean[MAX_N + 1];
  private TreeSet<Integer> different = new TreeSet<>();

  private void init() {
    Arrays.fill(sieve, true);
    sieve[0] = sieve[1] = false;
    for (int i = 2; i * i <= MAX_N; i++) {
      if (sieve[i]) {
        for (int j = i * i; j <= MAX_N; j += i) {
          sieve[j] = false;
        }
      }
    }
    for (int i = 2; i <= MAX_N; i++) {
      if (sieve[i] && different(i)) {
        different.add(i);
      }
    }
  }

  private boolean different(int n) {
    int[] count = new int[10];
    boolean different = true;
    while (n > 0) {
      int digit = n % 10;
      count[digit]++;
      different &= count[digit] == 1;
      n /= 10;
    }
    return different;
  }

  public static void main(String[] args) {
    System.out.println(new EllysDifferentPrimes().getClosest(50000000));
  }
}
