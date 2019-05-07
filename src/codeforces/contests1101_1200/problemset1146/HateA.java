package codeforces.contests1101_1200.problemset1146;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HateA implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int other = 0, n = x.length;
    StringBuilder compressed = new StringBuilder();
    for (char c : x) {
      if (c != 'a') {
        other++;
        compressed.append(c);
      }
    }
    boolean possible = other % 2 == 0;
    for (int i = 0; i < other / 2; i++) {
      possible &= compressed.charAt(i) == compressed.charAt(i + other / 2);
    }
    String result = ":(";
    if (possible) {
      int idx = n - 1;
      int copy = 0;
      while (x[idx] != 'a' && copy * 2 < other) {
        idx--;
        copy++;
      }
      if (copy * 2 == other) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i <= idx; i++) {
          tmp.append(x[i]);
        }
        result = tmp.toString();
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
    try (HateA instance = new HateA()) {
      instance.solve();
    }
  }
}
