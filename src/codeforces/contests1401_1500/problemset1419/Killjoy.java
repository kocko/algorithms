package codeforces.contests1401_1500.problemset1419;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Killjoy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), x = in.ni();
      int[] rating = new int[n];
      for (int i = 0; i < n; i++) {
        rating[i] = in.ni();
      }
      int same = 0, sum = 0;
      for (int i = 0; i < n; i++) {
        sum += (x - rating[i]);
        if (x == rating[i]) {
          same++;
        }
      }
      if (same == n) {
        out.println(0);
      } else {
        out.println((same > 0 || sum == 0) ? 1 : 2);
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
    try (Killjoy instance = new Killjoy()) {
      instance.solve();
    }
  }
}
