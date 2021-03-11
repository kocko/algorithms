package codeforces.gyms.gym102942;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Offer implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), money = in.ni();
      int[] rate = new int[n];
      for (int i = 0; i < n; i++) {
        rate[i] = in.ni();
      }
      int left = 0, right = 0, result = 0;
      Map<Integer, Integer> count = new HashMap<>();
      int cost = 0;
      while (right < n) {
        int cnt = count.getOrDefault(rate[right], 0);
        count.put(rate[right], cnt + 1);
        if (cnt == 0) {
          cost += rate[right];
        }
        while (cost > money) {
          int have = count.get(rate[left]);
          if (have == 1) {
            cost -= rate[left];
            count.remove(rate[left]);
          } else {
            count.put(rate[left], have - 1);
          }
          left++;
        }
        result = Math.max(result, right - left + 1);
        right++;
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
    try (Offer instance = new Offer()) {
      instance.solve();
    }
  }
}
