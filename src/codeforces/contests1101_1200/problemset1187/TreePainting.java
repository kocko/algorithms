package codeforces.contests1101_1200.problemset1187;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreePainting implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    tree = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    size = new long[n];
    ans = new long[n];
    dfs1(0, -1);
    for (int i = 0; i < n; i++) {
      ans[0] += size[i];
    }
    dfs2(0, -1);
    long result = ans[0];
    for (int i = 1; i < n; i++) {
      if (ans[i] > result) {
        result = ans[i];
      }
    }
    out.println(result);
  }

  private int n;
  private List<List<Integer>> tree;
  private long[] size, ans;

  private long dfs1(int node, int parent) {
    int result = 1;
    for (int v : tree.get(node)) {
      if (v != parent) {
        result += dfs1(v, node);
      }
    }
    return size[node] = result;
  }
  
  private void dfs2(int node, int parent) {
    for (int v : tree.get(node)) {
      if (v != parent) {
        ans[v] = ans[node] - size[v] + (n - size[v]);
        dfs2(v, node);
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
    try (TreePainting instance = new TreePainting()) {
      instance.solve();
    }
  }
}
