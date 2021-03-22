package codeforces.contests1501_1600.problemset1501;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NapoleonCake implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      int[] result = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      for (int i = 0; i < n; i++) {
        if (x[i] > 0) {
          int start = Math.max(0, i - x[i] + 1);
          result[start]++;
          if (i < n - 1) {
            result[i + 1]--;
          }
        }
      }
      for (int i = 1; i < n; i++) {
        result[i] += result[i - 1];
      }
      for (int i = 0; i < n; i++) {
        out.print(result[i] > 0 ? 1 : 0);
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
    try (NapoleonCake instance = new NapoleonCake()) {
      instance.solve();
    }
  }
}
