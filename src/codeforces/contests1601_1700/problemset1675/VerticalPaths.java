package codeforces.contests1601_1700.problemset1675;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class VerticalPaths implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      queue = new ArrayDeque<>();
      tree = new ArrayList<>();
      result = new ArrayList<>();
      int n = in.ni();
      for (int i = 0; i < n; i++) {
        tree.add(new ArrayList<>());
      }
      int[] parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = in.ni() - 1;
        if (parent[i] == i) {
          queue.add(i);
        } else {
          tree.get(parent[i]).add(i);
        }
      }
      while (queue.size() > 0) {
        current = new ArrayList<>();
        dfs(queue.pollFirst());
        result.add(current);
      }
      out.println(result.size());
      for (List<Integer> path : result) {
        out.println(path.size());
        for (Integer node : path) {
          out.print(node + 1);
          out.print(' ');
        }
        out.println();
      }
      out.println();
    }
  }

  private ArrayDeque<Integer> queue;
  private List<List<Integer>> tree;
  private List<List<Integer>> result;
  private List<Integer> current;

  private void dfs(int u) {
    current.add(u);
    List<Integer> children = tree.get(u);
    if (children.size() != 0) {
      dfs(children.get(0));
    }
    for (int idx = 1; idx < children.size(); idx++) {
      queue.add(tree.get(u).get(idx));
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
    try (VerticalPaths instance = new VerticalPaths()) {
      instance.solve();
    }
  }
}
