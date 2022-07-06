package codeforces.contests1601_1700.problemset1676;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MostSimilarWords implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), m = in.ni();
      char[][] words = new char[n][m];
      for (int i = 0; i < n; i++) {
        words[i] = in.next().toCharArray();
      }
      int result = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          result = min(result, diff(words[i], words[j]));
        }
      }
      out.println(result);
    }
  }

  private int diff(char[] a, char[] b) {
    int result = 0;
    for (int i = 0; i < a.length; i++) {
      result += abs(a[i] - b[i]);
    }
    return result;
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
    try (MostSimilarWords instance = new MostSimilarWords()) {
      instance.solve();
    }
  }
}