package codeforces.contests1301_1400.problemset1399;

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

public class WeightsDivisionEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      long S = in.nl();
      tree = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<>());
      }
      for (int i = 0; i < n - 1; i++) {
        int u = in.ni(), v = in.ni();
        long w = in.nl();
        tree.get(u).add(new Edge(v, w));
        tree.get(v).add(new Edge(u, w));
      }
      queue = new PriorityQueue<>(Comparator.comparingLong(Edge::gain).reversed());
      sum = 0;

      dfs(1, 0);

      int steps = 0;
      while (sum > S) {
        Edge halve = queue.poll();
        long gain = halve.gain();
        sum -= gain;
        halve.weight >>= 1;
        queue.add(halve);
        steps++;
      }
      out.println(steps);
    }
  }

  private class Edge {
    private int to, leaves;
    private long weight;

    private Edge(int to, long weight) {
      this.to = to;
      this.weight = weight;
    }

    private long gain() {
      return leaves * (weight - (weight / 2));
    }
  }

  private long sum;
  private List<List<Edge>> tree;
  private PriorityQueue<Edge> queue;

  private int dfs(int u, int p) {
    int result = tree.get(u).size() == 1 ? 1 : 0;

    for (Edge edge : tree.get(u)) {
      if (edge.to != p) {
        int cnt = dfs(edge.to, u);
        edge.leaves = cnt;
        result += cnt;
        sum += cnt * edge.weight;
        queue.add(edge);
      }
    }

    return result;
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
    try (WeightsDivisionEasy instance = new WeightsDivisionEasy()) {
      instance.solve();
    }
  }
}
