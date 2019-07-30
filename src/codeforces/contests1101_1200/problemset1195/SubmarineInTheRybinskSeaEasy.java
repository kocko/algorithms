package codeforces.contests1101_1200.problemset1195;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SubmarineInTheRybinskSeaEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final long MOD = 998244353L;
    int n = in.ni();
    List<List<Long>> buckets = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      buckets.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      long next = in.nl();
      int idx = 0;
      while (next > 0) {
        long value = next % 10;
        buckets.get(idx).add(value);
        next /= 10;
        idx++;
      }
    }
    long sum = 0, power = 1L;
    for (int idx = 0; idx < 10; idx++, power *= 100) {
      List<Long> bucket = buckets.get(idx);
      long count = bucket.size();
      long p = power % MOD;
      for (long value : bucket) {
        sum += value * count * p;
        sum %= MOD;
        sum += value * count * p * 10;
        sum %= MOD;
      }
    }
    out.println(sum);
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
    try (SubmarineInTheRybinskSeaEasy instance = new SubmarineInTheRybinskSeaEasy()) {
      instance.solve();
    }
  }
}
