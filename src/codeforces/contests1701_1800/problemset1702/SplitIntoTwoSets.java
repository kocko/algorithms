package codeforces.contests1701_1800.problemset1702;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class SplitIntoTwoSets implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public SplitIntoTwoSets() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      boolean ans = init() && go();
      out.println(ans ? "YES" : "NO");
    }
  }

  private int n;
  private boolean[] visited;
  private List<List<Integer>> graph;

  private boolean init() {
    n = in.ni();
    visited = new boolean[n + 1];
    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    boolean ans = true;
    for (int i = 0; i < n; i++) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
      graph.get(v).add(u);
      if (u == v || graph.get(u).size() > 2 || graph.get(v).size() > 2) {
        ans = false;
      }
    }
    return ans;
  }

  private boolean go() {
    for (int u = 1; u <= n; u++) {
      if (!visited[u]) {
        int size = dfs(u);
        if (size % 2 == 1) {
          return false;
        }
      }
    }
    return true;
  }

  private int dfs(int node) {
    visited[node] = true;
    int result = 1;
    for (int next : graph.get(node)) {
      if (!visited[next]) {
        result += dfs(next);
      }
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
    try (SplitIntoTwoSets instance = new SplitIntoTwoSets()) {
      instance.solve();
    }
  }
}
