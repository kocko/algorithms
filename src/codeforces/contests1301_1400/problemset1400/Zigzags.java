package codeforces.contests1301_1400.problemset1400;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Zigzags implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    final int MAX_N = 3000;
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      int[] total = new int[MAX_N + 1];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        total[x[i]]++;
      }
      long result = 0;
      for (int i = 0; i < n - 1; i++) {
        int[] inner = new int[MAX_N + 1];
        total[x[i]]--;
        inner[x[i + 1]]++;
        long pairs = inner[x[i + 1]] * (total[x[i + 1]] - inner[x[i + 1]]);
        for (int k = i + 2; k < n - 1; k++) {
          if (x[i] == x[k]) {
            result += pairs;
            result -= inner[x[k]];
          }
          pairs -= inner[x[k]];
          inner[x[k]]++;
          pairs += (total[x[k]] - inner[x[k]]);
        }
      }
      out.println(result);
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
    try (Zigzags instance = new Zigzags()) {
      instance.solve();
    }
  }
}
