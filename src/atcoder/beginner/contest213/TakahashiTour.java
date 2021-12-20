package atcoder.beginner.contest213;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TakahashiTour implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public TakahashiTour() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    for (int i = 0; i < n; i++) {
      tree.add(new TreeSet<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    visited = new boolean[n];
    dfs(0);
  }

  private List<Set<Integer>> tree = new ArrayList<>();
  private boolean[] visited;

  private void dfs(int city) {
    out.print(city + 1);
    out.print(' ');
    visited[city] = true;
    for (int next : tree.get(city)) {
      if (!visited[next]) {
        dfs(next);
        out.print(city + 1);
        out.print(' ');
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
    try (TakahashiTour instance = new TakahashiTour()) {
      instance.solve();
    }
  }
}
