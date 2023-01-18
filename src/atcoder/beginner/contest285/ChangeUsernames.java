package atcoder.beginner.contest285;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ChangeUsernames implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public ChangeUsernames() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = 1;
    while (T-- > 0) {
      int n = in.ni();
      Map<String, Integer> indexOf = new HashMap<>();
      graph = new ArrayList<>();
      for (int i = 0; i < 2 * n; i++) {
        graph.add(new ArrayList<>());
      }
      degree = new int[2 * n];
      int next = 0;
      for (int i = 0; i < n; i++) {
        String from = in.next(), to = in.next();
        if (!indexOf.containsKey(from)) indexOf.put(from, next++);
        if (!indexOf.containsKey(to)) indexOf.put(to, next++);

        int u = indexOf.get(from), v = indexOf.get(to);
        graph.get(u).add(v);
        degree[v]++;
      }
      visited = new boolean[2 * n];

      for (int i = 0; i < 2 * n; i++) {
        if (!visited[i] && degree[i] == 0) {
          dfs(i);
        }
      }

      boolean ok = true;
      for (int i = 0; i < 2 * n; i++) {
        ok &= degree[i] == 0;
      }
      out.println(ok ? "Yes" : "No");
    }
  }

  private int[] degree;
  private boolean[] visited;
  private List<List<Integer>> graph;

  private void dfs(int u) {
    visited[u] = true;
    for (int v : graph.get(u)) {
      if (--degree[v] == 0) {
        dfs(v);
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
    try (ChangeUsernames instance = new ChangeUsernames()) {
      instance.solve();
    }
  }
}