package codeforces.contests1701_1800.problemset1760;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class SlavicGsFavoriteProblem implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public SlavicGsFavoriteProblem() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  private class Edge {
    private int to, weight;

    private Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      read();
      go();
    }
  }

  private int n, a, b;
  private List<List<Edge>> tree;

  private void read() {
    n = in.ni();
    a = in.ni();
    b = in.ni();
    tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni(), v = in.ni(), w = in.ni();
      tree.get(u).add(new Edge(v, w));
      tree.get(v).add(new Edge(u, w));
    }
  }

  private void go() {
    int[] xa = new int[n + 1];
    boolean[] visitedA = new boolean[n + 1];
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(a);
    visitedA[a] = true;
    while (queue.size() > 0) {
      int top = queue.pollFirst();
      for (Edge v : tree.get(top)) {
        if (!visitedA[v.to] && v.to != b) {
          queue.add(v.to);
          xa[v.to] = xa[top] ^ v.weight;
          visitedA[v.to] = true;
        }
      }
    }

    int[] xb = new int[n + 1];
    boolean[] visitedB = new boolean[n + 1];
    queue.add(b);
    visitedB[b] = true;
    Set<Integer> has = new HashSet<>();
    while (queue.size() > 0) {
      int top = queue.pollFirst();
      for (Edge v : tree.get(top)) {
        if (!visitedB[v.to]) {
          queue.add(v.to);
          visitedB[v.to] = true;
          xb[v.to] = xb[top] ^ v.weight;
          has.add(xb[v.to]);
        }
      }
    }
    boolean can = false;
    for (int i = 1; i <= n; i++) {
      can |= (visitedA[i] && has.contains(xa[i]));
    }
    out.println(can ? "YES" : "NO");
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
    try (SlavicGsFavoriteProblem instance = new SlavicGsFavoriteProblem()) {
      instance.solve();
    }
  }
}
