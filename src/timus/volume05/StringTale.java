package timus.volume05;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StringTale implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    String s = in.next(), t = in.next();
    char[] x = (t + "#" + s + s).toCharArray();
    int[] prefix = new int[x.length];
    int k = 0;
    for (int i = 1; i < x.length; i++) {
      while (k > 0 && x[i] != x[k]) {
        k = prefix[k - 1];
      }
      if (x[i] == x[k]) {
        k++;
      }
      prefix[i] = k;
    }
    int result = -1;
    for (int i = n + 1; i < x.length; i++) {
      if (prefix[i] == n) {
        result = x.length - i - 1;
        break;
      }
    }
    if (result == n) {
      result = 0;
    }
    out.println(result);
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
    try (StringTale instance = new StringTale()) {
      instance.solve();
    }
  }
}
