package codeforces.gyms.gym102157;

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

public class SoccerBalls implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    graph = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      graph.add(new ArrayList<>());
    }
    int[] degree = new int[5];
    for (int i = 0; i < 5; i++) {
      String relation = in.next();
      int u = relation.charAt(0) - 'A', v = relation.charAt(2) - 'A';
      if (relation.charAt(1) == '>') {
        graph.get(u).add(v);
        degree[v]++;
      } else {
        graph.get(v).add(u);
        degree[u]++;
      }
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < 5; i++) {
      if (degree[i] == 0) {
        queue.add(i);
      }
    }
    color = new int[5];
    visited = new boolean[5];
    while (queue.size() > 0) {
      int start = queue.poll();
      dfs(start);
    }
    if (possible && order.size() == 5) {
      for (int i = 0; i < 5; i++) {
        out.print((char) ('A' + order.get(i)));
      }
    } else {
      out.println("impossible");
    }
  }
  
  private List<List<Integer>> graph;
  private boolean possible = true;
  private boolean[] visited;
  private int[] color;
  private List<Integer> order = new ArrayList<>();
  
  private void dfs(int u) {
    color[u] = 1;
    visited[u] = true;
    for (int v : graph.get(u)) {
      if (color[v] == 1) possible = false;
      else if (!visited[v]) {
        dfs(v);
      }
    }
    color[u] = 2;
    order.add(u);
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
    try (SoccerBalls instance = new SoccerBalls()) {
      instance.solve();
    }
  }
}
