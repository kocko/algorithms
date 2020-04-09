package codeforces.contests1301_1400.problemset1333;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EugeneAndAnArray implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long[] x = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      x[i] = in.nl();
    }
    long result = 0, sum = 0;
    Map<Long, Integer> last = new HashMap<>();
    last.put(0L, 0);
    long left = 1;
    for (int idx = 1; idx <= n; idx++) {
      sum += x[idx];
      if ((last.containsKey(sum) && last.get(sum) != 0) || sum == 0) {
        left = Math.max(left, last.get(sum) + 2);
      }
      result += (idx - left + 1);
      last.put(sum, idx);
    }
    out.println(result);
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
    try (EugeneAndAnArray instance = new EugeneAndAnArray()) {
      instance.solve();
    }
  }
}
