package codeforces.contests1401_1500.problemset1468;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WasteSorting implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int[] c = new int[3];
      for (int i = 0; i < 3; i++) {
        c[i] = in.ni();
      }
      int[] waste = new int[5];
      for (int i = 0; i < 5; i++) {
        waste[i] = in.ni();
      }
      boolean ok = true;
      for (int i = 0; i < 2; i++) {
        c[i] -= waste[i];
        if (c[i] > 0 && waste[i + 3] > 0) {
          int take = Math.min(c[i], waste[i + 3]);
          waste[i + 3] -= take;
          c[i] -= take;
        }
      }
      c[2] -= waste[2];
      c[2] = c[2] - waste[3] - waste[4];
      for (int i = 0; i < 3; i++) {
        ok &= c[i] >= 0;
      }
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
    try (WasteSorting instance = new WasteSorting()) {
      instance.solve();
    }
  }
}
