package codeforces.contests1101_1200.problemset1118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class CoffeeAndCoursework implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    m = in.ni();
    list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(in.ni());
    }
    list.sort(Comparator.reverseOrder());
    int left = 1, right = n, result = n + 5;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (possible(mid)) {
        result = Math.min(result, mid);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    out.println(result == n + 5 ? -1 : result);
  }

  private int m;
  private List<Integer> list;

  private boolean possible(int days) {
    int[] data = new int[days];
    int penalty = 0, total = 0, idx = 0;
    for (int cup : list) {
      if (idx == days) {
        idx = 0;
        penalty++;
      }
      data[idx++] += Math.max(0, cup - penalty);
    }
    for (int i = 0; i < days; i++) {
      total += data[i];
    }
    return total >= m;
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
    try (CoffeeAndCoursework instance = new CoffeeAndCoursework()) {
      instance.solve();
    }
  }
}
