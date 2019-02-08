package codeforces.contests801_900.problemset805;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class MinimumNumberOfSteps implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    init();
    int n = x.length, start = n + 1, end = -1;

    for (int i = 0; i < n; i++) {
      if (x[i] == 'a') {
        start = min(start, i);
      } else {
        end = max(end, i);
      }
    }
    if (start > n || end < 0) {
      out.println(0);
      return;
    }
    int current = 0;
    char key = 'a';
    List<Integer> groups = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      if (x[i] == key) {
        current++;
      } else {
        groups.add(current);
        current = 1;
        if (key == 'a') key = 'b';
        else key = 'a';
      }
    }
    groups.add(current);

    int previous = 0;
    long result = 0;
    for (int i = 0; i < groups.size(); i += 2) {
      int a = groups.get(i) + previous, b = groups.get(i + 1);
      previous = a;
      result += f(a, b);
      result %= MOD;
    }
    out.println(result);
  }

  private final long MOD = (long) 1e9 + 7;

  private long[] powers;

  private void init() {
    powers = new long[1000001];
    powers[0] = 1;
    for (int i = 1; i < powers.length; i++) {
      powers[i] = powers[i - 1] * 2;
      powers[i] %= MOD;
    }
  }

  private long f(int a, int b) {
    long k = powers[a] - 1;
    if (k < 0) k += MOD;
    k %= MOD;
    return (b * k) % MOD;
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
    try (MinimumNumberOfSteps instance = new MinimumNumberOfSteps()) {
      instance.solve();
    }
  }
}
