package codeforces.gyms.gym100694;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class DidHeDropAnyGoodLoot implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int m = in.ni();
    price = new int[n + 1];
    weight = new int[n + 1];
    power = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      price[i] = in.ni();
      weight[i] = in.ni();
      power[i] = in.ni();
    }
    dp = new int[n + 1][702][3];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= 701; j++) {
        for (int k = 0; k < 3; k++) {
          dp[i][j][k] = -1;
        }
      }
    }
    out.println(recurse(n, m + 200, 2));
  }

  private int[] price, weight, power;
  private int[][][] dp;

  private int recurse(int idx, int remaining, int active) {
    if (idx == 0) {
      if (remaining >= 200) return 0;
      return (int) -1e9;
    }
    if (dp[idx][remaining][active] != -1) return dp[idx][remaining][active];
    
    int ans = recurse(idx - 1, remaining, active);
    if (remaining >= weight[idx]) {
      ans = max(ans, price[idx] + recurse(idx - 1, remaining - weight[idx], active));
    }
    if (active > 0 && remaining >= weight[idx] - power[idx]) {
      ans = max(ans, price[idx] + recurse(idx - 1, remaining - weight[idx] + power[idx], active - 1));
    }
    return dp[idx][remaining][active] = ans;
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
    try (DidHeDropAnyGoodLoot instance = new DidHeDropAnyGoodLoot()) {
      instance.solve();
    }
  }
}
