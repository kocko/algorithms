package codeforces.contests1101_1200.problemset1183;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class EqualizePrices implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      int n = in.ni(), k = in.ni();
      int[] prices = new int[n];
      for (int i = 0; i < n; i++) {
        prices[i] = in.ni();
      }
      int max = prices[0] + k, min = max(1, prices[0] - k);
      boolean possible = true;
      for (int i = 1; i < n; i++) {
        int mx = prices[i] + k, mn = max(1, prices[i] - k);
        if (mn > max || mx < min) {
          possible = false;
          break;
        }
        max = min(max, mx);
        min = max(min, mn);
      }
      out.println(possible ? max : -1);
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
    try (EqualizePrices instance = new EqualizePrices()) {
      instance.solve();
    }
  }
}
