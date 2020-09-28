package codeforces.contests1401_1500.problemset1426;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SymmetricMatrix implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      int[][][] tiles = new int[n][2][2];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
              tiles[i][j][k] = in.ni();
            }
          }
        }
      if (m % 2 == 1) {
        out.println("NO");
      } else {
        boolean result = false;
        for (int i = 0; i < n; i++) {
          result |= (tiles[i][0][1] == tiles[i][1][0]);
        }
        out.println(result ? "YES" : "NO");
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
    try (SymmetricMatrix instance = new SymmetricMatrix()) {
      instance.solve();
    }
  }
}
