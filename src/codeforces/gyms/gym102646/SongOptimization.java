package codeforces.gyms.gym102646;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SongOptimization implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    long[][] d = new long[m][m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        d[i][j] = in.ni();
      }
    }
    for (int k = 0; k < m; k++) {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
          d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
        }
      }
    }
    int[] song = new int[n];
    for (int i = 0; i < n; i++) {
      song[i] = in.ni() - 1;
    }
    long[] prefix = new long[n];
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + d[song[i - 1]][song[i]];
    }
    long result = Long.MAX_VALUE;
    for (int change = 0; change < n; change++) {
      long min = Long.MAX_VALUE;
      for (int to = 0; to < m; to++) {
        long current = change > 0 ? prefix[change - 1] : 0;
        current += change > 0 ? d[song[change - 1]][to] : 0;
        current += change + 1 < n ? d[to][song[change + 1]] : 0;
        current += change + 1 < n ? prefix[n - 1] - prefix[change + 1] : 0;
        min = Math.min(min, current);
      }
      result = Math.min(result, min);
    }
    out.println(result);
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
    try (SongOptimization instance = new SongOptimization()) {
      instance.solve();
    }
  }
}
