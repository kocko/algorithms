package codeforces.contests101_200.problemset118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BertownRoads implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    int m = in.ni();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    level = new int[n + 1];
    dp = new int[n + 1];
    level[1] = 1;
    visit(1);
    if (bridges == 0) {
      for (int[] edge : result) {
        out.println(edge[0] + " " + edge[1]);
      }
    } else {
      out.println(0);
    }
  }

  private int n, bridges;
  private List<List<Integer>> graph = new ArrayList<>();
  private List<int[]> result = new ArrayList<>();
  private int[] level, dp;

  private void visit(int vertex) {
    dp[vertex] = 0;
    for (int next : graph.get(vertex)) {
      if (level[next] == 0) {
        level[next] = level[vertex] + 1;
        visit(next);
        dp[vertex] += dp[next];
        result.add(new int[]{vertex, next});
      } else if (level[next] < level[vertex]) {
        dp[vertex]++;
        if (level[next] + 1 < level[vertex]) {
          result.add(new int[]{vertex, next});
        }
      } else if (level[next] > level[vertex]) {
        dp[vertex]--;
      }
    }

    dp[vertex]--;

    if (level[vertex] > 0 && dp[vertex] == 0) {
      bridges++;
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
    try (BertownRoads instance = new BertownRoads()) {
      instance.solve();
    }
  }
}
