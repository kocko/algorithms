package codeforces.contests1501_1600.problemset1520;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class ArrangingTheSheep implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public ArrangingTheSheep() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray();
      long[] prefix = new long[n];
      int sheep = x[0] == '*' ? 1 : 0;
      prefix[0] = 0;
      for (int i = 1; i < n; i++) {
        if (x[i] == '.') {
          prefix[i] = prefix[i - 1] + sheep;
        } else {
          prefix[i] = prefix[i - 1];
          sheep++;
        }
      }
      long[] suffix = new long[n];
      sheep = x[n - 1] == '*' ? 1 : 0;
      suffix[n - 1] = 0;
      for (int i = n - 2; i >= 0; i--) {
        if (x[i] == '.') {
          suffix[i] = suffix[i + 1] + sheep;
        } else {
          suffix[i] = suffix[i + 1];
          sheep++;
        }
      }
      long result = Math.min(suffix[0], prefix[n - 1]);
      for (int i = 1; i < n - 1; i++) {
        result = Math.min(result, prefix[i] + suffix[i + 1]);
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
    try (ArrangingTheSheep instance = new ArrangingTheSheep()) {
      instance.solve();
    }
  }
}
