package codeforces.contests1201_1300.problemset1203;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EqualRectangles implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      final int MAX_A = 10000;
      int min = MAX_A + 5, max = 0;
      int[] count = new int[MAX_A + 1];
      for (int i = 0; i < 4 * n; i++) {
        int next = in.ni();
        max = Math.max(max, next);
        min = Math.min(min, next);
        count[next]++;
      }
      boolean possible = true;
      int area = min * max;
      for (int a = 1; a <= MAX_A ; a++) {
        if (area % a != 0 && count[a] > 0) {
          possible = false;
        }
        if (area % a == 0 && count[a] > 0) {
          int b = area / a;
          possible &= count[a] == count[b];
          possible &= count[a] % 2 == 0 && count[b] % 2 == 0;
        }
      }
      out.println(possible ? "YES" : "NO");
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
    try (EqualRectangles instance = new EqualRectangles()) {
      instance.solve();
    }
  }
}
