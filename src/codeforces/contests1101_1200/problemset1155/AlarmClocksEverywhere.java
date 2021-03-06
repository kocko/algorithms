package codeforces.contests1101_1200.problemset1155;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlarmClocksEverywhere implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    long[] x = new long[n], p = new long[m];
    for (int i = 0; i < n; i++) {
      x[i] = in.nl();
    }
    for (int i = 0; i < m; i++) {
      p[i] = in.nl();
    }
    long gcd = 0;
    for (int i = 1; i < n; i++) {
      gcd = gcd(gcd, x[i] - x[i - 1]);
    }
    int idx = -1;
    for (int i = 0; i < m; i++) {
      if (gcd % p[i] == 0) {
        idx = i + 1;
        break;
      }
    }
    if (idx == -1) {
      out.println("NO");
    } else {
      out.println("YES");
      out.println(x[0] + " " + idx);
    }
  }
  
  private long gcd(long a, long b) {
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
    try (AlarmClocksEverywhere instance = new AlarmClocksEverywhere()) {
      instance.solve();
    }
  }
}
