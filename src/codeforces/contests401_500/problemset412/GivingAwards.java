package codeforces.contests401_500.problemset412;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GivingAwards implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    while (m-- > 0) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
    }
    visited = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) dfs(i);
    }
  }

  private List<List<Integer>> graph = new ArrayList<>();
  private boolean[] visited;

  private void dfs(int u) {
    visited[u] = true;
    for (int v : graph.get(u)) {
      if (!visited[v]) {
        dfs(v);
      }
    }
    out.print(u);
    out.print(' ');
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
    try (GivingAwards instance = new GivingAwards()) {
      instance.solve();
    }
  }
}
