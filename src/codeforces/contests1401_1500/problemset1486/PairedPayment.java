package codeforces.contests1401_1500.problemset1486;

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

public class PairedPayment implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    read();
    dijkstra();
    for (int i = 0; i < n; i++) {
      out.print(dist[i] == oo ? -1 : dist[i]);
      out.print(' ');
    }
  }

  private void read() {
    n = in.ni();
    m = in.ni();
    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int from = in.ni() - 1, to = in.ni() - 1;
      long weight = in.nl();
      graph.get(from).add(new Edge(to, weight));
      graph.get(to).add(new Edge(from, weight));
    }
    dist = new long[n];
    for (int i = 0; i < n; i++) {
      dist[i] = oo;
    }
  }

  private final long oo = (long) 1e16;
  private int n, m;
  private long[] dist;
  private List<List<Edge>> graph;

  private class Edge {
    private int to;
    private long cost;

    private Edge(int to, long cost) {
      this.to = to;
      this.cost = cost;
    }

    public long getCost() {
      return cost;
    }
  }

  private void dijkstra() {
    PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingLong(Edge::getCost));
    queue.add(new Edge(0, 0));
    dist[0] = 0;
    while (queue.size() > 0) {
      Edge top = queue.poll();
      int u = top.to;
      for (Edge first : graph.get(u)) {
        long wa = first.cost;
        for (Edge second : graph.get(first.to)) {
          long wb = second.cost;
          int v = second.to;
          long relax = dist[u] + (wa + wb) * (wa + wb);
          if (relax < dist[v]) {
            queue.add(new Edge(v, relax));
            dist[v] = relax;
          }
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
    try (PairedPayment instance = new PairedPayment()) {
      instance.solve();
    }
  }
}
