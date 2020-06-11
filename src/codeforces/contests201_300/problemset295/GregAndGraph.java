package codeforces.contests201_300.problemset295;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class GregAndGraph implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long[][] graph = new long[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        graph[i][j] = in.nl();
      }
    }
    int[] order = new int[n];
    for (int i = 0; i < n; i++) {
      order[i] = in.ni();
    }
    ArrayDeque<Long> result = new ArrayDeque<>();
    for (int idx = n - 1; idx >= 0; idx--) {
      int k = order[idx] - 1;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
      }
      long sum = 0;
      for (int i = n - 1; i >= idx; i--) {
        for (int j = n - 1; j >= idx; j--) {
          sum += graph[order[i] - 1][order[j] - 1];
        }
      }
      result.addFirst(sum);
    }
    for (long value : result) {
      out.print(value);
      out.print(' ');
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
    try (GregAndGraph instance = new GregAndGraph()) {
      instance.solve();
    }
  }
}
