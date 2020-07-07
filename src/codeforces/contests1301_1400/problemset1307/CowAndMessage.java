package codeforces.contests1301_1400.problemset1307;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowAndMessage implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    long max = 0;
    for (char p = 'a'; p <= 'z'; p++) {
      for (char q = 'a'; q <= 'z'; q++) {
        if (p != q) {
          int ps = 0;
          long pairs = 0;
          for (char ch : x) {
            if (ch == p) {
              ps++;
            } else if (ch == q) {
              pairs += ps;
            }
          }
          if (pairs > max) {
            max = pairs;
          }
        } else {
          int ps = 0;
          long pairs = 0;
          for (char ch : x) {
            if (ch == p) {
              pairs += ps;
              ps++;
            }
          }
          if (pairs > max) {
            max = pairs;
          }
        }
      }
    }
    for (char c = 'a'; c <= 'z'; c++) {
      int cnt = 0;
      for (char ch : x) {
        if (ch == c) {
          cnt++;
        }
      }
      if (cnt > max) {
        max = cnt;
      }
    }
    out.println(max);
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
    try (CowAndMessage instance = new CowAndMessage()) {
      instance.solve();
    }
  }
}
