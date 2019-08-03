package codeforces.gyms.gym102152;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GridBeauty implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni(), result = 0;
      Map<Integer, Integer> prev = new HashMap<>();
      for (int i = 0; i < m; i++) {
        int next = in.ni();
        prev.put(next, prev.getOrDefault(next, 0) + 1);
      }
      for (int i = 1; i < n; i++) {
        Map<Integer, Integer> current = new HashMap<>();
        for (int j = 0; j < m; j++) {
          int next = in.ni();
          current.put(next, current.getOrDefault(next, 0) + 1);
          if (prev.containsKey(next)) {
            result++;
            int count = prev.get(next);
            if (count == 1) {
              prev.remove(next);
            } else {
              prev.put(next, count - 1);
            }
          }
        }
        prev = current;
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
    try (GridBeauty instance = new GridBeauty()) {
      instance.solve();
    }
  }
}
