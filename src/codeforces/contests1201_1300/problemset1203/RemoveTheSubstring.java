package codeforces.contests1201_1300.problemset1203;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RemoveTheSubstring implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] s = in.next().toCharArray();
    char[] t = in.next().toCharArray();
    int n = s.length, m = t.length;
    int[] L = new int[m];
    int p = 0;
    for (int i = 0; i < n && p < m; i++) {
      if (s[i] == t[p]) {
        L[p] = i;
        p++;
      }
    }
    int result = n - L[m - 1] - 1;
    p = m - 1;
    for (int i = n - 1; i >= 0 && p >= 0; i--) {
      if (s[i] == t[p]) {
        p--;
        int st = p >= 0 ? L[p] : -1;
        result = Math.max(result, i - st - 1);
      }
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
    try (RemoveTheSubstring instance = new RemoveTheSubstring()) {
      instance.solve();
    }
  }
}
