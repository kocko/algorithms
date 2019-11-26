package codeforces.contests301_400.problemset320;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MalekDanceClub implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length;
    final long MOD = (long) 1e9 + 7;
    long p = 1L;
    for (int i = 0; i < n - 1; i++) {
      p = p * 2 % MOD;
    }
    long result = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (x[i] == '1') {
        result = (result + p) % MOD;
      }
      p = p * 2 % MOD;
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
    try (MalekDanceClub instance = new MalekDanceClub()) {
      instance.solve();
    }
  }
}
