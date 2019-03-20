package timus.volume02;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximumSum implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[][] x = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        x[i][j] = in.ni();
      }
    }
    int maxSum = Integer.MIN_VALUE;
    for (int left = 0; left < n; left++) {
      int[] sum = new int[n];
      for (int right = left; right < n; right++) {
        for (int row = 0; row < n; row++) {
          sum[row] += x[row][right];
        }
        int max = kadane(sum);
        if (max > maxSum) {
          maxSum = max;
        }
      }
    }
    if (maxSum == 0) {
      maxSum = -200;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          maxSum = Math.max(maxSum, x[i][j]);
        }
      }
    }
    out.println(maxSum);
  }
  
  private int kadane(int[] x) {
    int max = 0, maxEndingHere = 0;
    for (int num : x) {
      maxEndingHere += num;
      if (maxEndingHere < 0) {
        maxEndingHere = 0;
      }
      if (maxEndingHere > max) {
        max = maxEndingHere;
      }
    }
    return max;
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
    try (MaximumSum instance = new MaximumSum()) {
      instance.solve();
    }
  }
}
