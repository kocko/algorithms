package google.kickstart.year2020.c;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CandiesEasy implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public CandiesEasy() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      n = in.ni();
      int q = in.ni();
      x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      long result = 0;
      buildPrefix();
      while (q-- > 0) {
        char type = in.next().charAt(0);
        if (type == 'U') {
          int idx = in.ni(), value = in.ni();
          x[idx - 1] = value;
          buildPrefix();
        } else {
          int left = in.ni(), right = in.ni();
          long score = sweetness[right] - sweetness[left - 1] - (left - 1) * (prefix[right] - prefix[left - 1]);
          if (left % 2 == 0) {
            score *= -1L;
          }
          result += score;
        }
      }
      out.printf("Case #%d: %d\n", testCase, result);
    }
  }

  private int n;
  private long[] x;
  private long[] prefix;
  private long[] sweetness;

  private void buildPrefix() {
    prefix = new long[n + 1];
    sweetness = new long[n + 1];
    long multiplier = 1L;
    for (int i = 1; i <= n; i++, multiplier *= -1) {
      prefix[i] = prefix[i - 1] + x[i - 1] * multiplier;
      sweetness[i] = sweetness[i - 1] + i * x[i - 1] * multiplier;
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
    try (CandiesEasy instance = new CandiesEasy()) {
      instance.solve();
    }
  }
}
