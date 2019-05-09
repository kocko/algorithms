package codeforces.contests1101_1200.problemset1157;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IncreasingSubsequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    left.add(x[0]);
    right.add(x[n - 1]);
    for (int i = 1; i < n; i++) {
      if (x[i] > x[i - 1]) {
        left.add(x[i]);
      } else break;
    }
    for (int i = n - 2; i >= 0; i--) {
      if (x[i] > x[i + 1]) {
        right.add(x[i]);
      } else break;
    }
    final int oo = Integer.MAX_VALUE;
    StringBuilder result = new StringBuilder();
    int i = 0, j = 0;
    while (i < left.size() || j < right.size()) {
      int a = i < left.size() ? left.get(i) : oo;
      int b = j < right.size() ? right.get(j) : oo;
      if (a < b) {
        result.append('L');
        i++;
      } else if (a > b) {
        result.append('R');
        j++;
      } else {
        int leftRemaining = left.size() - i; 
        int rightRemaining = right.size() - j;
        if (leftRemaining > rightRemaining) {
          result.append('L');
          while (++i < left.size()) {
            result.append('L');
          }
        } else {
          result.append('R');
          while (++j < right.size()) {
            result.append('R');
          }
        }
        break;
      }
    }
    out.println(result.length());
    out.println(result.toString());
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
    try (IncreasingSubsequence instance = new IncreasingSubsequence()) {
      instance.solve();
    }
  }
}
