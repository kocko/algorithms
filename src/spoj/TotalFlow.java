package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TotalFlow implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int nodes = in.ni();
    while (nodes-- > 0) {
      char a = in.next().charAt(0), b = in.next().charAt(0);
      int from, to, capacity = in.ni();
      if (a >= 'a' && a <= 'z') {
        from = a - 'a' + 26;
      } else {
        from = a - 'A';
      }
      if (b >= 'a' && b <= 'z') {
        to = b - 'a' + 26;
      } else {
        to = b - 'A';
      }
      graph[from][to] += capacity;
    }
    out.println(maxFlow());
  }

  private int maxFlow() {
    int total = 0, sent = -1;
    while (sent != 0) {
      visited = new boolean[MAX_N];
      sent = dfs(0, Integer.MAX_VALUE);
      total += sent;
    }
    return total;
  }

  private int MAX_N = 52;
  private int[][] graph = new int[MAX_N][MAX_N];

  private boolean[] visited;

  private int dfs(int from, int amount) {
    if (from == 25) {
      return amount;
    }
    visited[from] = true;
    for (int to = 0; to < MAX_N; to++) {
      if (graph[from][to] > 0 && !visited[to]) {
        int sent = dfs(to, Math.min(graph[from][to], amount));
        if (sent > 0) {
          graph[from][to] -= sent;
          graph[to][from] += sent;
          return sent;
        }
      }
    }
    return 0;
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
    try (TotalFlow instance = new TotalFlow()) {
      instance.solve();
    }
  }
}
