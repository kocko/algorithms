package codeforces.contests201_300.problemset230;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.util.Comparator.comparingLong;

public class Planets implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<List<Edge>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
      delays.add(new TreeSet<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      long w = in.nl();
      graph.get(u).add(new Edge(v, w));
      graph.get(v).add(new Edge(u, w));
    }
    for (int i = 1; i <= n; i++) {
      int count = in.ni();
      for (int j = 0; j < count; j++) {
        delays.get(i).add(in.nl());
      }
    }
    long[] dist = new long[n + 1];
    final long oo = Long.MAX_VALUE;
    Arrays.fill(dist, oo);
    dist[1] = 0;
    boolean[] visited = new boolean[n + 1];
    PriorityQueue<Edge> queue = new PriorityQueue<>(comparingLong(e -> e.weight));
    queue.add(new Edge(1, 0));
    while (queue.size() > 0) {
      Edge u = queue.poll();
      visited[u.to] = true;
      long delay = findDelay(u.to, dist[u.to]);
      for (Edge v : graph.get(u.to)) {
        if (!visited[v.to]) {
          if (dist[u.to] + v.weight + delay < dist[v.to]) {
            dist[v.to] = dist[u.to] + v.weight + delay;
            queue.add(new Edge(v.to, dist[v.to]));
          }
        }
      }
    }
    out.println(dist[n] == oo ? - 1 : dist[n]);
  }
  
  private class Edge {
    private int to;
    private long weight;

    private Edge(int to, long weight) {
      this.to = to;
      this.weight = weight;
    }
  }
  
  private List<TreeSet<Long>> delays = new ArrayList<>();
  
  private long findDelay(int idx, long arrival) {
    long temp = arrival;
    TreeSet<Long> set = delays.get(idx);
    while (set.contains(arrival)) {
      arrival++;
    }
    return arrival - temp;
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
    try (Planets instance = new Planets()) {
      instance.solve();
    }
  }
}
