package usaco.year2017.january;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HoofPaperScissors implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public HoofPaperScissors() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("hps.in"));
    out = new PrintWriter(new FileOutputStream("hps.out"));
  }

  public void solve() {
    final char[] GESTURES = {'H', 'P', 'S'};
    int n = in.ni();
    char[] gestures = new char[n + 1];
    for (int i = 1; i <= n; i++) {
      gestures[i] = in.next().charAt(0);
    }
    int[][] prefix = new int[3][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 3; j++) {
        prefix[j][i] = prefix[j][i - 1];
      }
      if (gestures[i] == GESTURES[0]) prefix[0][i]++;
      else if (gestures[i] == GESTURES[1]) prefix[1][i]++;
      else if (gestures[i] == GESTURES[2]) prefix[2][i]++;
    }
    int max = 0;
    for (int x = 0; x <= n; x++) {
      for (int first = 0; first < 3; first++) {
        for (int second = 0; second < 3; second++) {
          if (first != second) {
            int p = (first + 1) % 3, q = (second + 1) % 3;
            int score = prefix[p][x] + prefix[q][n] - prefix[q][x];
            if (score > max) {
              max = score;
            }
          }
        }
      }
    }
    out.println(max);
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
    try (HoofPaperScissors instance = new HoofPaperScissors()) {
      instance.solve();
    }
  }
}
