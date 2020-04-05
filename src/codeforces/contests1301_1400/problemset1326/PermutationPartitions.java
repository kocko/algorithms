package codeforces.contests1301_1400.problemset1326;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PermutationPartitions implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    final long MOD = 998244353L;
    int[] x = new int[n];
    List<Integer> max = new ArrayList<>();
    long sum = 0;
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      if (x[i] > n - m) {
        max.add(i);
        sum += x[i];
      }
    }
    long result = 1L;
    for (int i = 1; i < max.size(); i++) {
      int current = max.get(i), prev = max.get(i - 1);
      result = result * (current - prev);
      result %= MOD;
    }
    out.println(sum + " " + result);
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
    try (PermutationPartitions instance = new PermutationPartitions()) {
      instance.solve();
    }
  }
}
