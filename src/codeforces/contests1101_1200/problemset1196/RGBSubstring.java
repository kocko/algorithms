package codeforces.contests1101_1200.problemset1196;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class RGBSubstring implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      n = in.ni();
      k = in.ni(); 
      char[] x = in.next().toCharArray();
      out.println(min(min(check(x, "RGB".toCharArray()), check(x, "GBR".toCharArray())), check(x, "BRG".toCharArray())));
    }
  }
  
  private int n, k;

  private int check(char[] x, char[] y) {
    int result = 0;
    for (int i = 0; i < k; i++) {
      if (x[i] != y[i % 3]) {
        result++;
      }
    }
    int ans = result;
    for (int i = k; i < n; i++) {
      if (x[i - k] != y[(i - k) % 3]) result--;
      if (x[i] != y[i % 3]) result++;
      ans = Math.min(ans, result);
    }
    return ans;
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
    try (RGBSubstring instance = new RGBSubstring()) {
      instance.solve();
    }
  }
}
