package codeforces.contests1301_1400.problemset1327;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GameWithChips implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), k = in.ni();
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n - 1; i++) {
      result.append('D');
    }
    for (int i = 0; i < m - 1; i++) {
      result.append('R');
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m - 1; j++) {
        result.append(i % 2 == 0 ? 'L' : 'R');
      }
      if (i < n - 1) {
        result.append('U');
      }
    }
    out.println(result.length());
    out.println(result);
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
    try (GameWithChips instance = new GameWithChips()) {
      instance.solve();
    }
  }
}
