package codeforces.contests1701_1800.problemset1741;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MinimizeTheThickness implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), sum = 0;
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        sum += (x[i] = in.ni());
      }
      int result = Integer.MAX_VALUE;
      int prefix = 0;
      for (int i = 0; i < n; i++) {
        prefix += x[i];
        if (sum % prefix == 0) {
          boolean can = true;
          int thickness = i + 1;
          int idx = i + 1;
          int currentSum = 0, currentThickness = 0;
          while (idx < n) {
            currentSum += x[idx];
            currentThickness++;
            if (currentSum == prefix) {
              thickness = Math.max(thickness, currentThickness);
              currentThickness = 0;
              currentSum = 0;
            } else if (currentSum > prefix) {
              can = false;
              break;
            }
            idx++;
          }
          if (can) {
            result = Math.min(result, thickness);
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
    try (MinimizeTheThickness instance = new MinimizeTheThickness()) {
      instance.solve();
    }
  }
}