package uva.volume104;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SumUpThePrimes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    dp();
    int n, t, testCase = 0;
    while ((n = in.ni()) != 0 | (t = in.ni()) != 0) {
      String result = dp[n][t];
      out.printf("CASE %d:\n", ++testCase);
      out.println(oo.equals(result) ? "No Solution." : result);
    }
  }

  private final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
          97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
          193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293};

  private final String oo = "infinity";
  private String[][] dp = new String[1001][15];

  private void dp() {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = oo;
      }
    }
    dp[0][0] = "";
    for (int n = 2; n < dp.length; n++) {
      for (int remaining = 1; remaining < dp[0].length; remaining++) {
        dp[n][remaining] = oo;
        for (int prime : primes) {
          if (n - prime >= 0 && !oo.equals(dp[n - prime][remaining - 1])) {
            String temp = valid(prime + "+" + dp[n - prime][remaining - 1]);
            if (temp != null && temp.compareTo(dp[n][remaining]) < 0) {
              dp[n][remaining] = temp;
            }
          }
          if (remaining >= 2 && n >= 2 * prime && !oo.equals(dp[n - 2 * prime][remaining - 2])) {
            String temp = valid(prime + "+" + prime + "+" + dp[n - 2 * prime][remaining - 2]);
            if (temp != null && temp.compareTo(dp[n][remaining]) < 0) {
              dp[n][remaining] = temp;
            }
          }
        }
      }
    }
  }

  private String valid(String s) {
    String[] split = s.split("\\+");
    TreeMap<String, Integer> count = new TreeMap<>();
    for (String token : split) {
      count.put(token, count.getOrDefault(token, 0) + 1);
    }
    boolean ok = true;
    StringJoiner result = new StringJoiner("+");
    for (Map.Entry<String, Integer> entry : count.entrySet()) {
      ok &= ("2".equals(entry.getKey()) && entry.getValue() == 1) || (!"2".equals(entry.getKey()) && entry.getValue() <= 2);
      for (int i = 0; i < entry.getValue(); i++) {
        result.add(entry.getKey());
      }
    }
    return ok ? result.toString() : null;
  }

  private void dp2() {
    String[][][] dp = new String[1001][15][primes.length];


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
    try (SumUpThePrimes instance = new SumUpThePrimes()) {
      instance.solve();
    }
  }
}
