package uva.volume116;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class BurgerTime implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n;
    while ((n = in.ni()) != 0) {
      char[] x = in.next().toCharArray();
      int result = 2000005;
      int last = -1;
      for (int i = 0; i < n; i++) {
        if (x[i] == 'Z') result = 0;
        else if (x[i] == 'D') {
          last = i;
        } else if (x[i] == 'R') {
          if (last != -1) {
            result = min(result, i - last);
          }
        }
      }
      last = n;
      for (int i = n - 1; i >= 0; i--) {
        if (x[i] == 'D') {
          last = i;
        } else if (x[i] == 'R') {
          if (last != n) {
            result = min(result, last - i);
          }
        }
      }
      out.println(result);
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
    try (BurgerTime instance = new BurgerTime()) {
      instance.solve();
    }
  }
}
