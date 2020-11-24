package codeforces.contests1401_1500.problemset1454;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class UniqueBidAuction implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        map.put(x[i], map.getOrDefault(x[i], 0) + 1);
      }
      int index = n + 5, value = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        if (map.get(x[i]) == 1) {
          if (x[i] < value) {
            index = i + 1;
            value = x[i];
          }
        }
      }
      out.println(index == n + 5 ? -1 : index);
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
    try (UniqueBidAuction instance = new UniqueBidAuction()) {
      instance.solve();
    }
  }
}
