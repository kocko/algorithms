package codeforces.contests1001_1100.problemset1037;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class ValidBFS implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<List<Integer>> tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni(), v = in.ni();
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    tree.get(0).add(1);
    int[] bfs = new int[n];
    for (int i = 0; i < n; i++) {
      bfs[i] = in.ni();
    }

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    int idx = 0;
    int[] parent = new int[n + 1];
    boolean valid = true;
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      Set<Integer> children = new HashSet<>();
      for (int ch : tree.get(u)) if (ch != parent[u]) {
        children.add(ch);
        parent[ch] = u;
      }
      for (int next = idx; next < idx + children.size(); next++) {
        valid &= children.contains(bfs[next]);
        queue.add(bfs[next]);
        parent[bfs[next]] = u;
      }
      idx += children.size();
      if (!valid) break;
    }
    out.println(valid ? "Yes" : "No");
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
    try (ValidBFS instance = new ValidBFS()) {
      instance.solve();
    }
  }
}
