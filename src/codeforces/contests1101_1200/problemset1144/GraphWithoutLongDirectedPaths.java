package codeforces.contests1101_1200.problemset1144;

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

public class GraphWithoutLongDirectedPaths implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<List<Integer>> graph = new ArrayList<>();
    int[][] edges = new int[m][2];
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      edges[i] = new int[]{u, v};
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int[] color = new int[n];
    boolean[] visited = new boolean[n];
    queue.add(0);
    color[0] = 1;
    visited[0] = true;
    boolean possible = true;
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) {
        if (!visited[v]) {
          queue.offerLast(v);
          color[v] = color[u] ^ 1;
          visited[v] = true;
        } else {
          possible &= color[u] != color[v];
        }
      }
    }
    if (possible) {
      out.println("YES");
      for (int[] edge : edges) {
        out.print(color[edge[0]]);
      }
    } else {
      out.println("NO");
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
    try (GraphWithoutLongDirectedPaths instance = new GraphWithoutLongDirectedPaths()) {
      instance.solve();
    }
  }
}
