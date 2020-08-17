package codeforces.contests1301_1400.problemset1398;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GoodSubarrays implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray();
      Map<Integer, Long> map = new HashMap<>();
      int sum = 0;
      for (int i = 1; i <= n; i++) {
        sum += (x[i - 1] - '0');
        int diff = sum - i;
        map.put(diff, map.getOrDefault(diff, 0L) + 1);
      }
      int prefix = 0;
      long result = 0;
      for (int start = 0; start < n; start++) {
        int delta = prefix - start;

        long count = map.getOrDefault(delta, 0L);
        result += count;
        prefix += (x[start] - '0');

        int remove = prefix - start - 1;
        long have = map.getOrDefault(remove, 0L);
        if (have > 0) {
          if (have == 1) {
            map.remove(remove);
          } else {
            map.put(remove, have - 1);
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
    try (GoodSubarrays instance = new GoodSubarrays()) {
      instance.solve();
    }
  }
}
