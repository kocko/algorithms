package codeforces.contests1301_1400.problemset1341;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NastyaAndDoor implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      int[] peak = new int[n];
      for (int i = 1; i < n - 1; i++) {
        if (x[i] > x[i - 1] && x[i] > x[i + 1]) {
          peak[i]++;
        }
      }
      int[] prefix = new int[n];
      for (int i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] + peak[i];
      }
      int max = -1, idx = -1;
      for (int end = k - 1; end < n; end++) {
        int start = end - k + 1;
        int cnt = prefix[end];
        if (start > 0) {
          cnt -= prefix[start - 1];
        }
        cnt -= (peak[end] + peak[start]);
        if (cnt > max) {
          max = cnt;
          idx = start;
        }
      }
      out.println((max + 1) + " " + (idx + 1));
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
    try (NastyaAndDoor instance = new NastyaAndDoor()) {
      instance.solve();
    }
  }
}
