package codeforces.contests601_700.problemset605;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class LazyStudent implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Edge {
    private int idx, u, v, included;
    private long weight;

    private Edge(int idx, long weight, int included) {
      this.idx = idx;
      this.weight = weight;
      this.included = included;
    }

    private void assignVertices(int u, int v) {
      this.u = u;
      this.v = v;
    }
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      long weight = in.ni();
      int included = in.ni();
      edges.add(new Edge(i, weight, included));
    }
    edges.sort(Comparator.comparingLong((Edge edge) -> edge.weight).thenComparing(e -> -e.included));
    int u = 1, v = 2;
    for (int i = 0; i < m; i++) {
      Edge edge = edges.get(i);
      if (edge.included == 1) {
        edge.assignVertices(u, v++);
      }
    }
    int excluded = m - n + 1;
    ArrayDeque<int[]> heavy = new ArrayDeque<>();
    int connected = 0;
    for (int i = 0; i < m; i++) {
      Edge edge = edges.get(i);
      if (edge.included == 1) {
        connected++;
        u = connected + 1;
        v = u - 1;
        while (excluded > 0 && v >= 2) {
          excluded--;
          heavy.offerLast(new int[]{u, v});
          v--;
        }
      } else {
        if (heavy.size() > 0) {
          int[] top = heavy.pollFirst();
          edge.assignVertices(top[0], top[1]);
        } else {
          out.println(-1);
          return;
        }
      }
    }
    edges.sort(Comparator.comparingInt(e -> e.idx));
    for (Edge edge : edges) {
      out.println(edge.u + " " + edge.v);
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
    try (LazyStudent instance = new LazyStudent()) {
      instance.solve();
    }
  }
}
