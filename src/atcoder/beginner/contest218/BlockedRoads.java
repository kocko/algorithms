package atcoder.beginner.contest218;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class BlockedRoads implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public BlockedRoads() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public BlockedRoads(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<List<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    reverseIndex = new HashMap<>();
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      graph.get(u).add(new Edge(i, v));
      reverseIndex.put(u + "_" + v, i);
    }
    isOnTheShortestPath = new boolean[m];
    int initialDistance = findShortestPathWithDisabledIndex(graph, -1);
    for (int disable = 0; disable < m; disable++) {
      if (isOnTheShortestPath[disable]) {
        out.println(findShortestPathWithDisabledIndex(graph, disable));
      } else {
        out.println(initialDistance);
      }
    }
  }

  private class Edge {
    private int idx, to;

    private Edge(int idx, int to) {
      this.idx = idx;
      this.to = to;
    }
  }

  private Map<String, Integer> reverseIndex;
  private boolean[] isOnTheShortestPath;

  private int findShortestPathWithDisabledIndex(List<List<Edge>> graph, int disabled) {
    int n = graph.size();
    int[] dist = new int[n];
    int[] prev = new int[n];
    Arrays.fill(dist, -1);
    dist[0] = 0;
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    while (queue.size() > 0) {
      int u = queue.poll();
      for (Edge outgoing : graph.get(u)) if (outgoing.idx != disabled) {
        int v = outgoing.to;
        if (dist[v] == -1) {
          dist[v] = dist[u] + 1;
          prev[v] = u;
          queue.add(v);
        }
      }
    }
    if (disabled == -1 && dist[n - 1] != -1) {
      int current = n - 1;
      while (current != 0) {
        int u = current, v = prev[current];
        isOnTheShortestPath[reverseIndex.get(v + "_" + u)] = true;
        current = prev[current];
      }
    }
    return dist[n - 1];
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
    try (BlockedRoads instance = new BlockedRoads()) {
      instance.solve();
    }
  }
}
