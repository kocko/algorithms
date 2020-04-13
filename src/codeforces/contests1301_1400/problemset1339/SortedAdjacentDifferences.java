package codeforces.contests1301_1400.problemset1339;

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

public class SortedAdjacentDifferences implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      List<Integer> x = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        x.add(in.ni());
      }
      x.sort(Comparator.naturalOrder());
      int[] result = new int[n];
      int mid = n / 2;
      int idx = 0, k = 0;
      for (int i = 0; i < n; i++) {
        if (i % 2 == 1) {
          result[idx++] = x.get(mid - k);
        } else {
          result[idx++] = x.get(mid + k);
          k++;
        }
      }
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
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
    try (SortedAdjacentDifferences instance = new SortedAdjacentDifferences()) {
      instance.solve();
    }
  }
}
