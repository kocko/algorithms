package codeforces.contests1201_1300.problemset1245;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ConstanzesMachine implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    long result = 1;
    int u = 0, n = 0;
    final long MOD = (long) 1e9 + 7;
    long[] fib = new long[x.length + 1];
    fib[0] = 1;
    fib[1] = 1;

    for (int i = 2; i < fib.length; i++) {
      fib[i] = (fib[i - 1] + fib[i - 2]);
      fib[i] %= MOD;
    }
    boolean hasM = false, hasW = false;
    for (char c : x) {
      hasM |= (c == 'm');
      hasW |= (c == 'w');
    }
    if (hasM || hasW) {
      out.println(0);
      return;
    }
    for (char c : x) {
      if (c == 'u') {
        u++;
        if (n > 0) {
          result *= fib[n];
          result %= MOD;
        }
        n = 0;
      } else if (c == 'n') {
        n++;
        if (u > 0) {
          result *= fib[u];
          result %= MOD;
        }
        u = 0;
      } else {
        if (n > 0) {
          result *= fib[n];
          result %= MOD;
          n = 0;
        }
        if (u > 0) {
          result *= fib[u];
          result %= MOD;
          u = 0;
        }
      }
    }
    if (n > 0) {
      result *= fib[n];
      result %= MOD;
    }
    if (u > 0) {
      result *= fib[u];
      result %= MOD;
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
    try (ConstanzesMachine instance = new ConstanzesMachine()) {
      instance.solve();
    }
  }
}
