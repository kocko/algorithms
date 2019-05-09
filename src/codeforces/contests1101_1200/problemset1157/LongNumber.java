package codeforces.contests1101_1200.problemset1157;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongNumber implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] t = in.next().toCharArray();
    int[] number = new int[n];
    for (int i = 0; i < t.length; i++) {
      number[i] = t[i] - '0';
    }
    int[] map = new int[10];
    for (int i = 1; i <= 9; i++) {
      map[i] = in.ni();
    }
    int start = -1;
    for (int i = 0; i < n; i++) {
      if (number[i] < map[number[i]]) {
        start = i;
        break;
      }
    }
    if (start >= 0) {
      for (int i = start; i < n; i++) {
        if (number[i] > map[number[i]]) break;
        number[i] = map[number[i]];
      }
    }
    for (int i = 0; i < n; i++) {
      out.print(number[i]);
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
    try (LongNumber instance = new LongNumber()) {
      instance.solve();
    }
  }
}
