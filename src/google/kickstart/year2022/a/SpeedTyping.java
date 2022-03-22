package google.kickstart.year2022.a;

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

public class SpeedTyping implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SpeedTyping() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      char[] a = in.next().toCharArray(), b = in.next().toCharArray();
      int n = a.length, m = b.length;
      boolean possible = n <= m;
      int result = 0;
      if (possible) {
        int i = 0, j = 0;
        while (i < n && j < m) {
          if (a[i] == b[j]) {
            i++;
          } else {
            result++;
          }
          j++;
        }
        if (i < n) {
          possible = false;
        }
        result += (m - j);
      }
      if (possible) {
        out.printf("Case #%d: %d\n", testCase, result);
      } else {
        out.printf("Case #%d: %s\n", testCase, "IMPOSSIBLE");
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
    try (SpeedTyping instance = new SpeedTyping()) {
      instance.solve();
    }
  }
}
