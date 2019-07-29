package codeforces.contests1101_1200.problemset1194;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FromSToT implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int tests = in.ni();
    while (tests-- > 0) {
      char[] s = in.next().toCharArray(), t = in.next().toCharArray(), p = in.next().toCharArray();
      boolean ok = s.length <= t.length;
      if (s.length == t.length) {
        for (int i = 0; i < s.length; i++) {
          ok &= s[i] == t[i];
        }
      } else if (s.length < t.length) {
        int[] cnt = new int[26];
        for (char c : p) {
          cnt[c - 'a']++;
        }
        int i = 0, j = 0;
        while (j < t.length) {
          char c = i < s.length ? s[i] : '?';
          if (c != t[j]) {
            ok &= --cnt[t[j] - 'a'] >= 0;
          } else {
            i++;
          }
          j++;
        }
        ok &= i == s.length;
      }
      out.println(ok ? "yes" : "no");
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
    try (FromSToT instance = new FromSToT()) {
      instance.solve();
    }
  }
}
