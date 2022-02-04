package atcoder.beginner.contest126;

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

public class EvenRelation implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public EvenRelation() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    class Edge {
      private int to, weight;

      Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
      }
    }
    List<List<Edge>> tree = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni() - 1, v = in.ni() - 1, w = in.ni() % 2;
      tree.get(u).add(new Edge(v, w));
      tree.get(v).add(new Edge(u, w));
    }
    Integer[] result = new Integer[n];
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    result[0] = 0;
    while (queue.size() > 0) {
      int from = queue.pollFirst();
      for (Edge edge : tree.get(from)) {
        if (result[edge.to] == null) {
          result[edge.to] = result[from] ^ edge.weight;
          queue.add(edge.to);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      out.println(result[i]);
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
    try (EvenRelation instance = new EvenRelation()) {
      instance.solve();
    }
  }
}
