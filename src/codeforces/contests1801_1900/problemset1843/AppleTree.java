package codeforces.contests1801_1900.problemset1843;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class AppleTree implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public AppleTree() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      tree = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<>());
      }
      for (int i = 0; i < n - 1; i++) {
        int u = in.ni(), v = in.ni();
        tree.get(u).add(v);
        tree.get(v).add(u);
      }
      children = new int[n + 1];
      dfs(1, -1);
      int q = in.ni();
      while (q-- > 0) {
        int u = in.ni(), v = in.ni();
        out.println(1L * children[u] * children[v]);
      }
    }
  }

  private List<List<Integer>> tree;
  private int[] children;

  private int dfs(int u, int p) {
    int result = 0;
    boolean isLeaf = true;
    for (int next : tree.get(u)) {
      if (next != p) {
        isLeaf = false;
        result += dfs(next, u);
      }
    }
    if (isLeaf) {
      result = 1;
    }
    return children[u] = result;
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
    try (AppleTree instance = new AppleTree()) {
      instance.solve();
    }
  }
}
