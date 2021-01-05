package codeforces.contests1401_1500.problemset1472;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MovingToTheCapital implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      graph = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
      }
      for (int i = 0; i < m; i++) {
        int u = in.ni() - 1, v = in.ni() - 1;
        graph.get(u).add(v);
      }
      level = new int[n];
      ArrayDeque<Integer> queue = new ArrayDeque<>();
      queue.add(0);
      level[0] = 0;
      boolean[] visited = new boolean[n];
      visited[0] = true;
      while (queue.size() > 0) {
        int u = queue.pollFirst();
        for (int v : graph.get(u)) {
          if (!visited[v]) {
            level[v] = level[u] + 1;
            queue.add(v);
            visited[v] = true;
          }
        }
      }
      dp = new Integer[n][2];
      for (int i = 0; i < n; i++) {
        if (dp[i][0] == null) recurse(i, 0);
        if (dp[i][1] == null) recurse(i, 1);
        out.print(Math.min(dp[i][0], dp[i][1]));
        out.print(' ');
      }
      out.println();
    }
  }

  private List<List<Integer>> graph;
  private int[] level;
  private Integer[][] dp;

  private int recurse(int u, int moveUp) {
    if (dp[u][moveUp] != null) return dp[u][moveUp];

    int minLevel = level[u];
    for (int v : graph.get(u)) {
      if (level[v] <= level[u]) {
        if (moveUp == 0) {
          minLevel = Math.min(minLevel, level[v]);
        }
      } else {
        minLevel = Math.min(minLevel, recurse(v, 0));
      }

    }
    return dp[u][moveUp] = minLevel;
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
    try (MovingToTheCapital instance = new MovingToTheCapital()) {
      instance.solve();
    }
  }
}
