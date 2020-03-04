package codeforces.contests1301_1400.problemset1311;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Math.abs;

public class ThreeIntegers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int a = in.ni(), b = in.ni(), c = in.ni();
      int result = 10000;
      int best_a = a, best_b = b, best_c = c;
      for (int second = 1; second <= 12000; second++) {
        List<Integer> divisors = divisors(second);
        int first = 1, cost_a = abs(a - 1);
        for (int divisor : divisors) {
          int cost = abs(divisor - a);
          if (cost < cost_a) {
            cost_a = cost;
            first = divisor;
          }
        }
        int third = second, cost_c = abs(c - third);
        int multiplier = 2;
        while (true) {
          int dst = abs(multiplier * second - c);
          int prev = abs((multiplier - 1) * second - c);
          if (dst < prev) {
            cost_c = dst;
            third = multiplier * second;
            multiplier++;
          } else break;
        }
        int cost = cost_a + abs(second - b) + cost_c;
        if (cost < result) {
          result = cost;
          best_a = first;
          best_b = second;
          best_c = third;
        }
      }
      out.println(result);
      out.println(best_a + " " + best_b + " " + best_c);
    }
  }

  private List<Integer> divisors(int x) {
    Set<Integer> result = new TreeSet<>();
    for (int d = 1; d * d <= x; d++) {
      if (x % d == 0) {
        result.add(d);
        result.add(x / d);
      }
    }
    return new ArrayList<>(result);
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
    try (ThreeIntegers instance = new ThreeIntegers()) {
      instance.solve();
    }
  }
}
