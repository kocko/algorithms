package lightoj;

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

public class FarthestNodesInATree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      int n = in.ni();
      List<List<Edge>> tree = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        tree.add(new ArrayList<>());
      }
      for (int i = 0; i < n - 1; i++) {
        int u = in.ni(), v = in.ni(), w = in.ni();
        tree.get(u).add(new Edge(v, w));
        tree.get(v).add(new Edge(u, w));
      }
      ArrayDeque<Integer> queue = new ArrayDeque<>();
      boolean[] visited = new boolean[n];
      int[] dist = new int[n];
      queue.add(0);
      visited[0] = true;
      int max = 0, farthest = -1;
      while (queue.size() > 0) {
        int top = queue.pollFirst();
        for (Edge next : tree.get(top)) {
          if (!visited[next.to]) {
            dist[next.to] = dist[top] + next.weight;
            if (dist[next.to] > max) {
              max = dist[next.to];
              farthest = next.to;
            }
            visited[next.to] = true;
            queue.add(next.to);
          }
        }
      }
      queue = new ArrayDeque<>();
      visited = new boolean[n];
      queue.add(farthest);
      visited[farthest] = true;
      dist = new int[n];
      max = 0;
      while (queue.size() > 0) {
        int top = queue.pollFirst();
        for (Edge next : tree.get(top)) {
          if (!visited[next.to]) {
            dist[next.to] = dist[top] + next.weight;
            if (dist[next.to] > max) {
              max = dist[next.to];
            }
            visited[next.to] = true;
            queue.add(next.to);
          }
        }
      }
      out.printf("Case %d: %d\n", testCase, max);
    }
  }
  
  private class Edge {
    private int to, weight;

    private Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
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
    try (FarthestNodesInATree instance = new FarthestNodesInATree()) {
      instance.solve();
    }
  }
}
