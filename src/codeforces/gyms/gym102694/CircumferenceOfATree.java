package codeforces.gyms.gym102694;

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

public class CircumferenceOfATree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = 1;
    while (t-- > 0) {
      n = in.ni();
      tree = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<>());
      }
      for (int i = 0; i < n - 1; i++) {
        int u = in.ni(), v = in.ni();
        tree.get(u).add(v);
        tree.get(v).add(u);
      }
      bfs(1);
      int next = 0, max = -1;
      for (int i = 1; i <= n; i++) {
        if (dist[i] > max) {
          max = dist[i];
          next = i;
        }
      }
      bfs(next);
      int diameter = -1;
      for (int i = 0; i <= n; i++) {
        if (dist[i] > diameter) {
          diameter = dist[i];
        }
      }
      out.println(3 * diameter);
    }
  }

  private int n;
  private List<List<Integer>> tree;
  private int[] dist;

  private void bfs(int start) {
    dist = new int[n + 1];
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n + 1];
    visited[start] = true;
    queue.add(start);
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : tree.get(u)) if (!visited[v]) {
        visited[v] = true;
        queue.addLast(v);
        dist[v] = dist[u] + 1;
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
    try (CircumferenceOfATree instance = new CircumferenceOfATree()) {
      instance.solve();
    }
  }
}
