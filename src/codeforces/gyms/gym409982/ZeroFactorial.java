package codeforces.gyms.gym409982;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class ZeroFactorial implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public ZeroFactorial() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int a = in.ni(), b = in.ni();
      if (a > 0) a--;
      long ans = 0;
      for (long i = 5; i < 1e9; i *= 5) {
        ans += f(i, b) - f(i, a);
        ans = (ans + MOD) % MOD;
      }
      out.println(ans);
    }
  }

  private final long MOD = (long) 1e9 + 7;

  private long f(long a, long b) {
    long t = (b + 1L) / a;
    long result = a * t % MOD * (t - 1L) / 2L;
    result %= MOD;
    result += (b + 1 - a * t) * t;
    result %= MOD;
    return result;
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
    try (ZeroFactorial instance = new ZeroFactorial()) {
      instance.solve();
    }
  }
}
