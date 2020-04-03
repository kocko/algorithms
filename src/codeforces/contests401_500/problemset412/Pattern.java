package codeforces.contests401_500.problemset412;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Pattern implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] result = in.next().toCharArray();
    boolean[] blocked = new boolean[result.length];
    for (int i = 0; i < n - 1; i++) {
      char[] next = in.next().toCharArray();
      for (int j = 0; j < next.length; j++) {
        if (next[j] == '?') continue;
        if (result[j] == '?') {
          if (!blocked[j]) {
            result[j] = next[j];
          }
        } else {
          if (result[j] != next[j]) {
            result[j] = '?';
            blocked[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < result.length; i++) {
      if (result[i] == '?' && !blocked[i]) {
        result[i] = 'a';
      }
      out.print(result[i]);
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
    try (Pattern instance = new Pattern()) {
      instance.solve();
    }
  }
}
