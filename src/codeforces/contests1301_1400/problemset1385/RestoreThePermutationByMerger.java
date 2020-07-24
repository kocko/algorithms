package codeforces.contests1301_1400.problemset1385;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RestoreThePermutationByMerger implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[2 * n];
      for (int i = 0; i < 2 * n; i++) {
        x[i] = in.ni();
      }
      boolean[] seen = new boolean[n + 1];
      int[] result = new int[n];
      int idx = 0;
      for (int i = 0; i < 2 * n; i++) {
        int value = x[i];
        if (!seen[value]) {
          result[idx++] = value;
          seen[value] = true;
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
    try (RestoreThePermutationByMerger instance = new RestoreThePermutationByMerger()) {
      instance.solve();
    }
  }
}
