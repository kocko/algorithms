package codeforces.contests1401_1500.problemset1450;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class RatingCompression implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      int[] count = new int[n + 1];
      ArrayDeque<Integer> stack = new ArrayDeque<>();
      int[] left = new int[n], right = new int[n];
      for (int idx = 0; idx < n; idx++) {
        int next = x[idx];
        while (stack.size() > 0 && x[stack.peekLast()] >= next) {
          stack.pollLast();
        }
        int prev = stack.size() == 0 ? -1 : stack.peekLast();
        stack.addLast(idx);
        left[idx] = prev;
      }
      stack = new ArrayDeque<>();
      for (int idx = n - 1; idx >= 0; idx--) {
        int next = x[idx];
        while (stack.size() > 0 && x[stack.peekLast()] >= next) {
          stack.pollLast();
        }
        int nxt = stack.size() == 0 ? n : stack.peekLast();
        stack.addLast(idx);
        right[idx] = nxt;
      }
      int[] max = new int[n + 1];
      for (int idx = 0; idx < n; idx++) {
        int sum = right[idx] - left[idx] - 1;
        max[x[idx]] = Math.max(max[x[idx]], sum);
      }
      for (int i = 1; i <= n; i++) {
        if (max[i] > 0) {
          int update = Math.min(max[i], n - i + 1);
          count[update]++;
        }
      }
      for (int i = n - 1; i >= 1; i--) {
        count[i] += count[i + 1];
      }
      for (int i = 1; i <= n; i++) {
        out.print(count[i] == n - i + 1 ? 1 : 0);
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
    try (RatingCompression instance = new RatingCompression()) {
      instance.solve();
    }
  }
}
