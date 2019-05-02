package codeforces.gyms.gym100169;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Long.compare;

public class BridgesAndTunnels implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    int m = in.ni(), p = in.ni();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      long w = in.nl();
      char type = in.next().charAt(0);
      if (type == 'I') {
        graph.get(u).add(new Edge(v, 0, w));
        graph.get(v).add(new Edge(u, 0, w));
      } else {
        graph.get(u).add(new Edge(v, w, w));
        graph.get(v).add(new Edge(u, w, w));
      }
    }
    for (int i = 0; i < p; i++) {
      int start = in.ni(), end = in.ni();
      dijkstra(start, end);
    }
  }

  private class Edge implements Comparable<Edge> {
    private int node;
    private long outside, weight;

    private Edge(int node, long outside, long weight) {
      this.node = node;
      this.outside = outside;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      int x = compare(outside, o.outside), y = compare(weight, o.weight);
      return x != 0 ? x : y;
    }
  }

  private int n;
  private List<List<Edge>> graph = new ArrayList<>();

  private void dijkstra(int start, int end) {
    final long oo = Long.MAX_VALUE;

    long[][] dist = new long[n][2];
    for (int i = 0; i < n; i++) {
      dist[i][0] = dist[i][1] = oo;
    }
    PriorityQueue<Edge> queue = new PriorityQueue<>();
    queue.add(new Edge(start, 0, 0));
    dist[start][0] = dist[start][1] = 0;
    while (queue.size() > 0) {
      Edge from = queue.poll();
      for (Edge to : graph.get(from.node)) {
        if (dist[to.node][0] > dist[from.node][0] + to.outside) {
          dist[to.node][0] = dist[from.node][0] + to.outside;
          dist[to.node][1] = dist[from.node][1] + to.weight;
          queue.offer(new Edge(to.node, dist[to.node][0], dist[to.node][1]));
        } else if (dist[to.node][0] == dist[from.node][0] + to.outside) {
          if (dist[to.node][1] > dist[from.node][1] + to.weight) {
            dist[to.node][0] = dist[from.node][0] + to.outside;
            dist[to.node][1] = dist[from.node][1] + to.weight;
            queue.offer(new Edge(to.node, dist[to.node][0], dist[to.node][1]));
          }
        }
      }
    }
    if (dist[end][0] == oo) {
      out.println("IMPOSSIBLE");
    } else {
      out.println(dist[end][0] + " " + dist[end][1]);
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
    try (BridgesAndTunnels instance = new BridgesAndTunnels()) {
      instance.solve();
    }
  }
}
