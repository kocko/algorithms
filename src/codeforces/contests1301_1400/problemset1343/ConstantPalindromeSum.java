package codeforces.contests1301_1400.problemset1343;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ConstantPalindromeSum implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
      }
      int[] prefix = new int[2 * k + 2];
      for (int i = 0; i < n / 2; i++) {
        int min = min(a[i], a[n - 1 - i]);
        int max = max(a[i], a[n - 1 - i]);
        prefix[1] += 2;
        prefix[min + 1]--;
        prefix[min + max]--;
        prefix[min + max + 1]++;
        prefix[max + k + 1]++;
      }
      int ans = Integer.MAX_VALUE;
      int sum = 0;
      for (int i = 1; i < prefix.length; i++) {
        sum += prefix[i];
        ans = min(ans, sum);
      }
      out.println(ans);
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
    try (ConstantPalindromeSum instance = new ConstantPalindromeSum()) {
      instance.solve();
    }
  }
}
