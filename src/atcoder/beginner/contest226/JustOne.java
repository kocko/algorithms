package atcoder.beginner.contest226;

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

public class JustOne implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public JustOne() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    n = in.ni();
    m = in.ni();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    final long MOD = 998244353;
    long result = 1;
    used = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!used[i]) {
        dfs(i);
        if (edges == 2 * vertices) {
          result = (result * 2L) % MOD;
        } else {
          result = 0;
        }
      }
      vertices = edges = 0;
    }
    out.println(result);
  }

  private int n, m;
  private List<List<Integer>> graph = new ArrayList<>();
  private boolean[] used;
  private int edges, vertices;

  private void dfs(int u) {
    used[u] = true;
    vertices++;
    edges += graph.get(u).size();
    for (int v : graph.get(u)) {
      if (!used[v]) {
        dfs(v);
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
    try (JustOne instance = new JustOne()) {
      instance.solve();
    }
  }
}
