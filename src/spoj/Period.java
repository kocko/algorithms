package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Period implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      int n = in.ni();
      char[] x = in.next().toCharArray();

      out.printf("Test case #%d\n", testCase);
      int[] prefix = new int[n];
      int k = 0;
      for (int i = 1; i < n; i++) {
        while (k > 0 && x[i] != x[k]) {
          k = prefix[k - 1];
        }
        if (x[i] == x[k]) {
          k++;
        }
        prefix[i] = k;
        if (k > 0 && (i + 1) % (i + 1 - k) == 0) {
          out.printf("%d %d\n", i + 1, (i + 1) / (i + 1 - k));
        }
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
    try (Period instance = new Period()) {
      instance.solve();
    }
  }
}
