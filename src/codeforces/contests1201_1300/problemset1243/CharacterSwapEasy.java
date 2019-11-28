package codeforces.contests1201_1300.problemset1243;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CharacterSwapEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray(), y = in.next().toCharArray();
      int[] diff = new int[2];
      boolean ok = true;
      int idx = 0;
      for (int i = 0; i < n; i++) {
        if (x[i] != y[i]) {
          if (idx < 2) {
            diff[idx++] = i;
          } else {
            ok = false;
            break;
          }
        }
      }
      ok &= idx == 2;
      ok &= x[diff[0]] == x[diff[1]] && y[diff[0]] == y[diff[1]];
      out.println(ok ? "Yes" : "No");
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
    try (CharacterSwapEasy instance = new CharacterSwapEasy()) {
      instance.solve();
    }
  }
}
