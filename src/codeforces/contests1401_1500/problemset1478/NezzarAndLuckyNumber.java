package codeforces.contests1401_1500.problemset1478;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NezzarAndLuckyNumber implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int q = in.ni(), d = in.ni();
      while (q-- > 0) {
        int num = in.ni();
        boolean lucky = false;
        for (int i = 0; i < 500; i++) {
          if (num >= i * d && isLucky(num - i * d, d)) {
            lucky = true;
            break;
          }
        }
        out.println(lucky ? "YES" : "NO");
      }
    }
  }

  private boolean isLucky(int n, int d) {
    while (n > 0) {
      if (n % 10 == d) return true;
      n /= 10;
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
    try (NezzarAndLuckyNumber instance = new NezzarAndLuckyNumber()) {
      instance.solve();
    }
  }
}
