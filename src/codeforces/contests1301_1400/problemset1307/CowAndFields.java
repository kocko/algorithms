package codeforces.contests1301_1400.problemset1307;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class CowAndFields implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), k = in.ni();
    boolean[] special = new boolean[n + 1];
    for (int i = 0; i < k; i++) {
      int next = in.ni();
      special[next] = true;
    }
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    int[] x = bfs(graph, 1);
    int[] y = bfs(graph, n);
    List<int[]> pairs = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (special[i]) {
        pairs.add(new int[]{x[i], y[i], i});
      }
    }
    pairs.sort(Comparator.comparingInt(arr -> arr[0]));

    int ans = x[n], max = Integer.MIN_VALUE;
    for (int i = 0; i < k - 1; i++) {
      int[] next = pairs.get(i + 1), curr = pairs.get(i);
      max = Math.max(max, Math.min(curr[0] + next[1], curr[1] + next[0]) + 1);
    }
    out.println(Math.min(ans, max));
  }

  private int[] bfs(List<List<Integer>> graph, int start) {
    int n = graph.size();
    int[] result = new int[n];
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    boolean[] visited = new boolean[n];
    visited[start] = true;
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) if (!visited[v]) {
        visited[v] = true;
        queue.add(v);
        result[v] = result[u] + 1;
      }
    }
    return result;
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
    try (CowAndFields instance = new CowAndFields()) {
      instance.solve();
    }
  }
}
