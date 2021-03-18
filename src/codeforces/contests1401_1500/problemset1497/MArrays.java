package codeforces.contests1401_1500.problemset1497;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class MArrays implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      Map<Integer, Integer> cnt = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int next = in.ni(), rem = next % m;
        cnt.put(rem, cnt.getOrDefault(rem, 0) + 1);
      }
      int pairs = 0, singles = 0;
      for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
        int rem = entry.getKey();
        if (rem == 0) {
          singles++;
        } else {
          int need = m - rem;
          if (need != rem) {
            int a = entry.getValue(), b = cnt.getOrDefault(need, 0);
            int max = Math.max(a, b), min = Math.min(a, b);
            if (min == 0) {
              singles += max;
            } else {
              pairs++;
              max -= (min + 1);
              if (max > 0) {
                pairs += max;
              }
            }
          } else {
            singles++;
          }
        }
      }
      out.println(singles + (pairs / 2));
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
    try (MArrays instance = new MArrays()) {
      instance.solve();
    }
  }
}
