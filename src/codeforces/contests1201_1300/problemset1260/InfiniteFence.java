package codeforces.contests1201_1300.problemset1260;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InfiniteFence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int r = in.ni(), b = in.ni(), k = in.ni(), gcd = gcd(r, b);
      r /= gcd;
      b /= gcd;
      int max = Math.max(r, b), min = Math.min(r, b);
      int times;
      if (max % min == 0) {
        times = max / min - 1;
      } else {
        max--;
        times = max / min;
        if (max % min != 0) {
          times++;
        }
      }
      out.println(times < k ? "OBEY" : "REBEL");
    }
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
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
    try (InfiniteFence instance = new InfiniteFence()) {
      instance.solve();
    }
  }
}
