package codeforces.contests301_400.problemset359;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class PrimeNumber implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long prime = in.nl();
    long sum = 0;
    List<Long> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      long next = in.nl();
      a.add(next);
      sum += next;
    }
    Map<Long, Long> count = new HashMap<>();
    for (long p : a) {
      long power = sum - p;
      long cnt = count.getOrDefault(power, 0L);
      while (cnt + 1 == prime) {
        count.remove(power);
        power++;
        cnt = count.getOrDefault(power, 0L);
      }
      count.put(power, count.getOrDefault(power, 0L) + 1);
    }
    long min = Long.MAX_VALUE;
    for (Map.Entry<Long, Long> entry : count.entrySet()) {
      min = Math.min(min, entry.getKey());
    }
    long power = Math.min(min, sum);
    out.println(fastPower(prime, power));
  }

  private long fastPower(long prime, long power) {
    if (power == 0) return 1;
    if (power == 1) return prime;

    final int MOD = (int) 1e9 + 7;

    long half = fastPower(prime, power / 2);
    long result = half * half % MOD;
    if (power % 2 == 1) {
      result *= prime;
      result %= MOD;
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
    try (PrimeNumber instance = new PrimeNumber()) {
      instance.solve();
    }
  }
}
