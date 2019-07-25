package codeforces.contests1101_1200.problemset1196;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RobotBreakout implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    final int oo = 100000;
    while (q-- > 0) {
      int n = in.ni();
      int[] x = new int[n], y = new int[n];
      int[][] action = new int[n][4];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        y[i] = in.ni();
        for (int j = 0; j < 4; j++) {
          action[i][j] = in.ni();
        }
      }
      
      int maxX = oo, minX = -oo;
      int maxY = oo, minY = -oo;
      boolean ok = true;
      for (int i = 0; i < n; i++) {
        int mxx = x[i], mnx = x[i];
        int mxy = y[i], mny = y[i];
        //can move left
        if (action[i][0] == 1) {
          mnx = -oo;
        }
        //move right
        if (action[i][2] == 1) {
          mxx = oo;
        }
        //move up
        if (action[i][1] == 1) {
          mxy = oo;
        }
        //move down
        if (action[i][3] == 1) {
          mny = -oo;
        }
        if ((mnx > maxX) || (mxx < minX)) ok = false;
        if ((mny > maxY) || (mxy < minY)) ok = false;
        maxX = Math.min(maxX, mxx);
        minX = Math.max(minX, mnx);
        maxY = Math.min(maxY, mxy);
        minY = Math.max(minY, mny);
      }
      if (ok) {
        out.printf("1 %d %d\n", maxX, maxY);
      } else {
        out.println(0);
      }
    }
  }
  
  private boolean check(int x, int y, int[] action, int[] p) {
    boolean canX = x == p[0] || (x < p[0] && action[2] == 1) || (x > p[0] && action[0] == 1);
    boolean canY = y == p[1] || (y < p[1] && action[1] == 1) || (y > p[1] && action[3] == 1);
    return canX && canY;
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
    try (RobotBreakout instance = new RobotBreakout()) {
      instance.solve();
    }
  }
}
