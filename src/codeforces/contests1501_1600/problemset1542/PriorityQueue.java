package codeforces.contests1501_1600.problemset1542;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class PriorityQueue implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public PriorityQueue() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    n = in.ni();
    x = new long[n];

    fill(x, -1);

    for (int i = 0; i < n; i++) {
      int type = in.next().charAt(0);
      if (type == '+') {
        x[i] = in.nl();
      }
    }
    long result = 0;
    dp = new long[n][n];
    for (int i = 0; i < n; i++) {
      if (x[i] > 0) {
        reset();
        pivot = i;
        long score = recurse(0, 0);
        result += (x[i] * score);
        result %= MOD;
      }
    }
    out.println(result);
  }

  private static final long MOD = 998244353L;
  private int n;
  private long[] x;
  private long[][] dp;
  private int pivot;

  private void reset() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = -1L;
      }
    }
  }

  private long recurse(int idx, int smaller) {
    if (idx == n) return 1L;

    if (dp[idx][smaller] != -1) return dp[idx][smaller];

    long result = 0;
    if (idx < pivot) {
      if (x[idx] == -1) {
        //execute the delete
        result += recurse(idx + 1, max(smaller - 1, 0));
        result %= MOD;
        //do not execute delete
        result += recurse(idx + 1, smaller);
        result %= MOD;
      } else {
        if (x[idx] <= x[pivot]) {
          //add the smaller to the priority queue
          result += recurse(idx + 1, smaller + 1);
          result %= MOD;
          //do not add the smaller
          result += recurse(idx + 1, smaller);
          result %= MOD;
        } else {
          //add or do not add the bigger
          result += 2L * recurse(idx + 1, smaller);
          result %= MOD;
        }
      }
    } else if (idx == pivot) {
      result += recurse(idx + 1, smaller);
      result %= MOD;
    } else {
      if (x[idx] == -1) {
        //execute the delete
        if (smaller > 0) {
          result += (recurse(idx + 1, smaller - 1));
          result %= MOD;
        }
        //do not execute delete
        result += recurse(idx + 1, smaller);
        result %= MOD;
      } else {
        if (x[idx] < x[pivot]) {
          //add the smaller to the priority queue
          result += recurse(idx + 1, smaller + 1);
          result %= MOD;
          //do not add the smaller
          result += recurse(idx + 1, smaller);
          result %= MOD;
        } else {
          result += 2L * recurse(idx + 1, smaller);
          result %= MOD;
        }
      }
    }
    return dp[idx][smaller] = result;
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
    try (PriorityQueue instance = new PriorityQueue()) {
      instance.solve();
    }
  }
}
