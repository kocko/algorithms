package codeforces.contests1301_1400.problemset1360;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SpyString implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      char[][] x = new char[n][m];
      for (int i = 0; i < n; i++) {
        x[i] = in.next().toCharArray();
      }
      List<char[]> list = new ArrayList<>();
      list.add(x[0]);
      for (int pos = 0; pos < m; pos++) {
        for (char c = 'a'; c <= 'z'; c++) {
          char[] entry = new char[m];
          System.arraycopy(x[0], 0, entry, 0, m);
          entry[pos] = c;
          list.add(entry);
        }
      }
      char[] ans = null;
      for (char[] candidate : list) {
        boolean ok = true;
        for (int idx = 1; idx < n; idx++) {
          ok &= diff(candidate, x[idx]) <= 1;
        }
        if (ok) {
          ans = candidate;
          break;
        }
      }
      if (ans == null) {
        out.println("-1");
      } else {
        for (int i = 0; i < m; i++) {
          out.print(ans[i]);
        }
        out.println();
      }
    }
  }

  private int diff(char[] a, char[] b) {
    int n = a.length, diff = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] != b[i]) {
        diff++;
      }
    }
    return diff;
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
    try (SpyString instance = new SpyString()) {
      instance.solve();
    }
  }
}
