package codeforces.contests1101_1200.problemset1118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class YetAnotherBallProblem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    long n = in.nl(), k = in.nl();
    if (k * (k - 1) < n) {
      out.println("NO");
      return;
    }
    int left = 1, right = 2;
    List<int[]> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      result.add(new int[]{left, right});
      i++;
      if (i < n) {
        result.add(new int[]{right++, left});
      }
      if (right == k + 1) {
        left++;
        right = left + 1;
      }
    }
    out.println("YES");
    for (int[] pair : result) {
      out.println(pair[0] + " " + pair[1]);
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
    try (YetAnotherBallProblem instance = new YetAnotherBallProblem()) {
      instance.solve();
    }
  }
}
