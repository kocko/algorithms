package codeforces.gyms.gym102152;

import java.io.*;
import java.util.StringTokenizer;

public class XorPermutations implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray(), y = in.next().toCharArray(), z = in.next().toCharArray();
      dp = new Integer[10][11][11][11];
      int a = 0, b = 0, c = 0;
      for (int i = 0; i < 10; i++) a += x[i] - '0';
      for (int i = 0; i < 10; i++) b += y[i] - '0';
      for (int i = 0; i < 10; i++) c += z[i] - '0';
      int ans = recurse(0, a, b, c);
      out.println(binary(ans));
    }
  }
  
  private Integer[][][][] dp;
  
  private int recurse(int idx, int x, int y, int z) {
    if (idx == 10) return 0;
    
    if (dp[idx][x][y][z] != null) return dp[idx][x][y][z];
  
    int ans = 0, remaining = 10 - idx;
    int x0 = remaining - x, y0 = remaining - y, z0 = remaining - z;
    for (int mask = 0; mask <= 7; mask++) {
      int xor = xor(mask);
      int x_, y_, z_;
      if ((mask & 1) != 0) {
        x_ = x - 1;
      } else {
        if (x0 == 0) continue;
        x_ = x;
      }
      if ((mask & 2) != 0) {
        y_ = y - 1;
      } else {
        if (y0 == 0) continue;
        y_ = y;
      }
      if ((mask & 4) != 0) {
        z_ = z - 1;
      } else {
        if (z0 == 0) continue;
        z_ = z;
      }
      if (x_ >= 0 && y_ >= 0 && z_ >= 0) {
        ans = Math.max(ans, xor * (1 << idx) + recurse(idx + 1, x_, y_, z_));
      }
    }
    return dp[idx][x][y][z] = ans;
  }
  
  private int xor(int x) {
    int result = 0;
    while (x > 0) {
      result ^= (x & 1);
      x >>= 1;
    }
    return result;
  }
  
  private String binary(int x) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      sb.append(x & 1);
      x >>= 1;
    }
    return sb.reverse().toString();
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
    try (XorPermutations instance = new XorPermutations()) {
      instance.solve();
    }
  }
}
