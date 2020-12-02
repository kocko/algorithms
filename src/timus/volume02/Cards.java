package timus.volume02;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cards implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    int[] x = new int[m];
    for (int i = 0; i < m; i++) {
      x[i] = in.ni();
    }
    Arrays.sort(x);
    boolean possible = true;
    int[] count = new int[n];
    for (int value : x) {
      if (value == 0) {
        if (count[0] > 0) {
          possible = false;
        } else {
          count[0] = 1;
        }
      } else if (value == n) {
        if (count[value - 1] > 0) {
          possible = false;
        } else {
          count[value - 1]++;
        }
      } else {
        if (count[value - 1] > 0) {
          if (count[value] > 0) {
            possible = false;
          } else {
            count[value] = 1;
          }
        } else {
          count[value - 1] = 1;
        }
      }
    }
    out.println(possible ? "YES" : "NO");
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
    try (Cards instance = new Cards()) {
      instance.solve();
    }
  }
}
