package google.kickstart.year2022.warmup;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class SampleProblem implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SampleProblem() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }
  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      int n = in.ni(), m = in.ni(), total = 0;
      for (int i = 0; i < n; i++) {
        total += in.ni();
      }
      out.printf("Case #%d: %d\n", testCase, total % m);
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
    try (SampleProblem instance = new SampleProblem()) {
      instance.solve();
    }
  }
}
