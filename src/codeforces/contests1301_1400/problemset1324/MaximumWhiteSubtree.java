package codeforces.contests1301_1400.problemset1324;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class MaximumWhiteSubtree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    color = new int[n];
    for (int i = 0; i < n; i++) {
      color[i] = in.ni();
      if (color[i] == 0) {
        color[i]--;
      }
    }
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    dp = new int[n];
    ans = new int[n];
    dfs(0, -1);
    dfs2(0, -1);
    for (int i = 0; i < n; i++) {
      out.print(ans[i]);
      out.print(' ');
    }
  }

  private int n;
  private int[] color;
  private List<List<Integer>> tree = new ArrayList<>();
  private int[] dp, ans;

  private int dfs(int node, int parent) {
    int ans = color[node];
    for (int next : tree.get(node))
      if (next != parent) {
        int score = dfs(next, node);
        if (score > 0) {
          ans += score;
        }
      }
    return dp[node] = ans;
  }

  private void dfs2(int node, int parent) {
    ans[node] = dp[node];
    for (int next : tree.get(node)) {
      if (next != parent) {
        dp[node] -= max(0, dp[next]);
        dp[next] += max(0, dp[node]);
        dfs2(next, node);
        dp[next] -= max(0, dp[node]);
        dp[node] += max(0, dp[next]);
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
    try (MaximumWhiteSubtree instance = new MaximumWhiteSubtree()) {
      instance.solve();
    }
  }
}
