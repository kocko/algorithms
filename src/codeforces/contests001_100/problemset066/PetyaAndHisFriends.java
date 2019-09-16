package codeforces.contests001_100.problemset066;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class PetyaAndHisFriends implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    if (n == 2) {
      out.println(-1);
      return;
    }
    long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
                     89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
                     181, 191, 193, 197, 199, 211, 223, 227, 229};
    BigInteger[] result = new BigInteger[n];
    for (int i = 0; i < n; i++) {
      result[i] = BigInteger.valueOf(primes[i]);
    }
    for (int i = 0; i < n; i++) {
      BigInteger prime = BigInteger.valueOf(primes[i]);
      int idx = i;
      for (int j = 0; j < n - 1; j++) {
        result[idx] = result[idx].multiply(prime);
        idx = (idx + 1) % n;
      }
    }
    for (int i = 0; i < n; i++) {
      out.println(result[i]);
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
    try (PetyaAndHisFriends instance = new PetyaAndHisFriends()) {
      instance.solve();
    }
  }
}
