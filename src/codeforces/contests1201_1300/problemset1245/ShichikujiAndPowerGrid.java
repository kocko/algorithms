package codeforces.contests1201_1300.problemset1245;

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

public class ShichikujiAndPowerGrid implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class DisjointSet {
    private int[] root, size;

    private DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return x == root[x] ? x : (root[x] = root(root[x]));
    }

    private boolean join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) y = x ^ y ^ (x = y);
        root[y] = x;
        size[x] += size[y];
        return true;
      }
      return false;
    }
  }

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      y[i] = in.ni();
    }
    long[] power = new long[n];
    long[] k = new long[n];
    for (int i = 0; i < n; i++) power[i] = in.nl();
    for (int i = 0; i < n; i++) k[i] = in.nl();
    PriorityQueue<Action> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      queue.add(new Action(1, i, power[i]));
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        long dist = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
        long cost = dist * (k[i] + k[j]);
        queue.add(new Action(2, i, j, cost));
      }
    }
    long totalCost = 0;
    List<Integer> powerHouses = new ArrayList<>();
    List<int[]> connections = new ArrayList<>();
    DisjointSet dsu = new DisjointSet(n);
    int cnt = 0;
    boolean[] hasLight = new boolean[n];
    while (queue.size() > 0) {
      if (cnt == n) break;

      Action action = queue.poll();
      if (action.type == 1) {
        int city = action.u, root = dsu.root(city);
        if (!hasLight[root]) {
          hasLight[root] = true;
          powerHouses.add(city + 1);
          totalCost += action.cost;
          cnt += dsu.size[root];
        }
      } else {
        int a = dsu.root(action.u), b = dsu.root(action.v);
        int size_a = dsu.size[a], size_b = dsu.size[b];
        if (hasLight[a] && hasLight[b]) continue;
        if (dsu.join(a, b)) {
          totalCost += action.cost;
          connections.add(new int[]{action.u + 1, action.v + 1});
          if (hasLight[a]) {
            hasLight[b] = true;
            cnt += size_b;
          } else if (hasLight[b]) {
            hasLight[a] = true;
            cnt += size_a;
          }
        }
      }
    }
    out.println(totalCost);
    out.println(powerHouses.size());
    for (int powerHouse : powerHouses) {
      out.print(powerHouse);
      out.print(' ');
    }
    out.println();
    out.println(connections.size());
    for (int[] pair : connections) {
      out.println(pair[0] + " " + pair[1]);
    }
  }

  private class Action implements Comparable<Action> {
    private int type;
    private int u, v;
    private long cost;

    private Action(int type, int u, int v, long cost) {
      this.type = type;
      this.u = u;
      this.v = v;
      this.cost = cost;
    }

    private Action(int type, int u, long cost) {
      this.type = type;
      this.u = u;
      this.cost = cost;
    }

    @Override
    public int compareTo(Action o) {
      return Long.compare(this.cost, o.cost);
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
    try (ShichikujiAndPowerGrid instance = new ShichikujiAndPowerGrid()) {
      instance.solve();
    }
  }
}
