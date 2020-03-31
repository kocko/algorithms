package codeforces.contests1301_1400.problemset1332;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CompositeColoring implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    int[] primes = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    while (t-- > 0) {
      int n = in.ni();
      int[] color = new int[n];
      int total = 0;
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        for (int j = 1; j < primes.length; j++) {
          if (next % primes[j] == 0) {
            int c = map.getOrDefault(primes[j], -1);
            if (c == -1) {
              total++;
              map.put(primes[j], total);
              c = total;
            }
            color[i] = c;
            break;
          }
        }
      }
      out.println(total);
      for (int j = 0; j < n; j++) {
        out.print(color[j]);
        out.print(' ');
      }
      out.println();
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
    try (CompositeColoring instance = new CompositeColoring()) {
      instance.solve();
    }
  }
}
