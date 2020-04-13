package codeforces.contests1301_1400.problemset1335;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TwoTeamsComposing implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      Map<Integer, Integer> count = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        count.put(next, count.getOrDefault(next, 0) + 1);
      }
      int different = count.size(), max = 0;
      for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
        int distinct = different - 1;
        int same = entry.getValue();
        if (same == distinct + 2) {
          max = Math.max(same - 1, max);
        } else if (same <= distinct) {
          max = Math.max(max, same);
        } else {
          max = Math.max(max, Math.min(distinct + 1, same - 1));
        }
      }
      out.println(max);
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
    try (TwoTeamsComposing instance = new TwoTeamsComposing()) {
      instance.solve();
    }
  }
}
