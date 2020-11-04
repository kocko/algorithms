package codeforces.contests1401_1500.problemset1419;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Decryption implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      List<Integer> divisors = getDivisors(n);
      List<Integer> primes = factorize(n);
      if (divisors.size() == 1) {
        out.println(divisors.get(0));
        out.println(0);
      } else if (primes.size() == 2 && divisors.size() > 3) {
        Set<Integer> d = new HashSet<>(divisors);
        List<Integer> result = new ArrayList<>();
        int p1 = primes.get(0), p2 = primes.get(1);
        result.add(p1);
        result.add(p1 * p2);
        result.add(p2);
        d.remove(p1);
        d.remove(p1 * p2);
        d.remove(p2);
        List<Integer> next = new ArrayList<>();
        for (int d_ : d) {
          if (d_ % p2 == 0 && d_ != n) {
            next.add(d_);
          }
        }
        d.removeAll(next);
        result.addAll(next);
        result.add(n);
        d.remove(n);
        result.addAll(d);
        for (int value : result) {
          out.print(value);
          out.print(' ');
        }
        out.println();
        out.println(0);
      } else if (primes.size() == 2 && divisors.size() == 3) {
        for (int d : divisors) {
          out.print(d);
          out.print(' ');
        }
        out.println();
        out.println(1);
      } else {
        Set<Integer> d = new HashSet<>(divisors);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
          int p1 = primes.get(i);
          int p2 = i == primes.size() - 1 ? primes.get(0) : primes.get(i + 1);
          result.add(p1);
          if (d.contains(p1 * p2)) {
            result.add(p1 * p2);
          }
          d.remove(p1);
          d.remove(p1 * p2);
        }
        for (int idx = 0; idx < result.size(); idx += 2) {
          int prime = result.get(idx);
          out.print(prime);
          out.print(' ');
          List<Integer> divisible = new ArrayList<>();
          for (int number : d) {
            if (number % prime == 0) {
              divisible.add(number);
            }
          }
          d.removeAll(divisible);
          for (int c : divisible) {
            out.print(c);
            out.print(' ');
          }
          if (idx + 1 < result.size()) {
            out.print(result.get(idx + 1));
          }
          out.print(' ');
        }
        out.println("\n" + 0);
      }
    }
  }

  private List<Integer> getDivisors(int n) {
    List<Integer> result = new ArrayList<>();
    for (int d = 1; d * d <= n; d++) {
      if (n % d == 0) {
         if (d > 1) {
           result.add(d);
         }
         if (d * d != n) {
           result.add(n / d);
         }
      }
    }
    return result;
  }

  private List<Integer> factorize(int n) {
    List<Integer> primes = new ArrayList<>();
    for (int d = 2; d * d <= n; d++) {
      if (n % d == 0) {
        primes.add(d);
        while (n % d == 0) {
          n /= d;
        }
      }
    }
    if (n > 1) {
      primes.add(n);
    }
    return primes;
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
    try (Decryption instance = new Decryption()) {
      instance.solve();
    }
  }
}
