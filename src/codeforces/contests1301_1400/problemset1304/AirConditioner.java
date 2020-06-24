package codeforces.contests1301_1400.problemset1304;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class AirConditioner implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    final int oo = (int) 1e9 + 5;
    while (q-- > 0) {
      int n = in.ni(), temp = in.ni();
      TreeMap<Integer, int[]> tempRangePerMinute = new TreeMap<>();
      boolean can = true;
      for (int i = 0; i < n; i++) {
        int arrival = in.ni(), min = in.ni(), max = in.ni();
        int[] range = tempRangePerMinute.getOrDefault(arrival, new int[]{-oo, oo});
        if (min > range[1] || max < range[0]) {
          can = false;
        } else {
          range[0] = Math.max(range[0], min);
          range[1] = Math.min(range[1], max);
        }
        tempRangePerMinute.put(arrival, range);
      }
      if (can) {
        int min = temp, max = temp, time = 0;
        for (Map.Entry<Integer, int[]> entry : tempRangePerMinute.entrySet()) {
          int t = entry.getKey();
          int[] desired = entry.getValue();
          int delta = t - time;
          int[] range = {min - delta, max + delta};
          if (range[0] > desired[1] || range[1] < desired[0]) {
            can = false;
            break;
          } else {
            min = Math.max(range[0], desired[0]);
            max = Math.min(range[1], desired[1]);
          }
          time = t;
        }
      }
      out.println(can ? "YES" : "NO");
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
    try (AirConditioner instance = new AirConditioner()) {
      instance.solve();
    }
  }
}
