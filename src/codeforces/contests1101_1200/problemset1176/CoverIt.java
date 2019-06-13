package codeforces.contests1101_1200.problemset1176;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CoverIt implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      go();
    }
  }
  
  private void go() {
    int n = in.ni(), m = in.ni();
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      List<Integer> list = new ArrayList<>();
      list.add(i);
      graph.add(list);
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    int[] color = new int[n];
    boolean[] visited = new boolean[n];
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    deque.add(0);
    List<Integer> white = new ArrayList<>(), black = new ArrayList<>();
    while (deque.size() > 0) {
      int u = deque.pollFirst();
      for (int v : graph.get(u)) {
        if (!visited[v]) {
          deque.offerLast(v);
          visited[v] = true;
          color[v] = color[u] ^ 1;
          if (color[v] == 0) {
            white.add(v);
          } else {
            black.add(v);
          }
        }
      }
    }
    List<Integer> result;
    if (white.size() <= black.size()) {
      result = white;
    } else {
      result = black;
    }
    out.println(result.size());
    for (int v : result) {
      out.print(v + 1);
      out.print(' ');
    }
    out.println();
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
    try (CoverIt instance = new CoverIt()) {
      instance.solve();
    }
  }
}
