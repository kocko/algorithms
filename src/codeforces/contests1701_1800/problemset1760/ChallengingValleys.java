package codeforces.contests1701_1800.problemset1760;

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

public class ChallengingValleys implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public ChallengingValleys() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int min = Integer.MAX_VALUE, where = -1;
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        if (x[i] < min) {
          min = x[i];
          where = i;
        }
      }
      boolean ok = true;
      for (int idx = where + 1; idx < n; idx++) {
        if (idx >= 1) {
          ok &= x[idx] >= x[idx - 1];
        }
      }
      for (int idx = where - 1; idx >= 0; idx--) {
        if (idx + 1 < n) {
          ok &= x[idx] >= x[idx + 1];
        }
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
    try (ChallengingValleys instance = new ChallengingValleys()) {
      instance.solve();
    }
  }
}
