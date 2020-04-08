package codeforces.contests1301_1400.problemset1333;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KindAnton implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
      }
      int[] b = new int[n];
      for (int i = 0; i < n; i++) {
        b[i] = in.ni();
      }
      boolean possible = true;
      boolean plus = false, minus = false;
      for (int i = 0; i < n; i++) {
        if (a[i] < b[i]) {
          possible &= plus;
        } else if (a[i] > b[i]) {
          possible &= minus;
        }
        if (a[i] == -1) {
          minus = true;
        } else if (a[i] == 1) {
          plus = true;
        }
      }
      out.println(possible ? "YES" : "NO");
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
    try (KindAnton instance = new KindAnton()) {
      instance.solve();
    }
  }
}
