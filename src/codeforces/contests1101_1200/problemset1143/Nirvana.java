package codeforces.contests1101_1200.problemset1143;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Nirvana implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    String x = in.next();
    long result = prod(x.toCharArray());
    for (int i = 0; i < x.length(); i++) {
      char[] copy = x.toCharArray();
      if (copy[i] != '0') {
        copy[i]--;
        for (int j = i + 1; j < copy.length; j++) {
          copy[j] = '9';
        }
        int value = Integer.parseInt(new String(copy));
        result = Math.max(result, prod(String.valueOf(value).toCharArray()));
      }
    }
    out.println(result);
  }
  
  private int prod(char[] x) {
    int result = 1;
    for (char c : x) {
      result *= (c - '0');
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
    try (Nirvana instance = new Nirvana()) {
      instance.solve();
    }
  }
}
