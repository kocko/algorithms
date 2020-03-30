package codeforces.contests1301_1400.problemset1325;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class EhabsLastTheorem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    for (int i = 0; i <= n; i++) {
      graph.add(new HashSet<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    while (sq * sq < n) {
      sq++;
    }
    depth = new int[n + 1];
    marked = new boolean[n + 1];
    findCycle(1, 0);
    if (!cycleFound) {
      out.println(1);
      for (int u = 1; u <= n && sq > 0; u++) {
        if (!marked[u]) {
          out.print(u);
          out.print(' ');
          sq--;
        }
      }
    }
  }

  private int sq;
  private List<Set<Integer>> graph = new ArrayList<>();
  private boolean cycleFound;
  private boolean[] marked;
  private int[] depth;
  private ArrayDeque<Integer> stack = new ArrayDeque<>();

  private void findCycle(int u, int parent) {
    depth[u] = depth[parent] + 1;
    stack.addLast(u);
    for (int v : graph.get(u)) {
      if (depth[v] == 0) {
        findCycle(v, u);
      } else {
        if (depth[u] - depth[v] + 1 >= sq && !cycleFound) {
          out.println(2);
          int cycle = depth[u] - depth[v] + 1;
          out.println(cycle);
          while (cycle-- > 0) {
            out.print(stack.pollLast());
            out.print(' ');
          }
          cycleFound = true;
        }
      }
    }
    if (!marked[u]) {
      for (int v : graph.get(u)) {
        marked[v] = true;
      }
    }
    stack.pollLast();
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
    try (EhabsLastTheorem instance = new EhabsLastTheorem()) {
      instance.solve();
    }
  }
}
