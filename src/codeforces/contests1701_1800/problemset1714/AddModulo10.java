package codeforces.contests1701_1800.problemset1714;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AddModulo10 implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      boolean possible = true;
      for (int i = 0; i < n; i++) {
        int rem = x[i] % 10;
        if (rem == 5 || rem == 0) {
          x[i] += rem;
        } else {
          while (x[i] % 10 != 2) {
            x[i] += (x[i] % 10);
          }
        }
      }
      if (x[0] % 10 == 0) {
        for (int i = 1; i < n; i++) {
          possible &= x[i] == x[0];
        }
      } else {
        for (int i = 1; i < n; i++) {
          possible &= (x[i] % 20 == x[0] % 20);
        }
      }
      out.println(possible ? "Yes" : "No");
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
    try (AddModulo10 instance = new AddModulo10()) {
      instance.solve();
    }
  }
}