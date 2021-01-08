package atcoder.beginner.contest184;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IncrementOfCoins implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int a = in.ni(), b = in.ni(), c = in.ni();
    dp = new Double[100][100][100];
    out.println(recurse(a, b, c));
  }

  private Double[][][] dp;

  private double recurse(int a, int b, int c) {
    if (a == 100 || b == 100 || c == 100) return 0;

    if (dp[a][b][c] != null) return dp[a][b][c];

    double s = a + b + c;
    double takeA = (a / s) * (1 + recurse(a + 1, b, c));
    double takeB = (b / s) * (1 + recurse(a, b + 1, c));
    double takeC = (c / s) * (1 + recurse(a, b, c + 1));

    return dp[a][b][c] = takeA + takeB + takeC;
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
    try (IncrementOfCoins instance = new IncrementOfCoins()) {
      instance.solve();
    }
  }
}
