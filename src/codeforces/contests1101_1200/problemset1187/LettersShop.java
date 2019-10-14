package codeforces.contests1101_1200.problemset1187;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LettersShop implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] shop = in.next().toCharArray();
    count = new int[26][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 26; j++) {
        count[j][i] = count[j][i - 1];
      }
      int idx = shop[i - 1] - 'a';
      count[idx][i]++;
    }
    int q = in.ni();
    while (q-- > 0) {
      char[] name = in.next().toCharArray();
      int[] has = new int[26];
      for (char c : name) {
        has[c - 'a']++;
      }
      int left = 0, right = n, result = n;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (ok(mid, has)) {
          result = Math.min(mid, result);
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      out.println(result);
    }
  }

  private int[][] count;

  private boolean ok(int to, int[] has) {
    boolean ok = true;
    for (int i = 0; i < 26; i++) {
      ok &= has[i] <= count[i][to];
    }
    return ok;
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
    try (LettersShop instance = new LettersShop()) {
      instance.solve();
    }
  }
}
