package codeforces.contests1201_1300.problemset1294;

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

public class ThreePathsOnATree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    bfs1();
    List<Integer> sources = bfs2(nodes[0]);
    diameter += bfs3(sources);
    out.println(diameter);
    for (int i = 0; i < 3; i++) {
      out.print(nodes[i] + 1);
      out.print(' ');
    }
  }

  private int n, diameter;
  private List<List<Integer>> tree = new ArrayList<>();
  private int[] nodes = new int[3];

  private void bfs1() {
    int[] dist = new int[n];
    dist[0] = 0;
    boolean[] visited = new boolean[n];
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    visited[0] = true;
    while (queue.size() > 0) {
      int top = queue.poll();
      for (int next : tree.get(top)) {
        if (!visited[next]) {
          dist[next] = dist[top] + 1;
          visited[next] = true;
          queue.add(next);
        }
      }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (dist[i] > max) {
        nodes[0] = i;
        max = dist[i];
      }
    }
  }

  private List<Integer> bfs2(int start) {
    int[] dist = new int[n];
    dist[start] = 0;
    boolean[] visited = new boolean[n];
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;
    int[] parent = new int[n];
    parent[start] = -1;
    while (queue.size() > 0) {
      int top = queue.poll();
      for (int next : tree.get(top)) {
        if (!visited[next]) {
          dist[next] = dist[top] + 1;
          visited[next] = true;
          queue.add(next);
          parent[next] = top;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (dist[i] > diameter) {
        nodes[1] = i;
        diameter = dist[i];
      }
    }
    List<Integer> sources = new ArrayList<>();
    int current = nodes[1];
    do {
      sources.add(current);
      current = parent[current];
    } while (current != -1);
    return sources;
  }

  private int bfs3(List<Integer> sources) {
    int[] dist = new int[n];
    boolean[] visited = new boolean[n];
    for (int source : sources) {
      dist[source] = 0;
      visited[source] = true;
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>(sources);
    while (queue.size() > 0) {
      int top = queue.poll();
      for (int next : tree.get(top)) {
        if (!visited[next]) {
          dist[next] = dist[top] + 1;
          visited[next] = true;
          queue.add(next);
        }
      }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (dist[i] > max) {
        nodes[2] = i;
        max = dist[i];
      }
    }
    if (nodes[2] == 0) {
      for (int i = 0; i < n; i++) {
        if (i != nodes[0] && i != nodes[1]) {
          nodes[2] = i;
          break;
        }
      }
    }
    return max;
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
    try (ThreePathsOnATree instance = new ThreePathsOnATree()) {
      instance.solve();
    }
  }
}
