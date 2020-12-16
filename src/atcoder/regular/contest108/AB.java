package atcoder.regular.contest108;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AB implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final long MOD = (long) 1e9 + 7;
    int n = in.ni();
    int aa = in.next().charAt(0) - 'A';
    int ab = in.next().charAt(0) - 'A';
    int ba = in.next().charAt(0) - 'A';
    int bb = in.next().charAt(0) - 'A';
    if ((ab == 0 && aa == 0) || (ab == 1 && bb == 1)) {
      out.println(1);
    } else {
      if (ab == ba) {
        long[] fib = new long[n + 1];
        fib[0] = fib[1] = 1;
        for (int i = 2; i <= n; i++) {
          fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        }
        out.println(fib[n - 2]);
      } else {
        long ans = 1;
        for (int i = 0; i < n - 3; i++) {
          ans = (ans * 2) % MOD;
        }
        out.println(ans);
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
    try (AB instance = new AB()) {
      instance.solve();
    }
  }
}
