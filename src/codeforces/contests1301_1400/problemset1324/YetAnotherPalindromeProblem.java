package codeforces.contests1301_1400.problemset1324;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class YetAnotherPalindromeProblem implements Closeable {

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
      int[] first = new int[5001];
      int[] last = new int[5001];
      for (int i = 0; i <= 5000; i++) {
        first[i] = last[i] = -1;
      }
      for (int i = 0; i < n; i++) {
        int value = x[i];
        if (first[value] == -1) {
          first[value] = last[value] = i;
        } else {
          last[value] = i;
        }
      }
      boolean ok = false;
      for (int i = 0; i < n; i++) {
        if (first[x[i]] != -1) {
          ok |= last[x[i]] - first[x[i]] >= 2;
        }
      }
      out.println(ok ? "YES" : "NO");
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
    try (YetAnotherPalindromeProblem instance = new YetAnotherPalindromeProblem()) {
      instance.solve();
    }
  }
}
