package timus.volume02;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class PairsOfIntegers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int copy = n;
    while (copy > 0) {
      len++;
      copy /= 10;
    }
    target = new int[len];
    int idx = 0;
    while (n > 0) {
      target[idx++] = n % 10;
      n /= 10;
    }
    a = new int[10];
    b = new int[10];
    recurse(0, 0, ~0);
    out.println(result.size());
    result.forEach(out::println);
  }

  private int len;
  private Set<String> result = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
  private int[] target, a, b;

  private void recurse(int idx, int carry, int up) {
    if (idx == len) {
      if (up == 0 && carry == 0) {
        int limit = len - 1;
        if (a[len - 1] == 0) {
          limit--;
        }
        int n = 0, p = 0, q = 0;
        StringBuilder entry = new StringBuilder();
        for (int i = 0; i < len; i++) {
          entry.append(target[i]);
          n = (n * 10 + target[len - i - 1]);
        }
        entry.append(" = ");
        for (int i = 0; i < limit; i++) {
          entry.append(b[i]);
          p = (p * 10 + b[limit - i - 1]);
        }
        entry.append(" + ");
        for (int i = 0; i < limit + 1; i++) {
          entry.append(a[i]);
          q = (q * 10 + a[limit - i]);
        }
        if (p + q == n) {
          String s = entry.reverse().toString();
          result.add(s);
        }
      }
    } else {
      int digit = target[idx];
      int have = carry;
      if (up != -1) {
        have += up;
        for (int sum : new int[]{digit + 10, digit}) {
          int q = sum - have;
          if (q >= 0 && q < 10) {
            a[idx] = up;
            b[idx] = q;
            recurse(idx + 1, sum / 10, q);
          }
        }
      } else {
        for (int sum : new int[]{digit + 10, digit}) {
          if (sum >= have) {
            int diff = sum - have;
            for (int p = 9; p >= 0; p--) {
              int q = diff - p;
              if (q >= 0 && q < 10) {
                a[idx] = p;
                b[idx] = q;
                if (p == q) {
                  recurse(idx + 1, sum / 10, q);
                  recurse(idx + 1, sum / 10, -1);
                } else {
                  recurse(idx + 1, sum / 10, q);
                }
              }
            }
          }
        }
      }
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
    try (PairsOfIntegers instance = new PairsOfIntegers()) {
      instance.solve();
    }
  }
}
