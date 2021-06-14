package codeforces.contests401_500.problemset459;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class PashmakAndGraph implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PashmakAndGraph() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public PashmakAndGraph(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1, w = in.ni();
      Edge edge = new Edge(u, v, w);
      edges.add(edge);
    }
    edges.sort(Comparator.comparingInt(edge -> edge.weight));
    int[] dp = new int[n];
    ArrayDeque<Edge> equal = new ArrayDeque<>();
    equal.add(edges.get(m - 1));
    for (int idx = m - 2; idx >= 0; idx--) {
      Edge current = edges.get(idx);
      if (current.weight != equal.peekFirst().weight) {
        List<int[]> info = new ArrayList<>();
        for (Edge edge : equal) {
          int from = edge.from, to = edge.to;
          info.add(new int[]{from, Math.max(dp[from], 1 + dp[to])});
        }
        equal = new ArrayDeque<>();
        for (int[] pair : info) {
          dp[pair[0]] = Math.max(dp[pair[0]], pair[1]);
        }
      }
      equal.add(current);
    }
    List<int[]> info = new ArrayList<>();
    for (Edge edge : equal) {
      int from = edge.from, to = edge.to;
      info.add(new int[]{from, Math.max(dp[from], 1 + dp[to])});
    }
    for (int[] pair : info) {
      dp[pair[0]] = Math.max(dp[pair[0]], pair[1]);
    }
    int max = 0;
    for (int node : dp) {
      max = Math.max(max, node);
    }
    out.println(max);
  }

  private class Edge {
    private int from, to, weight;

    private Edge(int from, int to, int weight) {
      this.from = from;
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
    try (PashmakAndGraph instance = new PashmakAndGraph()) {
      instance.solve();
    }
  }
}
