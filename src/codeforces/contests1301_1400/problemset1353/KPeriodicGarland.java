package codeforces.contests1301_1400.problemset1353;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class KPeriodicGarland implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      char[] x = in.next().toCharArray();
      int total = 0;
      for (int i = 0; i < n; i++) {
        if (x[i] == '1') {
          total++;
        }
      }
      int result = n + 5;
      for (int i = 0; i < k; i++) {
        int balance = 0;
        for (int j = i; j < n; j += k) {
          if (x[j] == '1') {
            balance++;
          } else {
            balance--;
          }
          if (balance < 0) balance = 0;
          result = min(result, total - balance);
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
    try (KPeriodicGarland instance = new KPeriodicGarland()) {
      instance.solve();
    }
  }
}
