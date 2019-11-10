package codeforces.contests401_500.problemset478;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RedGreenTower implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    R = in.ni();
    G = in.ni();
    maxHeight();
    out.println(dp());
  }

  private int R, G, H, tower;

  private void maxHeight() {
    int height = 1, total = R + G;
    while (height * (height + 1) <= 2 * total) {
      height++;
    }
    H = height - 1;
    tower = H * (H + 1) / 2;
  }

  private int dp() {
    int[] prev = new int[R + 1];
    for (int red = 0; red <= R; red++) {
      int redUsed = R - red;
      int green = tower - redUsed;
      if (green <= G) {
        prev[red] = 1;
      }
    }
    final int MOD = (int) 1e9 + 7;
    for (int row = 1; row <= H; row++) {
      int[] current = new int[R + 1];
      for (int red = 0; red <= R; red++) {
        if (row <= red) {
          current[red] += prev[red - row];
          current[red] %= MOD;
        }
        current[red] += prev[red];
        current[red] %= MOD;
      }
      prev = current;
    }
    return prev[R];
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
    try (RedGreenTower instance = new RedGreenTower()) {
      instance.solve();
    }
  }
}
