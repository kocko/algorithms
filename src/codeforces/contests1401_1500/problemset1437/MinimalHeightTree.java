package codeforces.contests1401_1500.problemset1437;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinimalHeightTree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] order = new int[n];
      for (int i = 0; i < n; i++) {
        order[i] = in.ni();
      }
      int last = -1, idx = 1, root = 0, max = 0;
      int[] height = new int[n + 1];
      height[order[root]] = 0;
      while (idx < n) {
        if (order[idx] < last) {
          root++;
          last = -1;
        } else {
          height[order[idx]] = height[order[root]] + 1;
          max = Math.max(max, height[order[idx]]);
          last = order[idx];
          idx++;
        }
      }
      out.println(max);
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
    try (MinimalHeightTree instance = new MinimalHeightTree()) {
      instance.solve();
    }
  }
}
