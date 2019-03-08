package codeforces.contests1101_1200.problemset1133;

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

public class SpanningTreeWithMaximumDegree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    int[] degree = new int[n];
    int max = 0;
    int vertex = -1;
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      degree[u]++;
      degree[v]++;
      graph.get(u).add(v);
      graph.get(v).add(u);
      if (degree[u] > max) {
        max = degree[u];
        vertex = u;
      }
      if (degree[v] > max) {
        max = degree[v];
        vertex = v;
      }
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n];
    visited[vertex] = true;
    queue.add(vertex);
    while (!queue.isEmpty()) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          queue.add(v);
          out.println((u + 1) + " " + (v + 1));
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
    try (SpanningTreeWithMaximumDegree instance = new SpanningTreeWithMaximumDegree()) {
      instance.solve();
    }
  }
}
