package usaco.year2016.january;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RadioContact implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public RadioContact() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public RadioContact(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    n = in.ni(); m = in.ni();
    fx = in.ni(); fy = in.ni();
    bx = in.ni(); by = in.ni();
    john = in.next().toCharArray();
    bessie = in.next().toCharArray();
    buildPrefix();
    dp = new Long[n + 1][m + 1];
    out.println(recurse(0, 0));
  }

  private int n, m;
  private int fx, fy, bx, by;
  private char[] john, bessie;
  private int[] prefixJohnX, prefixBessieX;
  private int[] prefixJohnY, prefixBessieY;

  private final Map<Character, int[]> delta = new HashMap<Character, int[]>() {{
    put('N', new int[]{0, 1});
    put('S', new int[]{0, -1});
    put('E', new int[]{1, 0});
    put('W', new int[]{-1, 0});
  }};

  private Long[][] dp;

  private void buildPrefix() {
    prefixJohnX = new int[n + 1];
    prefixJohnY = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      prefixJohnX[i] = prefixJohnX[i - 1];
      prefixJohnY[i] = prefixJohnY[i - 1];
      int[] d = delta.get(john[i - 1]);
      prefixJohnX[i] += d[0];
      prefixJohnY[i] += d[1];
    }

    prefixBessieX = new int[m + 1];
    prefixBessieY = new int[m + 1];
    for (int i = 1; i <= m; i++) {
      prefixBessieX[i] = prefixBessieX[i - 1];
      prefixBessieY[i] = prefixBessieY[i - 1];
      int[] d = delta.get(bessie[i - 1]);
      prefixBessieX[i] += d[0];
      prefixBessieY[i] += d[1];
    }
  }

  private long recurse(int i, int j) {
    if (i > n && j > m) return 0;

    if (dp[i][j] != null) return dp[i][j];

    long ans = Long.MAX_VALUE;

    if (i + 1 <= n) {
      int johnX = fx + prefixJohnX[i + 1];
      int johnY = fy + prefixJohnY[i + 1];
      int bessieX = bx + prefixBessieX[j];
      int bessieY = by + prefixBessieY[j];
      ans = Math.min(ans, dist(johnX, johnY, bessieX, bessieY) + recurse(i + 1, j));
    }
    if (j + 1 <= m) {
      int johnX = fx + prefixJohnX[i];
      int johnY = fy + prefixJohnY[i];
      int bessieX = bx + prefixBessieX[j + 1];
      int bessieY = by + prefixBessieY[j + 1];
      ans = Math.min(ans, dist(johnX, johnY, bessieX, bessieY) + recurse(i, j + 1));
    }
    if (i + 1 <= n && j + 1 <= m) {
      int johnX = fx + prefixJohnX[i + 1];
      int johnY = fy + prefixJohnY[i + 1];
      int bessieX = bx + prefixBessieX[j + 1];
      int bessieY = by + prefixBessieY[j + 1];
      ans = Math.min(ans, dist(johnX, johnY, bessieX, bessieY) + recurse(i + 1, j + 1));
    }

    return dp[i][j] = ans == Long.MAX_VALUE ? 0 : ans;
  }

  private long dist(int x1, int y1, int x2, int y2) {
    long x = x1 - x2, y = y1 - y2;
    return x * x + y * y;
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
    try (RadioContact instance = new RadioContact("radio.in", "radio.out")) {
      instance.solve();
    }
  }
}
