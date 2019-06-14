package codeforces.contests1101_1200.problemset1176;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RecoverIt implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[2 * n];
    int[] count = new int[MAX_PRIME + 1];
    for (int i = 0; i < x.length; i++) {
      x[i] = in.ni();
      count[x[i]]++;
    }
    sieve();
    Arrays.sort(x);
    int[] result = new int[n];
    int idx = 0;
    for (int i = x.length - 1; i >= 0; i--) {
      if (!prime[x[i]] && count[x[i]] > 0) {
        int divisor = findGreatestDivisor(x[i]);
        result[idx++] = x[i];
        count[x[i]]--;
        count[divisor]--;
      }
    }
    for (int num : x) {
      if (prime[num] && count[num] > 0) {
        int ord = primes.get(num);
        result[idx++] = num;
        count[num]--;
        count[ord]--;
      }
    }
    for (int num : result) {
      out.print(num);
      out.print(' ');
    }
  }
  
  private final int MAX_PRIME = 2750131;
  private boolean[] prime = new boolean[MAX_PRIME + 5];
  
  private List<Integer> primes = new ArrayList<>();
  
  private void sieve() {
    Arrays.fill(prime, true);
    primes.add(1);
    for (int i = 2; i < prime.length; i++) {
      if (prime[i]) {
        primes.add(i);
        for (int j = i + i; j < prime.length; j += i) {
          prime[j] = false;
        }
      }
    }
  }
  
  private int findGreatestDivisor(int x) {
    for (int i = 1; i < primes.size(); i++) {
      int prime = primes.get(i);
      if (x % prime == 0) {
        return x / prime;
      }
    }
    return -1;
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
    try (RecoverIt instance = new RecoverIt()) {
      instance.solve();
    }
  }
}
