package codeforces.contests1101_1200.problemset1118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeCuttingEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    color = new int[n];
    for (int i = 0; i < n; i++) {
      color[i] = in.ni();
      if (color[i] == 1) {
        red++;
      } else if (color[i] == 2) {
        blue++;
      }
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    visited = new boolean[n];
    dfs(0);
    out.println(result);
  }

  private int red, blue, result;
  private int[] color;
  private boolean[] visited;
  private List<List<Integer>> tree = new ArrayList<>();

  private int[] dfs(int u) {
    visited[u] = true;
    int[] info = new int[2];
    if (color[u] != 0) info[color[u] - 1]++;
    for (int v : tree.get(u)) {
      if (!visited[v]) {
        int[] child = dfs(v);
        info[0] += child[0];
        info[1] += child[1];
      }
    }
    if ((info[0] == red && info[1] == 0) || (info[0] == 0 && info[1] == blue)) {
      result++;
    }
    return info;
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
    try (TreeCuttingEasy instance = new TreeCuttingEasy()) {
      instance.solve();
    }
  }
}
