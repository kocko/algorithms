package codeforces.contests1301_1400.problemset1341;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NastyaAndStrangeGenerator implements Closeable {

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
      int[] pos = new int[n + 1];
      for (int i = 0; i < n; i++) {
        pos[x[i]] = i;
      }
      boolean possible = true;
      int value = 1, end = n - 1;
      while (value <= n && possible) {
        int start = pos[value];
        int idx = start;
        while (idx <= end && possible) {
          possible = x[idx] == value;
          value++;
          idx++;
        }
        end = start - 1;
      }
      out.println(possible ? "Yes" : "No");
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
    try (NastyaAndStrangeGenerator instance = new NastyaAndStrangeGenerator()) {
      instance.solve();
    }
  }
}
