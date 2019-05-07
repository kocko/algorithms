package codeforces.contests1101_1200.problemset1162;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HideAndSeek implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    int[] first = new int[n + 1], last = new int[n + 1];
    for (int i = 1; i <= k; i++) {
      int next = in.ni();
      if (first[next] == 0) {
        first[next] = i;
      }
      last[next] = i;
    }
    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (first[i] == 0) {
        if (i == 1 || i == n) result += 2;
        else result += 3;
      }
      if (i >= 2 && last[i - 1] < first[i]) result++;
      if (i <= n - 1 && last[i + 1] < first[i]) result++;
    }
    out.println(result);
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
    try (HideAndSeek instance = new HideAndSeek()) {
      instance.solve();
    }
  }
}
