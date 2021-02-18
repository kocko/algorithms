package codeforces.contests1401_1500.problemset1486;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EasternExhibition implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        y[i] = in.ni();
      }
      Arrays.sort(x);
      Arrays.sort(y);
      long h, v;
      if (n == 1) {
        h = 1;
        v = 1;
      } else if (n == 2) {
        h = x[1] - x[0] + 1;
        v = y[1] - y[0] + 1;
      } else {
        if (n % 2 == 0) {
          h = x[n / 2] - x[n / 2 - 1] + 1;
          v = y[n / 2] - y[n / 2 - 1] + 1;
        } else {
          h = v = 1;
        }
      }
      out.println(h * v);
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
    try (EasternExhibition instance = new EasternExhibition()) {
      instance.solve();
    }
  }
}
