package codeforces.contests1701_1800.problemset1714;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PathPrefixes implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public PathPrefixes() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    prefix = new long[MAX_N];
    while (T-- > 0) {
      n = in.ni();
      tree = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<>());
      }
      for (int node = 2; node <= n; node++) {
        int parent = in.ni(), a = in.ni(), b = in.ni();
        tree.get(parent).add(new Edge(node, a, b));
      }
      result = new int[n + 1];
      for (Edge edge : tree.get(1)) {
        pointer = 1;
        prefix[pointer++] = edge.b;
        dfs(edge, edge.a);
      }
      for (int idx = 2; idx <= n; idx++) {
        out.print(result[idx]);
        out.print(' ');
      }
      out.println();
    }
  }

  private class Edge {
    private int to, a, b;

    private Edge(int to, int a, int b) {
      this.to = to;
      this.a = a;
      this.b = b;
    }
  }

  private static final int MAX_N = (int) 2e5 + 1;

  private int n;
  private List<List<Edge>> tree;

  private int pointer;
  private long[] prefix;
  private int[] result;

  private void dfs(Edge edge, long A) {
    int left = 0, right = pointer - 1;
    int ans = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (prefix[mid] <= A) {
        ans = Math.max(ans, mid);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    result[edge.to] = ans;


    for (Edge next : tree.get(edge.to)) {
      prefix[pointer] = prefix[pointer - 1] + next.b;
      pointer++;
      dfs(next, A + next.a);
      pointer--;
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
    try (PathPrefixes instance = new PathPrefixes()) {
      instance.solve();
    }
  }
}
