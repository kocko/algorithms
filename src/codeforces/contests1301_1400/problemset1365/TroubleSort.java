package codeforces.contests1301_1400.problemset1365;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TroubleSort implements Closeable {

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
      boolean one = false, zero = false;
      for (int i = 0; i < n; i++) {
        b[i] = in.ni();
        if (b[i] == 0) {
          zero = true;
        } else {
          one = true;
        }
      }
      boolean possible = true;
      if (!one || !zero) {
        for (int i = 1; i < n; i++) {
          possible &= (a[i] >= a[i - 1]);
        }
      }
      out.println(possible ? "Yes" : "No");
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
    try (TroubleSort instance = new TroubleSort()) {
      instance.solve();
    }
  }
}
