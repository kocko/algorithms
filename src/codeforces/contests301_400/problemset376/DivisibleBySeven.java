package codeforces.contests301_400.problemset376;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DivisibleBySeven implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final String[] perm = {"1869", "6198", "1896", "9186", "9168", "6189", "8691"};
    char[] x = in.next().toCharArray();
    int[] cnt = new int[10];
    for (char c : x) {
      cnt[c - '0']++;
    }
    for (int i : new int[]{1, 6, 8, 9}) {
      cnt[i]--;
    }
    int rem = 0;
    for (int i = 1; i < 10; i++) {
      while (cnt[i] > 0) {
        out.print(i);
        rem = rem * 10 + i;
        rem %= 7;
        cnt[i]--;
      }
    }
    out.print(perm[rem]);
    while (cnt[0] > 0) {
      out.print(0);
      cnt[0]--;
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
    try (DivisibleBySeven instance = new DivisibleBySeven()) {
      instance.solve();
    }
  }
}
