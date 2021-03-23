package codeforces.contests1401_1500.problemset1451;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NonSubstringSubsequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), q = in.ni();
      char[] x = in.next().toCharArray();
      while (q-- > 0) {
        int left = in.ni() - 1, right = in.ni() - 1;
        boolean ok = false;
        for (int i = 0; i < left; i++) {
          ok |= x[i] == x[left];
        }
        for (int i = right + 1; i < n; i++) {
          ok |= x[i] == x[right];
        }
        out.println(ok ? "YES" : "NO");
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
    try (NonSubstringSubsequence instance = new NonSubstringSubsequence()) {
      instance.solve();
    }
  }
}
