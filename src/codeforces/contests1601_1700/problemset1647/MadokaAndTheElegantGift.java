package codeforces.contests1601_1700.problemset1647;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class MadokaAndTheElegantGift implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MadokaAndTheElegantGift() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      char[][] x = new char[n][m];
      for (int i = 0; i < n; i++) {
        x[i] = in.next().toCharArray();
      }
      boolean ok = true;
      for (int i = 1; i < n; i++) {
        int start = -1, end = -1;
        for (int j = 0; j < m; j++) {
          if (x[i][j] == '0') {
            if (start != -1) {
              for (int k = start; k <= end; k++) {
                ok &= x[i - 1][k] == x[i - 1][start];
              }
              if (x[i - 1][start] == '1') {
                if (start >= 1) ok &= x[i - 1][start - 1] == '0';
                if (end + 1 < m) ok &= x[i - 1][end + 1] == '0';
              }
            }
            start = end = -1;
          } else {
            if (start == -1) {
              start = j;
            }
            end = j;
          }
        }
        if (start != -1) {
          for (int k = start; k <= end; k++) {
            ok &= x[i - 1][k] == x[i - 1][start];
          }
          if (x[i - 1][start] == '1') {
            if (start >= 1) ok &= x[i - 1][start - 1] == '0';
            if (end + 1 < m) ok &= x[i - 1][end + 1] == '0';
          }
        }
      }
      out.println(ok ? "yes" : "no");
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
    try (MadokaAndTheElegantGift instance = new MadokaAndTheElegantGift()) {
      instance.solve();
    }
  }
}
