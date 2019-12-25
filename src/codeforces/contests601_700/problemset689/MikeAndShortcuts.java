package codeforces.contests601_700.problemset689;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MikeAndShortcuts implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    int[] dist = new int[n];
    for (int i = 1; i < n; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
    queue.add(new Edge(0, 0));
    while (queue.size() > 0) {
      Edge top = queue.poll();
      int next = top.to + 1;
      int prev = top.to - 1;
      int shortcut = x[top.to] - 1;
      if (next < n && dist[next] > dist[top.to] + 1) {
        dist[next] = dist[top.to] + 1;
        queue.add(new Edge(next, dist[next]));
      }
      if (prev >= 0 && dist[prev] > dist[top.to] + 1) {
        dist[prev] = dist[top.to] + 1;
        queue.add(new Edge(prev, dist[prev]));
      }
      if (dist[shortcut] > dist[top.to] + 1) {
        dist[shortcut] = dist[top.to] + 1;
        queue.add(new Edge(shortcut, dist[shortcut]));
      }
    }

    for (int d : dist) {
      out.print(d);
      out.print(' ');
    }

  }

  private class Edge {
    private int to, cost;

    private Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
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
    try (MikeAndShortcuts instance = new MikeAndShortcuts()) {
      instance.solve();
    }
  }
}