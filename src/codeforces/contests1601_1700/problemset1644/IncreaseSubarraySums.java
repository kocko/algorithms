package codeforces.contests1601_1700.problemset1644;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class IncreaseSubarraySums implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long k = in.nl();
      long[] maxArrayWithLength = new long[n + 1];
      for (int i = 0; i <= n; i++) {
        maxArrayWithLength[i] = Long.MIN_VALUE;
      }
      maxArrayWithLength[0] = 0;
      long[] x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      for (int i = 0; i < n; i++) {
        long sum = 0;
        for (int j = i; j < n; j++) {
          sum += x[j];
          int size = j - i + 1;
          maxArrayWithLength[size] = Math.max(maxArrayWithLength[size], sum);
        }
      }
      long[] result = new long[n + 1];
      for (int times = 0; times <= n; times++) {
        for (int size = 0; size <= n; size++) {
          result[times] = Math.max(result[times], min(times, size) * k + maxArrayWithLength[size]);
        }
      }
      for (int i = 0; i <= n; i++) {
        out.print(result[i] + " ");
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
    try (IncreaseSubarraySums instance = new IncreaseSubarraySums()) {
      instance.solve();
    }
  }
}