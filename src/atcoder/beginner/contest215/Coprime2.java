package atcoder.beginner.contest215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Coprime2 implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Coprime2() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    final int MAX_N = (int) 1e5;
    int n = in.ni(), m = in.ni();
    sieve = new int[MAX_N + 1];
    for (int i = 0; i <= MAX_N; i++) {
      sieve[i] = i;
    }
    initModifiedSieve();
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      if (next > 1) {
        factorize(next);
      }
    }
    List<Integer> result = new ArrayList<>();
    result.add(1);
    for (int i = 2; i <= m; i++) {
      int value = i;
      boolean coPrime = true;
      while (value > 1) {
        int d = sieve[value];
        if (skip.contains(d)) {
          coPrime = false;
          break;
        }
        value /= d;
      }
      if (coPrime) {
        result.add(i);
      }
    }
    out.println(result.size());
    result.forEach(out::println);
  }

  private int[] sieve;
  private Set<Integer> skip = new HashSet<>();

  private void initModifiedSieve() {
    int n = sieve.length;
    for (int d = 2; ((long)d * d) < n; d++) {
      if (sieve[d] == d) {
        int idx = d * d;
        while (idx < n) {
          sieve[idx] = d;
          idx += d;
        }
      }
    }
  }

  private void factorize(int x) {
    while (x > 1) {
      skip.add(sieve[x]);
      x /= sieve[x];
    }
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
    try (Coprime2 instance = new Coprime2()) {
      instance.solve();
    }
  }
}
