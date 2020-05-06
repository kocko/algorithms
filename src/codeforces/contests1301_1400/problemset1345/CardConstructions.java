package codeforces.contests1301_1400.problemset1345;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CardConstructions implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int result = 0;
      int n = in.ni();
      while (n >= 2) {
        int take = calculate(n);
        int cards = 2 * f(take) + f(take - 1);
        n -= cards;
        result++;
      }
      out.println(result);
    }
  }

  private int f(int h) {
    return (int) (h * (h + 1L) / 2L);
  }

  private int calculate(int n) {
    int left = 1, right = n;
    int height = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      long cardsNeeded = 2 * f(mid) + f(mid - 1);
      if (cardsNeeded <= n) {
        height = Math.max(height, mid);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return height;
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
    try (CardConstructions instance = new CardConstructions()) {
      instance.solve();
    }
  }
}
