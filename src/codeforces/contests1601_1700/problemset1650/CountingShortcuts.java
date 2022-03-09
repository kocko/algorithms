package codeforces.contests1601_1700.problemset1650;

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

public class CountingShortcuts implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public CountingShortcuts() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      n = in.ni();
      m = in.ni();
      start = in.ni() - 1;
      target = in.ni() - 1;
      graph = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
      }
      for (int i = 0; i < m; i++) {
        int u = in.ni() - 1, v = in.ni() - 1;
        graph.get(u).add(v);
        graph.get(v).add(u);
      }
      bfs();
      dp = new Long[n][2];
      out.println(recurse(start, 0));
    }
  }

  private int n, m, start, target;
  private List<List<Integer>> graph;
  private int[] level;

  private void bfs() {
    level = new int[n];
    Arrays.fill(level, -1);
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(target);
    level[target] = 0;
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) {
        if (level[v] == -1) {
          level[v] = level[u] + 1;
          queue.add(v);
        }
      }
    }
  }

  private final long MOD = (long) 1e9 + 7;
  private Long[][] dp;

  private long recurse(int u, int increased) {
    if (u == target) return 1L;

    if (dp[u][increased] != null) return dp[u][increased];

    long result = 0;
    for (int v : graph.get(u)) {
      if (level[v] == level[u] && increased == 0) {
        result += recurse(v, 1);
        result %= MOD;
      } else if (level[v] == level[u] - 1) {
        result += recurse(v, increased);
        result %= MOD;
      }
    }
    return dp[u][increased] = result;
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
    try (CountingShortcuts instance = new CountingShortcuts()) {
      instance.solve();
    }
  }
}
