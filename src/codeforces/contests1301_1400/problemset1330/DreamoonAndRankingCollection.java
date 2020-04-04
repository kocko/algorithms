package codeforces.contests1301_1400.problemset1330;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DreamoonAndRankingCollection implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), x = in.ni();
      boolean[] has = new boolean[205];
      for (int i = 0; i < n; i++) {
        has[in.ni()] = true;
      }
      for (int i = 1; x > 0 && i <= 201; i++) {
        if (!has[i]) {
          x--;
          has[i] = true;
        }
      }
      int idx = 1;
      while (idx <= 201) {
        if (!has[idx]) break;
        idx++;
      }
      out.println(idx - 1);
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
    try (DreamoonAndRankingCollection instance = new DreamoonAndRankingCollection()) {
      instance.solve();
    }
  }
}
