package codeforces.contests1101_1200.problemset1195;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SubmarineInTheRybinskSeaHard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();

    int[][] a = new int[n][10];
    int[] lens = new int[11];

    for (int i = 0; i < n; i++) {
      int x = in.ni();

      int j = 0;
      while (x > 0) {
        a[i][j] = x % 10;
        x /= 10;
        j++;
      }
      lens[j]++;
    }

    long ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 10; j++) {
        if (a[i][j] == 0) continue;
        for (int k = 1; k < 11; k++) {
          if (lens[k] == 0) continue;
          int p1 = j + Math.min(j, k);
          ans = (ans + a[i][j] * lens[k] * power(10, p1) % MOD) % MOD;

          int p2 = j + Math.min(j + 1, k);
          ans = (ans + a[i][j] * lens[k] * power(10, p2) % MOD) % MOD;
        }
      }
    }
    out.println(ans);
  }
  
  private final long MOD = 998244353L;
  
  private long power(long a, long b) {
    if (b == 0) return 1L;
    if (b == 1) return a;
    long result;
    long half = power(a, b / 2);
    if (b % 2 == 0) {
      result = (half * half);
    } else {
      result = a * half * half;
    }
    return result % MOD;
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
    try (SubmarineInTheRybinskSeaHard instance = new SubmarineInTheRybinskSeaHard()) {
      instance.solve();
    }
  }
}
