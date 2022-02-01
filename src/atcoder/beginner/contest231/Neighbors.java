package atcoder.beginner.contest231;

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

public class Neighbors implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Neighbors() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<Set<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new HashSet<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    boolean ok = true;
    for (Set<Integer> set : graph) {
      ok &= set.size() <= 2;
    }
    if (ok) {
      ArrayDeque<Integer> queue = new ArrayDeque<>();
      for (int idx = 0; idx < n; idx++) {
        if (graph.get(idx).size() == 1) {
          queue.add(idx);
        }
      }
      while (queue.size() > 0) {
        int u = queue.pollFirst();
        if (graph.get(u).size() > 0) {
          int v = graph.get(u).iterator().next();
          graph.get(v).remove(u);
          graph.get(u).remove(v);
          if (graph.get(v).size() == 1) {
            queue.add(v);
          }
        }
      }
      for (Set<Integer> set : graph) {
        ok &= set.size() == 0;
      }
    }
    out.println(ok ? "Yes" : "No");
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
    try (Neighbors instance = new Neighbors()) {
      instance.solve();
    }
  }
}
