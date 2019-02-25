package codeforces.contests1101_1200.problemset1130;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class TwoCakes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[][] data = new int[n][2];
    for (int i = 0; i < 2 * n; i++) {
      int next = in.ni() - 1;
      if (data[next][0] == 0) {
        data[next][0] = i;
      } else {
        data[next][1] = i;
      }
    }
    int s = 0, d = 0;
    long result = 0;
    for (int i = 0; i < n; i++) {
      int s1 = abs(data[i][0] - s), s2 = abs(data[i][1] - s);
      int d1 = abs(data[i][0] - d), d2 = abs(data[i][1] - d);
      if (s1 + d2 < s2 + d1) {
        result += s1 + d2;
        s = data[i][0];
        d = data[i][1];
      } else {
        result += s2 + d1;
        s = data[i][1];
        d = data[i][0];
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
    try (TwoCakes instance = new TwoCakes()) {
      instance.solve();
    }
  }
}
