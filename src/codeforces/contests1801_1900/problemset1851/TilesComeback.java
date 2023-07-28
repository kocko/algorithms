package codeforces.contests1801_1900.problemset1851;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TilesComeback implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TilesComeback() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni();
      Map<Integer, List<Integer>> map = new HashMap<>();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        int next = x[i] = in.ni();
        List<Integer> same = map.getOrDefault(next, new ArrayList<>());
        same.add(i);
        map.put(next, same);
      }
      boolean can;
      if (x[0] == x[n - 1]) {
        can = map.get(x[0]).size() >= k;
      } else {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        if (map.get(x[0]).size() >= k) {
          left = map.get(x[0]).get(k - 1);
        }
        if (map.get(x[n - 1]).size() >= k) {
          List<Integer> tmp = map.get(x[n - 1]);
          tmp.sort(Comparator.reverseOrder());
          right = map.get(x[n - 1]).get(k - 1);
        }
        can = left < right;
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
    try (TilesComeback instance = new TilesComeback()) {
      instance.solve();
    }
  }
}
