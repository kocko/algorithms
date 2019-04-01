package codeforces.gyms.gym101149;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MathematicalFieldOfExperiments implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int p = in.ni();
    long[] remainder = new long[p];
    for (int i = 0; i < p; i++) {
      remainder[i] = -1;
    }
    for (long i = 0; i < p; i++) {
      long sq = i * i;
      int rem = (int) (sq % p);
      remainder[rem] = i;
    }
    for (int i = 0; i < p; i++) {
      out.print(remainder[i]);
      out.print(' ');
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
    try (MathematicalFieldOfExperiments instance = new MathematicalFieldOfExperiments()) {
      instance.solve();
    }
  }
}
