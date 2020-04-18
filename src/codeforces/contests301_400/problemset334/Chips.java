package codeforces.contests301_400.problemset334;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Chips implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    boolean[] blockedRow = new boolean[n], blockedColumn = new boolean[n];
    blockedRow[0] = blockedColumn[0] = blockedRow[n - 1] = blockedColumn[n - 1] = true;
    for (int i = 0; i < m; i++) {
      int r = in.ni() - 1, c = in.ni() - 1;
      blockedRow[r] = blockedColumn[c] = true;
    }
    int result = 0;
    for (int i = 1; i < n - 1; i++) {
      if (n % 2 != 0 && n / 2 == i) {
        if (!blockedRow[i] || !blockedColumn[i]) {
          result++;
        }
      } else {
        if (!blockedRow[i]) result++;
        if (!blockedColumn[i]) result++;
      }
    }
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
    try (Chips instance = new Chips()) {
      instance.solve();
    }
  }
}
