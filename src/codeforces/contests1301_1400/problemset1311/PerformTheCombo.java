package codeforces.contests1301_1400.problemset1311;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PerformTheCombo implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      char[] combo = in.next().toCharArray();
      int[] count = new int[n + 1];
      for (int i = 0; i < m; i++) {
        count[in.ni()]++;
      }
      int[] prefix = new int[26];
      int[] result = new int[26];
      for (int i = 1; i <= n; i++) {
        prefix[combo[i - 1] - 'a']++;
        for (int j = 0; j < 26; j++) {
          result[j] += count[i] * prefix[j];
        }
      }
      for (int i = 0; i < 26; i++) {
        out.print(result[i] + prefix[i]);
        out.print(' ');
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
    try (PerformTheCombo instance = new PerformTheCombo()) {
      instance.solve();
    }
  }
}
