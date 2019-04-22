package codeforces.gyms.gym102157;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDivision implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    if (n % k == 0) {
      target = n / k;
      visited = new boolean[n];
      out.println(dfs(0) == 0 ? "Yes" : "No");
    } else {
      out.println("No");
    }
  }

  private int target;
  private boolean[] visited;
  private List<List<Integer>> tree = new ArrayList<>();

  private int dfs(int u) {
    int size = 1;
    visited[u] = true;
    for (int v : tree.get(u)) {
      if (!visited[v]) {
        size += dfs(v);
      }
    }
    return size == target ? 0 : size;
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
    try (TreeDivision instance = new TreeDivision()) {
      instance.solve();
    }
  }
}
