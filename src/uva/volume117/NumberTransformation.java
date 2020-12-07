package uva.volume117;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class NumberTransformation implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    init();
    int testCase = 1, s, t;
    while ((s = in.nextInt()) != 0 | (t = in.nextInt()) != 0) {
      int d = recurse(s, t);
      out.printf("Case %d: %d\n", testCase++, d >= oo ? -1 : d);
    }
  }

  private final int MAX_N = 1000, oo = 5000;
  private List<List<Integer>> tree;
  private Integer[][] dist;

  private void init() {
    tree = new ArrayList<>();
    int[] sieve = new int[MAX_N + 1];
    for (int i = 0; i <= MAX_N; i++) {
      tree.add(new ArrayList<>());
      sieve[i] = i;
    }
    for (int i = 2; i <= MAX_N; i++) {
      if (sieve[i] == i) {
        for (int j = i * i; j <= MAX_N; j += i) {
          sieve[j] = i;
        }
      }
    }
    for (int u = 4; u <= MAX_N; u++) {
      int value = u;
      Set<Integer> primes = new HashSet<>();
      while (value > 1) {
        int divisor = sieve[value];
        value /= divisor;
        if (divisor != u) {
          primes.add(divisor);
        }
      }
      for (int divisor : primes) {
        tree.get(u).add(u + divisor);
      }
    }
    dist = new Integer[MAX_N + 1][MAX_N + 1];
  }

  private int recurse(int i, int j) {
    if (i == j) return 0;

    if (dist[i][j] != null) return dist[i][j];

    int ans = oo;
    for (int v : tree.get(i))
      if (v <= j) {
        ans = Math.min(1 + recurse(v, j), ans);
      }
    return dist[i][j] = ans;
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (NumberTransformation instance = new NumberTransformation()) {
      instance.solve();
    }
  }
}
