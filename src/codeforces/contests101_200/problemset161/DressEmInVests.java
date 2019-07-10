package codeforces.contests101_200.problemset161;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DressEmInVests implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), x = in.ni(), y = in.ni();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
    }
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = in.ni();
    }
    List<int[]> result = new ArrayList<>();
    int i = 0, j = 0;
    while (i < n && j < m) {
      if (b[j] >= a[i] - x && b[j] <= a[i] + y) {
        result.add(new int[]{i, j});
        i++;
        j++;
      }
      while (i < n && j < m && b[j] < a[i] - x) {
        j++;
      }
      if (i < n && j < m && a[i] + y < b[j]) {
        i++;
      }
    }
    out.println(result.size());
    for (int[] pair : result) {
      out.printf("%d %d\n", pair[0] + 1, pair[1] + 1);
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
    try (DressEmInVests instance = new DressEmInVests()) {
      instance.solve();
    }
  }
}
