package codeforces.contests401_500.problemset472;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DesignTutorialInverseTheProblem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);
  
  public void solve() {
    int n = in.ni();
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = in.ni();
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (dist[i][j] != dist[j][i] || dist[i][j] == 0) {
          out.println("NO");
          return;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (dist[i][i] != 0) {
        out.println("NO");
        return;
      }
    }
    Edge[] edges = new Edge[n * (n - 1) / 2];
    int[] color = new int[n];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      color[i] = i;
      for (int j = i + 1; j < n; j++) {
        edges[idx++] = new Edge(i, j, dist[i][j]);
      }
    }
    Arrays.sort(edges);
    int[][] w = new int[n][n];
    
    boolean possible = true;
    for (Edge edge : edges) {
      int u = edge.u, v = edge.v;
      if (color[u] != color[v]) {
        int value = dist[u][v];
        possible &= value > 0;
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        int cv = color[v];
        for (int i = 0; i < n; i++) {
          if (color[i] == color[u]) {
            left.add(i);
          }
          if (color[i] == cv) {
            right.add(i);
            color[i] = color[u];
          }
        }
        for (int l : left) {
          for (int r : right) {
            w[l][r] = w[r][l] = w[l][u] + value + w[v][r];
          }
        }
      } else {
        possible &= w[u][v] == edge.weight;
      }
    }
    out.println(possible ? "YES" : "NO");
  }
  
  private class Edge implements Comparable<Edge> {
    private int u, v, weight;

    private Edge(int u, int v, int weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return weight - o.weight;
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
    try (DesignTutorialInverseTheProblem instance = new DesignTutorialInverseTheProblem()) {
      instance.solve();
    }
  }
}
