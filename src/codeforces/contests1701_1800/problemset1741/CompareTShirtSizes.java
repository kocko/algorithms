package codeforces.contests1701_1800.problemset1741;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class CompareTShirtSizes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] a = in.next().toCharArray(), b = in.next().toCharArray();
      int n = a.length, m = b.length;
      char cmp = compare(a[n - 1], b[m - 1]);
      if (cmp == '=') {
        if (a[n - 1] == 'L') {
          if (n > m) {
            cmp = '>';
          } else if (n < m) {
            cmp = '<';
          }
        } else if (a[n - 1] == 'S') {
          if (n > m) {
            cmp = '<';
          } else if (n < m) {
            cmp = '>';
          }
        }
      }
      out.println(cmp);
    }
  }

  private char compare(char a, char b) {
    Map<Character, Integer> score = new HashMap<>();
    score.put('L', 2);
    score.put('M', 1);
    score.put('S', 0);
    if (score.get(a) > score.get(b)) return '>';
    else if (score.get(a) < score.get(b)) return '<';
    return '=';
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
    try (CompareTShirtSizes instance = new CompareTShirtSizes()) {
      instance.solve();
    }
  }
}