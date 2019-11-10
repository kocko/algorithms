package codeforces.contests201_300.problemset294;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShaashAndLights implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final int MOD = (int) 1e9 + 7;
    int n = in.ni(), m = in.ni();
    int[][] nCr = new int[1001][1001];
    for (int i = 0; i <= 1000; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          nCr[i][j] = 1;
        } else {
          nCr[i][j] = (nCr[i - 1][j] + nCr[i - 1][j - 1]) % MOD;
        }
      }
    }
    int[] pow = new int[1001];
    pow[0] = pow[1] = 1;
    for (int i = 2; i <= n; i++) {
      pow[i] = (pow[i - 1] * 2) % MOD;
    }
    int[] s = new int[m];
    for (int i = 0; i < m; i++) {
      s[i] = in.ni();
    }
    Arrays.sort(s);
    int count = 0, tmp;
    long result = 1;
    for (int i = 0; i < m; i++) {
      if (i == 0) {
        tmp = s[i] - 1;
      } else {
        tmp = s[i] - s[i - 1] - 1;
        result = (result * pow[tmp]) % MOD;
      }
      count += tmp;
      result = (result * nCr[count][tmp]) % MOD;
    }
    count += n - s[m - 1];
    result = (result * nCr[count][n - s[m - 1]]) % MOD;
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
    try (ShaashAndLights instance = new ShaashAndLights()) {
      instance.solve();
    }
  }
}
