package codeforces.contests701_800.problemset740;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class AlyonaAndATree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    value = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      value[i] = in.nl();
    }
    tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int u = 2; u <= n; u++) {
      int v = in.ni();
      long w = in.nl();
      tree.get(u).add(new Edge(v, w));
      tree.get(v).add(new Edge(u, w));
    }
    prefix = new long[n + 1];
    result = new int[n + 1];
    delta = new int[n + 1];
    dfs(1, -1);
    for (int idx = 1; idx <= n; idx++) {
      out.print(result[idx]);
      out.print(' ');
    }
  }

  private class Edge {
    private int to;
    private long weight;

    private Edge(int to, long weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  private List<List<Edge>> tree;

  private int idx = 1;
  private int[] result, delta;
  private long[] prefix, value;

  private void dfs(int node, int parent) {
    int left = 1, right = idx - 1, ancestor = idx;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      long dist = prefix[idx - 1] - prefix[mid - 1];
      if (dist <= value[node]) {
        ancestor = min(mid, ancestor);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (ancestor >= 1 && ancestor < idx) {
      delta[ancestor]--;
      delta[idx]++;
    }
    for (Edge next : tree.get(node)) {
      if (next.to != parent) {
        prefix[idx] = prefix[idx - 1] + next.weight;
        idx++;
        dfs(next.to, node);
        result[node] += delta[idx];
        delta[idx - 1] += delta[idx];
        delta[idx] = 0;
        idx--;
      }
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
    try (AlyonaAndATree instance = new AlyonaAndATree()) {
      instance.solve();
    }
  }
}
