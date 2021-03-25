package codeforces.contests1401_1500.problemset1473;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Program implements Closeable {

  private final InputReader in = new InputReader(System.in);
  private final PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      char[] x = in.next().toCharArray();
      int[] prefix = new int[n + 1];
      int[] prefixMax = new int[n + 1];
      int[] prefixMin = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        int value = x[i - 1] == '+' ? 1 : -1;
        prefix[i] = prefix[i - 1] + value;
        prefixMax[i] = Math.max(prefix[i], prefixMax[i - 1]);
        prefixMin[i] = Math.min(prefix[i], prefixMin[i - 1]);
      }
      int[] suffix = new int[n + 2];
      int[] suffixMax = new int[n + 2];
      int[] suffixMin = new int[n + 2];
      for (int i = n; i > 0; i--) {
        int value = x[i - 1] == '-' ? 1 : -1;
        suffix[i] = suffix[i + 1] + value;
        suffixMax[i] = Math.max(suffix[i], suffixMax[i + 1]);
        suffixMin[i] = Math.min(suffix[i], suffixMin[i + 1]);
      }
      while (m-- > 0) {
        int left = in.ni(), right = in.ni();
        int max = prefixMax[left - 1];
        int min = prefixMin[left - 1];
        int value = prefix[left - 1];
        int maxDelta = suffixMax[right + 1] - suffix[right + 1];
        int minDelta = suffixMin[right + 1] - suffix[right + 1];
        max = Math.max(max, value + maxDelta);
        min = Math.min(min, value + minDelta);
        out.println(max - min + 1);
      }
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
    try (Program instance = new Program()) {
      instance.solve();
    }
  }
}
