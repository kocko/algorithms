package codeforces.contests1401_1500.problemset1487;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CatCycle implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      int result = -1;
      if (n % 2 == 0) {
        if (k <= n) {
          result = k;
        } else {
          k = (k - 1) % n + 1;
          result = k;
        }
      } else {
        int a = (k - 1) % n + 1;
        a = (n - a + 1);
        int cycle = (n - 1) / 2;
        int rem = k % cycle - 1;
        if (rem < 0) {
          rem += cycle;
        }
        if (rem == 0) {
          result = (a + 1);
          if (result > n) {
            result = 1;
          }
        } else {
          int aAtLastCycle = a + rem;
          if (aAtLastCycle > n) {
            aAtLastCycle -= n;
          }
          int bAtLastCycle = aAtLastCycle + 1;
          if (bAtLastCycle > n) {
            bAtLastCycle -= n;
          }
          result = bAtLastCycle + rem;
          if (a == result) {
            result++;
          }
          if (result > n) {
            result -= n;
          }
        }
      }
      out.println(result);
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
    try (CatCycle instance = new CatCycle()) {
      instance.solve();
    }
  }
}
