package codeforces.contests1401_1500.problemset1425;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FlamingoesOfMystery implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] result = new int[n];
    int[] query = new int[n];
    query[0] = ask(1, n);
    int sum = 0;
    for (int idx = 1; idx < n - 1; idx++) {
      query[idx] = ask(idx + 1, n);
      result[idx - 1] = query[idx - 1] - query[idx];
      sum += result[idx - 1];
    }
    int q = ask(1, n - 1);
    result[n - 1] = query[0] - q;
    sum += result[n - 1];
    result[n - 2] = query[0] - sum;
    answer(result);
  }

  private int ask(int left, int right) {
    out.printf("? %d %d\n", left, right);
    out.flush();
    return in.ni();
  }

  private void answer(int[] x) {
    out.print("!");
    for (int val : x) {
      out.print(' ');
      out.print(val);
    }
    out.flush();
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
    try (FlamingoesOfMystery instance = new FlamingoesOfMystery()) {
      instance.solve();
    }
  }
}
