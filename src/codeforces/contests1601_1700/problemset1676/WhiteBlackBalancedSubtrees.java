package codeforces.contests1601_1700.problemset1676;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class WhiteBlackBalancedSubtrees implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      n = in.ni();
      color = new char[n];
      tree = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<>());
      }
      for (int i = 1; i < n; i++) {
        int parent = in.ni() - 1;
        tree.get(parent).add(i);
      }
      color = in.next().toCharArray();
      result = 0;
      dfs(0);
      out.println(result);
    }
  }

  private int n;
  private char[] color;
  private List<List<Integer>> tree;
  private int result;

  private int dfs(int u) {
    int result = color[u] == 'W' ? 1 : -1;
    for (int v : tree.get(u)) {
      result += dfs(v);
    }
    if (result == 0) {
      this.result++;
    }
    return result;
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
    try (WhiteBlackBalancedSubtrees instance = new WhiteBlackBalancedSubtrees()) {
      instance.solve();
    }
  }
}