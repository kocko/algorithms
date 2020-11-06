package uva.volume111;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArrangeSomeMarbles implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    dp = new Long[4][4][4][4][8][8][8][8];
    int t = in.ni();
    while (t-- > 0) {
      int[] count = new int[4];
      int d = in.ni(), total = 0;
      for (int i = 0; i < d; i++) {
        count[i] = in.ni();
        total += count[i];
      }
      if (total == 0) {
        out.println(1);
      } else {
        long ans = 0;
        for (int type = 0; type < 4; type++) {
          for (int size = 1; size <= 3; size++) {
            if (size <= count[type]) {
              if (type == 0) {
                ans += recurse(size, type, size, type, count[0] - size, count[1], count[2], count[3]);
              }
              if (type == 1) {
                ans += recurse(size, type, size, type, count[0], count[1] - size, count[2], count[3]);
              }
              if (type == 2) {
                ans += recurse(size, type, size, type, count[0], count[1], count[2] - size, count[3]);
              }
              if (type == 3) {
                ans += recurse(size, type, size, type, count[0], count[1], count[2], count[3] - size);
              }
            }
          }
        }
        out.println(ans);
      }
    }
  }

  private Long[][][][][][][][] dp;

  private long recurse(int firstSize, int firstType, int lastSize, int lastType, int red, int blue, int yellow, int green) {
    if (red + blue + yellow + green == 0) return (lastType == firstType || lastSize == firstSize) ? 0L : 1L;

    if (dp[firstSize][firstType][lastSize][lastType][red][blue][yellow][green] != null) {
      return dp[firstSize][firstType][lastSize][lastType][red][blue][yellow][green];
    }

    long ans = 0;
    for (int type = 0; type < 4; type++) {
      if (type != lastType) {
        for (int size = 1; size <= 3; size++) {
          if (size != lastSize) {
            if (type == 0 && size <= red) {
              ans += recurse(firstSize, firstType, size, type, red - size, blue, yellow, green);
            }
            if (type == 1 && size <= blue) {
              ans += recurse(firstSize, firstType, size, type, red, blue - size, yellow, green);
            }
            if (type == 2 && size <= yellow) {
              ans += recurse(firstSize, firstType, size, type, red, blue, yellow - size, green);
            }
            if (type == 3 && size <= green) {
              ans += recurse(firstSize, firstType, size, type, red, blue, yellow, green - size);
            }
          }
        }
      }
    }
    return dp[firstSize][firstType][lastSize][lastType][red][blue][yellow][green] = ans;
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
    try (ArrangeSomeMarbles instance = new ArrangeSomeMarbles()) {
      instance.solve();
    }
  }
}
