package codeforces.contests1301_1400.problemset1333;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class KateAndImperfection implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    sieve();
    int n = in.ni();
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      result.add(sieve[i]);
    }
    result.sort(Comparator.naturalOrder());
    for (int i = 1; i < n; i++) {
      out.print(result.get(i));
      out.print(' ');
    }
  }

  private final int MAX_N = (int) 5e5;
  private int[] sieve = new int[MAX_N + 1];

  private void sieve() {
    sieve[1] = 1;
    for (int i = 2; i <= MAX_N; i++) {
      if (sieve[i] == 0) {
        for (int j = i; j <= MAX_N; j += i) {
          if (sieve[j] == 0) {
            sieve[j] = j / i;
          }
        }
      }
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
    try (KateAndImperfection instance = new KateAndImperfection()) {
      instance.solve();
    }
  }
}
