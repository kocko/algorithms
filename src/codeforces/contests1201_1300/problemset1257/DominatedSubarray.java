package codeforces.contests1201_1300.problemset1257;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DominatedSubarray implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), result = Integer.MAX_VALUE;
      int[] last = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        last[i] = -1;
      }
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        if (last[next] != -1) {
          result = Math.min(result, i - last[next] + 1);
        }
        last[next] = i;
      }
      out.println(result == Integer.MAX_VALUE ? -1 : result);
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
    try (DominatedSubarray instance = new DominatedSubarray()) {
      instance.solve();
    }
  }
}
