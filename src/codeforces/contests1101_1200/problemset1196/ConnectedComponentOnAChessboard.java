package codeforces.contests1101_1200.problemset1196;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ConnectedComponentOnAChessboard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      int b = in.ni(), w = in.ni();
      ArrayDeque<int[]> white = new ArrayDeque<>(), left = new ArrayDeque<>(), center = new ArrayDeque<>(), right = new ArrayDeque<>();
      int min = Math.min(w, b), max = Math.max(b, w);
      white.offerLast(new int[]{2, 2});

      center.offerLast(new int[]{2, 1});
      center.offerLast(new int[]{2, 3});
      left.offerLast(new int[]{1, 2});
      right.offerLast(new int[]{3, 2});
      int y = 4, black = 4;
      for (int i = 1; i < min; i++, y += 2, black += 3) {
        white.offerLast(new int[]{2, y});
        center.offerLast(new int[]{2, y + 1});
        left.offerLast(new int[]{1, y});
        right.offerLast(new int[]{3, y});
      }
      while (black > max && left.size() > 0) {
        left.pollLast();
        black--;
      }
      while (black > max && right.size() > 0) {
        right.pollLast();
        black--;
      }
      if (black > max) {
        center.pollLast();
        black--;
      }
      if (black > max) {
        center.pollFirst();
        black--;
      }
      if (black != max) {
        out.println("NO");
        continue;
      }
      int step = w > b ? 1 : 0;
      out.println("YES");
      for (ArrayDeque<int[]> deque : new ArrayDeque[]{white, left, center, right}) {
        for (int[] cell : deque) {
          out.printf("%d %d\n", cell[0] + step, cell[1]);
        }
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
    try (ConnectedComponentOnAChessboard instance = new ConnectedComponentOnAChessboard()) {
      instance.solve();
    }
  }
}
