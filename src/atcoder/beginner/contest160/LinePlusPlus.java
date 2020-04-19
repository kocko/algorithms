package atcoder.beginner.contest160;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LinePlusPlus implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 1; i < n; i++) {
      graph.get(i).add(i + 1);
      graph.get(i + 1).add(i);
    }
    int x = in.ni(), y = in.ni();
    graph.get(x).add(y);
    graph.get(y).add(x);
    result = new int[n];
    for (int start = 1; start <= n; start++) {
      bfs(start);
    }
    for (int k = 1; k < n; k++) {
      out.println(result[k] / 2);
    }
  }

  private int n;
  private List<List<Integer>> graph = new ArrayList<>();
  private int[] result;

  private void bfs(int start) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    int[] dist = new int[n + 1];
    boolean[] visited = new boolean[n + 1];
    visited[start] = true;
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) {
        if (!visited[v]) {
          dist[v] = dist[u] + 1;
          visited[v] = true;
          queue.add(v);
          result[dist[v]]++;
        }
      }
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
    try (LinePlusPlus instance = new LinePlusPlus()) {
      instance.solve();
    }
  }
}
