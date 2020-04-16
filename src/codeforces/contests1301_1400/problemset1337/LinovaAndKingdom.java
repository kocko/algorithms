package codeforces.contests1301_1400.problemset1337;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class LinovaAndKingdom implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 1; i < n; i++) {
      int u = in.ni(), v = in.ni();
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    depth = new int[n + 1];
    size = new int[n + 1];
    dfs(1, 0);
    result.sort(Comparator.reverseOrder());
    long ans = 0;
    for (int i = 0; i < n - k; i++) {
      ans += result.get(i);
    }
    out.println(ans);
  }

  private List<List<Integer>> tree = new ArrayList<>();
  private List<Integer> result = new ArrayList<>();
  private int[] depth, size;

  private int dfs(int u, int p) {
    depth[u] = depth[p] + 1;
    size[u] = 1;
    for (int v : tree.get(u)) {
      if (v != p) {
        size[u] += dfs(v, u);
      }
    }
    result.add(size[u] - depth[u]);
    return size[u];
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
    try (LinovaAndKingdom instance = new LinovaAndKingdom()) {
      instance.solve();
    }
  }
}
