package codeforces.contests1201_1300.problemset1272;

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

public class SnowWalkingRobot implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public SnowWalkingRobot() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] x = in.next().toCharArray();
      int u = 0, d = 0, l = 0, r = 0;
      for (char c : x) {
        if (c == 'U') u++;
        if (c == 'D') d++;
        if (c == 'L') l++;
        if (c == 'R') r++;
      }
      int v = min(u, d);
      int h = min(l, r);
      if (h == 0) {
        int ans = min(1, v);
        out.println(2 * ans);
        for (int i = 0; i < ans; i++) out.print('U');
        for (int i = 0; i < ans; i++) out.print('D');
        out.println();
      } else if (v == 0) {
        int ans = min(1, h);
        out.println(2 * ans);
        for (int i = 0; i < ans; i++) out.print('L');
        for (int i = 0; i < ans; i++) out.print('R');
        out.println();
      } else {
        out.println(2 * (h + v));
        for (int i = 0; i < v; i++) out.print('U');
        for (int i = 0; i < h; i++) out.print('L');
        for (int i = 0; i < v; i++) out.print('D');
        for (int i = 0; i < h; i++) out.print('R');
        out.println();
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
    try (SnowWalkingRobot instance = new SnowWalkingRobot()) {
      instance.solve();
    }
  }
}
