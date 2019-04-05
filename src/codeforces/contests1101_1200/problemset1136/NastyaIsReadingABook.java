package codeforces.contests1101_1200.problemset1136;

import java.io.*;
import java.util.StringTokenizer;

public class NastyaIsReadingABook implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] start = new int[n], end = new int[n];
    for (int i = 0; i < n; i++) {
      start[i] = in.ni();
      end[i] = in.ni();
    }
    int p = in.ni(), completed = 0;
    for (int i = 0; i < n; i++) {
      if (end[i] < p) completed++;
    }
    out.println(n - completed);
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
    try (NastyaIsReadingABook instance = new NastyaIsReadingABook()) {
      instance.solve();
    }
  }
}
