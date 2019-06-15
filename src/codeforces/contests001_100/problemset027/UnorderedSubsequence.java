package codeforces.contests001_100.problemset027;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UnorderedSubsequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long[] x = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      x[i] = in.nl();
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 3; i <= n; i++) {
      if ((x[i] - x[i - 1]) * (x[i - 1] - x[1]) < 0) {
        result.add(1);
        result.add(i - 1);
        result.add(i);
        break;
      }
    }
    out.println(result.size());
    for (int idx : result) {
      out.print(idx);
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
    try (UnorderedSubsequence instance = new UnorderedSubsequence()) {
      instance.solve();
    }
  }
}
