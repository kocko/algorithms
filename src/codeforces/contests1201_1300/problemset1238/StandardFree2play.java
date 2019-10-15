package codeforces.contests1201_1300.problemset1238;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StandardFree2play implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      int h = in.ni(), n = in.ni();
      int[] p = new int[n + 1];
      for (int i = 0; i < n; i++) {
        p[i] = in.ni();
      }
      p[n] = 0;
      int crystals = 0, current = h, idx = 1;
      while (current > 0) {
        int next = p[idx], dist = current - next;
        if (dist > 1) {
          if (dist == 2 && next == 0) {
            current = 0;
          } else {
            current = next + 1;
          }
        } else {
          if (next == 0) {
            current = 0;
          } else {
            int jump = next - 1;
            if (jump != p[idx + 1]) {
              crystals++;
            } else {
              idx++;
            }
            current = next - 1;
            idx++;
          }
        }

      }
      out.println(crystals);
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
    try (StandardFree2play instance = new StandardFree2play()) {
      instance.solve();
    }
  }
}
