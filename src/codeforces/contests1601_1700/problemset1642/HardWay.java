package codeforces.contests1601_1700.problemset1642;

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

public class HardWay implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public HardWay() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long[][] x = new long[3][2];
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 2; j++) {
          x[i][j] = in.nl();
        }
      }
      double result = 0.;
      if (x[0][1] == x[1][1]) {
        if (x[2][1] < x[1][1]) {
          result = dist(x, 0, 1);
        }
      } else if (x[0][1] == x[2][1]) {
        if (x[1][1] < x[2][1]) {
          result = dist(x, 0, 2);
        }
      } else if (x[1][1] == x[2][1]) {
        if (x[0][1] < x[1][1]) {
          result = dist(x, 1, 2);
        }
      }
      out.println(result);
    }
  }

  private double dist(long[][] x, int a, int b) {
    return Math.abs(x[a][0] - x[b][0]);
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
    try (HardWay instance = new HardWay()) {
      instance.solve();
    }
  }
}
