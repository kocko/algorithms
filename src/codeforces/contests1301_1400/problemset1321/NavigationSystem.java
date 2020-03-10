package codeforces.contests1301_1400.problemset1321;

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

public class NavigationSystem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    dist = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
      dist[i] = -1;
    }
    for (int i = 0; i < m; i++) {
      int v = in.ni(), u = in.ni();
      graph.get(u).add(v);
    }
    k = in.ni();
    route = new int[k];
    for (int i = 0; i < k; i++) {
      route[i] = in.ni();
    }
    bfs();
    int min = 0, max = 0, prevOptimal = dist[route[0]];
    for (int idx = 1; idx < route.length - 1; idx++) {
      int curOptimal = dist[route[idx]];
      if (curOptimal != prevOptimal - 1) {
        min++;
        max++;
      } else if (multiOptimal[route[idx - 1]]) {
        max++;
      }
      prevOptimal = dist[route[idx]];
    }

    out.println(min + " " + max);
  }

  private List<List<Integer>> graph = new ArrayList<>();
  private int k;
  private int[] route, dist;
  private boolean[] multiOptimal;

  private void bfs() {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(route[k - 1]);
    multiOptimal = new boolean[graph.size()];
    dist[route[k - 1]] = 0;
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) {
        if (dist[v] == -1) {
          dist[v] = dist[u] + 1;
          queue.add(v);
        } else if (dist[v] == dist[u] + 1) {
          multiOptimal[v] = true;
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
    try (NavigationSystem instance = new NavigationSystem()) {
      instance.solve();
    }
  }
}
