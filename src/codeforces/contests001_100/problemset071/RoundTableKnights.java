package codeforces.contests001_100.problemset071;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RoundTableKnights implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    x = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      x[i] = in.ni();
    }
    int half = (n + 1) / 2;
    for (int i = 1; i < half; i++) {
      if (n % i == 0 && ok(i)) {
        out.println("YES");
        return;
      }
    }
    out.println("NO");
  }

  private int n;
  private int[] x;

  private boolean ok(int k) {
    for (int i = 1; i <= k; i++) {
      boolean ok = true;
      for (int j = i; j <= n; j += k) {
        ok &= x[j] == 1;
      }
      if (ok) {
        return true;
      }
    }
    return false;
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
    try (RoundTableKnights instance = new RoundTableKnights()) {
      instance.solve();
    }
  }
}
