package codeforces.contests1401_1500.problemset1454;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberIntoSequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long n = in.nl();
      Map<Long, Integer> factors = new HashMap<>();
      for (long i = 2; i * i <= n; i++) {
        while (n % i == 0) {
          factors.put(i, factors.getOrDefault(i, 0) + 1);
          n /= i;
        }
      }
      if (n > 1) {
        factors.put(n, factors.getOrDefault(n, 0) + 1);
      }
      int k = 1;
      for (Map.Entry<Long, Integer> entry : factors.entrySet()) {
        k = Math.max(k, entry.getValue());
      }
      long[] result = new long[k];
      for (int i = 0; i < k; i++) {
        result[i] = 1;
      }
      for (Map.Entry<Long, Integer> entry : factors.entrySet()) {
        int idx = k - 1;
        for (int i = 0; i < entry.getValue(); i++, idx--) {
          result[idx] *= entry.getKey();
        }
      }
      out.println(k);
      for (int i = 0; i < k; i++) {
        out.print(result[i]);
        out.print(' ');
      }
      out.println();
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
    try (NumberIntoSequence instance = new NumberIntoSequence()) {
      instance.solve();
    }
  }
}
