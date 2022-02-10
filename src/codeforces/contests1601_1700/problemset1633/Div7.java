package codeforces.contests1601_1700.problemset1633;

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

public class Div7 implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Div7() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      String result = "";
      if (n == 1) {
        result = "7";
      } else if (n == 2) {
        int minDiff = 3;
        for (int i = 1; i <= 9; i++) {
          for (int j = 0; j <= 9; j++) {
            int value = 10 * i + j;
            if (value % 7 == 0) {
              int d = 0;
              if (x[0] - '0' != i) d++;
              if (x[1] - '0' != j) d++;
              if (d < minDiff) {
                minDiff = d;
                result = (i + "" + j);
              }
            }
          }
        }
      } else {
        int minDiff = 4;
        for (int i = 1; i < 10; i++) {
          for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
              int value = 100 * i + 10 * j + k;
              if (value % 7 == 0) {
                int d = 0;
                if (x[0] - '0' != i) d++;
                if (x[1] - '0' != j) d++;
                if (x[2] - '0' != k) d++;
                if (d < minDiff) {
                  minDiff = d;
                  result = (i + "" + j + "" + k);
                }
              }
            }
          }
        }
      }
      out.println(result);
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
    try (Div7 instance = new Div7()) {
      instance.solve();
    }
  }
}
