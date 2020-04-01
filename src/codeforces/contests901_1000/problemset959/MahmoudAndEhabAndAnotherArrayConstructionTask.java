package codeforces.contests901_1000.problemset959;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MahmoudAndEhabAndAnotherArrayConstructionTask implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class DisjointSet {
    private int[] root;

    private DisjointSet(int n) {
      root = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
      }
    }

    private int root(int x) {
      return (x == root[x]) ? x : (root[x] = root(root[x]));
    }
  }

  public void solve() {
    int n = in.ni();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
    }
    int[] b = new int[n];
    boolean bigger = false;
    DisjointSet dsu = new DisjointSet(MAX + 1);
    int minimalRoot = 2;
    for (int i = 0; i < n; i++) {
      Set<Integer> factors = factorize(a[i]);
      int root;
      if (!bigger) {
        root = dsu.root(a[i]);
        if (root > a[i]) {
          factors = factorize(root);
          bigger = true;
        }
        for (int f : factors) {
          int r = dsu.root(f);
          for (int j = r; j < MAX; j += r) {
            dsu.root[j] = dsu.root(j + 1);
          }
        }
        b[i] = root;
      } else {
        root = dsu.root(minimalRoot);
        for (int j = root; j < MAX; j += root) {
          dsu.root[j] = dsu.root(j + 1);
        }

        minimalRoot = root;
      }
      b[i] = root;
    }
    for (int b_ : b) {
      out.print(b_);
      out.print(' ');
    }
  }

  private final int MAX = (int) 5e6 + 1;
  private int[] sieve = new int[MAX];

  {
    for (int i = 0; i < MAX; i++) {
      sieve[i] = i;
    }
    for (int i = 2; i * i < MAX; i++) {
      if (sieve[i] == i) {
        for (int c = i * i; c < MAX; c += i) {
          sieve[c] = i;
        }
      }
    }
  }

  private Set<Integer> factorize(int n) {
    Set<Integer> factors = new HashSet<>();
    while (n > 1) {
      factors.add(sieve[n]);
      n /= sieve[n];
    }
    return factors;
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int ni() {
      return Integer.parseInt(next());
    }

    public long nl() {
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (MahmoudAndEhabAndAnotherArrayConstructionTask instance = new MahmoudAndEhabAndAnotherArrayConstructionTask()) {
      instance.solve();
    }
  }
}
