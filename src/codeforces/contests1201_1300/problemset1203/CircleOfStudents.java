package codeforces.contests1201_1300.problemset1203;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CircleOfStudents implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[2 * n];
      for (int i = 0; i < n; i++) {
        x[i] = x[n + i] = in.ni();
      }
      boolean clockwise = true;
      for (int start = 0; start < n; start++) {
        if (x[start] == 1) {
          for (int i = start + 1; i < start + n; i++) {
            clockwise &= x[i] == i - start + 1;
          }
        }
      }
      boolean reverse = true;
      for (int start = 2 * n - 1; start >= n; start--) {
        if (x[start] == 1) {
          for (int i = start - 1; i > start - n; i--) {
            reverse &= x[i] == start - i + 1;
          }
        }
      }
      boolean ok = clockwise || reverse;
      out.println(ok ? "YES" : "NO");
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
    try (CircleOfStudents instance = new CircleOfStudents()) {
      instance.solve();
    }
  }
}
