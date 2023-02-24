package atcoder.beginner.contest269;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class LastRook implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public LastRook() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    int row = findRow(n);
    int col = findCol(n);
    answer(row, col);
  }

  private int ask(int a, int b, int c, int d) {
    out.printf("? %d %d %d %d\n", a, b, c, d);
    out.flush();
    return in.ni();
  }

  private void answer(int x, int y) {
    out.printf("! %d %d\n", x, y);
    out.flush();
  }

  private int findRow(int n) {
    int left = 1, right = n;
    int result = n + 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int count = ask(1, mid, 1, n);
      if (count < mid) {
        result = min(result, mid);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return result;
  }

  private int findCol(int n) {
    int left = 1, right = n;
    int result = n + 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int count = ask(1, n, 1, mid);
      if (count < mid) {
        result = min(result, mid);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return result;
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
    try (LastRook instance = new LastRook()) {
      instance.solve();
    }
  }
}
