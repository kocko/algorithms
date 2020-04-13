package codeforces.contests1301_1400.problemset1334;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CircleOfMonsters implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long[] health = new long[2 * n];
      long[] damage = new long[2 * n];
      for (int i = 0; i < n; i++) {
        health[i] = health[n + i] = in.nl();
        damage[i] = damage[n + i] = in.nl();
      }
      long[] prefix = new long[2 * n];
      for (int i = 0; i < n - 1; i++) {
        if (damage[i] < health[i + 1]) {
          prefix[i + 1] = prefix[n + i + 1] = health[i + 1] - damage[i];
        }
      }
      if (damage[n - 1] < health[0]) {
        prefix[0] = prefix[n] = health[0] - damage[n - 1];
      }
      for (int i = 1; i < 2 * n; i++) {
        prefix[i] += prefix[i - 1];
      }
      long result = Long.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        long cost = health[i] + prefix[n + i - 1] - prefix[i];
        result = Math.min(cost, result);
      }
      out.println(result);
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
    try (CircleOfMonsters instance = new CircleOfMonsters()) {
      instance.solve();
    }
  }
}
