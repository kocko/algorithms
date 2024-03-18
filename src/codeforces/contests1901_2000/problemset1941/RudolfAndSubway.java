package codeforces.contests1901_2000.problemset1941;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class RudolfAndSubway implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public RudolfAndSubway() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      read();
      bfs();
    }
  }

  private int n, m, begin, end;
  private Map<Integer, Integer> result;
  private Map<Integer, Set<Integer>> graph;

  private void read() {
    n = in.ni(); m = in.ni();
    graph = new HashMap<>();
    result = new HashMap<>();
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni(), color = in.ni();
      addEdge(u, color + n);
      addEdge(v, color + n);
    }
    begin = in.ni(); end = in.ni();
  }

  private void addEdge(int u, int v) {
    Set<Integer> adjacent = graph.getOrDefault(u, new HashSet<>());
    adjacent.add(v);
    graph.put(u, adjacent);

    adjacent = graph.getOrDefault(v, new HashSet<>());
    adjacent.add(u);
    graph.put(v, adjacent);
  }

  private void bfs() {
    result.put(begin, 0);
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(begin);
    while (queue.size() > 0) {
      int top = queue.pollFirst();
      int dist = result.get(top);
      for (int next : graph.get(top)) {
        if (!result.containsKey(next)) {
          result.put(next, dist + 1);
          queue.add(next);
        }
      }
    }
    out.println(result.get(end) >> 1);
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
    try (RudolfAndSubway instance = new RudolfAndSubway()) {
      instance.solve();
    }
  }
}
