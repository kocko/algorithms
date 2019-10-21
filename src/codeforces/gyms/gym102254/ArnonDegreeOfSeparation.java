package codeforces.gyms.gym102254;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ArnonDegreeOfSeparation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      int max = dijkstra(i);
      if (max > result) {
        result = max;
      }
    }
    if (result < oo) {
      out.println("=] " + result);
    } else {
      out.println("=[");
    }
  }

  private final int oo = (int) 1e8;
  private int n, m;
  private List<List<Integer>> graph;

  private int dijkstra(int start) {
    int[] dist = new int[n];
    for (int i = 0; i < n; i++) {
      dist[i] = oo;
    }
    dist[start] = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> dist[x]));
    queue.offer(start);
    while (queue.size() > 0) {
      int u = queue.poll();
      for (int v : graph.get(u)) {
        if (dist[v] > dist[u] + 1) {
          dist[v] = dist[u] + 1;
          queue.add(v);
        }
      }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dist[i]);
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
    try (ArnonDegreeOfSeparation instance = new ArnonDegreeOfSeparation()) {
      instance.solve();
    }
  }
}
