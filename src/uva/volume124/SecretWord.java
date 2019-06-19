package uva.volume124;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SecretWord implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] next = in.next().toCharArray();
      int n = next.length;
      char[] x = new char[2 * n + 1];
      for (int i = 0; i < n; i++) {
        x[i] = x[2 * n - i] = next[i];
      }
      x[n] = '#';
      int[] prefix = new int[2 * n + 1];
      int k = 0;
      for (int i = 1; i < 2 * n + 1; i++) {
        while (k > 0 && x[i] != x[k]) {
          k = prefix[k - 1];
        }
        if (x[i] == x[k]) {
          k++;
        }
        prefix[i] = k;
      }
      int max = 0, index = -1;
      for (int i = n + 1; i < 2 * n + 1; i++) {
        if (prefix[i] > max) {
          index = i;
          max = prefix[i];
        }
      }
      for (int i = index; i > index - max; i--) {
        out.print(x[i]);
      }
      out.println();
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
    try (SecretWord instance = new SecretWord()) {
      instance.solve();
    }
  }
}
