package codeforces.contests1101_1200.problemset1165;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class TwoArraysAndSumOfFunctions implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<Long> a = new ArrayList<>(), b = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      long next = in.nl() * (i + 1) * (n - i);
      a.add(next);
    }
    a.sort(Comparator.naturalOrder());
    for (int i = 0; i < n; i++) {
      b.add(in.nl());
    }
    b.sort(Comparator.reverseOrder());
    final int MOD = 998244353;
    long result = 0;
    for (int i = 0; i < n; i++) {
      result += (a.get(i) % MOD) * b.get(i);
      result %= MOD;
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
    try (TwoArraysAndSumOfFunctions instance = new TwoArraysAndSumOfFunctions()) {
      instance.solve();
    }
  }
}
