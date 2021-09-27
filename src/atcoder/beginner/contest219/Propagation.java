package atcoder.beginner.contest219;

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

import static java.lang.Math.*;

public class Propagation implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Propagation() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Propagation(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni(), m = in.ni(), q = in.ni();
    List<List<Integer>> graph = new ArrayList<>();
    List<List<Integer>> heavyNeighbours = new ArrayList<>();
    int[] value = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
      heavyNeighbours.add(new ArrayList<>());
      value[i] = i;
    }
    int[] degree = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
      graph.get(v).add(u);
      degree[u]++;
      degree[v]++;
    }

    boolean[] heavy = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      heavy[i] = ((long) degree[i] * degree[i] >= m);
    }

    for (int u = 1; u <= n; u++) {
      for (int v : graph.get(u)) {
        if (heavy[v]) {
          heavyNeighbours.get(u).add(v);
        }
      }
    }

    int[] time = new int[n + 1];
    int[][] lazy = new int[n + 1][2];
    for (int t = 1; t <= q; t++) {
      int u = in.ni();
      for (int v : heavyNeighbours.get(u)) {
        if (lazy[v][1] > time[u]) {
          value[u] = lazy[v][0];
          time[u] = lazy[v][1];
        }
      }
      if (heavy[u]) {
        lazy[u][0] = value[u];
        lazy[u][1] = t;
      } else {
        for (int v : graph.get(u)) {
          value[v] = value[u];
          time[v] = t;
        }
      }
    }

    for (int u = 1; u <= n; u++) {
      for (int v : heavyNeighbours.get(u)) {
        if (lazy[v][1] > time[u]) {
          value[u] = lazy[v][0];
          time[u] = lazy[v][1];
        }
      }
      out.print(value[u]);
      out.print(' ');
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
    try (Propagation instance = new Propagation()) {
      instance.solve();
    }
  }
}
