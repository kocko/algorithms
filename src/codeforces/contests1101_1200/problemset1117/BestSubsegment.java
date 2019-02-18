package codeforces.contests1101_1200.problemset1117;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BestSubsegment implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), max = 0;
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      if (x[i] > max) max = x[i];
    }
    int result = 0, current = 0;
    for (int i = 0; i < n; i++) {
      if (x[i] == max) {
        current++;
      } else {
        result = Math.max(result, current);
        current = 0;
      }
    }
    out.println(Math.max(result, current));
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
    try (BestSubsegment instance = new BestSubsegment()) {
      instance.solve();
    }
  }
}
