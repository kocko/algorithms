package codeforces.contests1201_1300.problemset1216;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WhiteSheet implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    for (int i = 1; i <= 6; i++) {
      x[i] = in.ni() * 2;
      y[i] = in.ni() * 2;
    }
    boolean black = true;
    for (int col = x[1]; col <= x[2]; col++) {
      if (!within(col, y[1], y[2], 3, 4)) {
        if (crosses(col, y[1], y[2], 3, 4)) {
          black &= within(col, y[1], y[3], 5, 6);
          black &= within(col, y[4], y[2], 5, 6);
        } else if (intersects(col, y[1], y[2], 3, 4)) {
          if (y[2] >= y[3] && y[2] <= y[4]) {
            black &= within(col, y[1], y[3], 5, 6);
          } else {
            black &= within(col, y[4], y[2], 5, 6);
          }
        } else {
          black &= within(col, y[1], y[2], 5, 6);
        }
      }
    }
    out.println(black ? "NO" : "YES");
  }

  private int[] x = new int[7], y = new int[7];

  private boolean crosses(int col, int y1, int y2, int leftIdx, int rightIdx) {
    boolean a = col >= x[leftIdx] && col <= x[rightIdx];
    boolean b = y1 < y[leftIdx] && y2 > y[rightIdx];
    return a && b;
  }

  private boolean within(int col, int y1, int y2, int leftIdx, int rightIdx) {
    return col >= x[leftIdx] && col <= x[rightIdx] && y1 >= y[leftIdx] && y1 <= y[rightIdx] && y2 >= y[leftIdx] && y2 <= y[rightIdx];
  }

  private boolean intersects(int col, int y1, int y2, int leftIdx, int rightIdx) {
    boolean a = col >= x[leftIdx] && col <= x[rightIdx];
    boolean b = y1 < y[leftIdx] && (y2 >= y[leftIdx] && y2 <= y[rightIdx]);
    boolean c = y2 > y[rightIdx] && (y1 >= y[leftIdx] && y1 <= y[rightIdx]);
    return a && (b || c);
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
    try (WhiteSheet instance = new WhiteSheet()) {
      instance.solve();
    }
  }
}
