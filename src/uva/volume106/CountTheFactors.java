package uva.volume106;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CountTheFactors implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    init();
    int n;
    while ((n = in.ni()) != 0) {
      out.println(n + " : " + factors(n));
    }
  }
  
  private int MAX_N = (int) 1e6;
  private int[] sieve = new int[MAX_N + 1];
  
  private void init() {
    for (int i = 0; i <= MAX_N ; i++) {
      sieve[i] = i;
    }
    for (int i = 2; i <= MAX_N; i++) {
      if (sieve[i] == i) {
        for (long j = (long) i * i; j <= MAX_N; j += i) {
          sieve[(int) j] = i;
        }
      }
    }
  }
  
  private int factors(int n) {
    Set<Integer> set = new HashSet<>();
    while (n > 1) {
      set.add(sieve[n]);
      n /= sieve[n];
    }
    return set.size();
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
    try (CountTheFactors instance = new CountTheFactors()) {
      instance.solve();
    }
  }
}
