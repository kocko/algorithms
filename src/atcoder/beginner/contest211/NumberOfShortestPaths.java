package atcoder.beginner.contest211;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberOfShortestPaths implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public NumberOfShortestPaths() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public NumberOfShortestPaths(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    final long MOD = (long) 1e9 + 7;
    int n = in.ni(), m = in.ni();
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    Long[] dist = new Long[n];
    dist[n - 1] = 0L;
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(n - 1);
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) if (dist[v] == null) {
        dist[v] = dist[u] + 1;
        queue.add(v);
      }
    }
    long[] result = new long[n];
    result[n - 1] = 1L;
    queue.add(n - 1);
    boolean[] visited = new boolean[n];
    visited[n - 1] = true;
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) {
        if (dist[v] == dist[u] + 1) {
          result[v] = (result[v] + result[u]) % MOD;
          if (!visited[v]) {
            queue.add(v);
            visited[v] = true;
          }
        }
      }
    }
    out.println(result[0]);
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
    try (NumberOfShortestPaths instance = new NumberOfShortestPaths()) {
      instance.solve();
    }
  }
}
