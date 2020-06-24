package codeforces.contests1201_1300.problemset1269;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ModuloEquality implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long MOD = in.nl();
    long[] a = new long[n];
    long[] b = new long[n];
    for (int i = 0; i < n; i++) a[i] = in.nl();
    for (int i = 0; i < n; i++) b[i] = in.ni();
    Map<Long, Integer> count = new HashMap<>();
    for (int i = 0; i < n; i++) {
      count.put(b[i], count.getOrDefault(b[i], 0) + 1);
    }
    long result = Long.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      long x;
      if (b[i] >= a[0]) {
        x = b[i] - a[0];
      } else {
        x = (MOD - a[0] + b[i]) % MOD;
      }
      Map<Long, Integer> has = new HashMap<>();
      for (int j = 0; j < n; j++) {
        long value = (a[j] + x) % MOD;
        has.put(value, has.getOrDefault(value, 0) + 1);
      }
      boolean same = true;
      for (Map.Entry<Long, Integer> entry : has.entrySet()) {
        int real = count.getOrDefault(entry.getKey(), -1);
        same &= entry.getValue() == real;
      }
      if (same) {
        result = Math.min(result, x);
      }
    }
    out.println(result);

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
    try (ModuloEquality instance = new ModuloEquality()) {
      instance.solve();
    }
  }
}
