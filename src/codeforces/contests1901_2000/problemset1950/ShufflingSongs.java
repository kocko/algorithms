package codeforces.contests1901_2000.problemset1950;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class ShufflingSongs implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public ShufflingSongs() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      List<List<Integer>> graph = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
      }
      List<String[]> songs = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        String[] next = new String[]{in.next(), in.next()};
        for (int j = 0; j < songs.size(); j++) {
          String[] now = songs.get(j);
          if (now[0].equals(next[0]) || now[1].equals(next[1])) {
            graph.get(i).add(j);
            graph.get(j).add(i);
          }
        }
        songs.add(next);
      }
      this.graph = graph;
      this.dp = new int[n][1 << n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < (1 << n); j++) {
          dp[i][j] = -1;
        }
      }
      int max = 0;
      for (int start = 0; start < n; start++) {
        int mask = 1 << start;
        int path = 1 + recurse(start, mask);
        if (path > max) {
          max = path;
        }
      }
      out.println(n - max);
    }
  }

  private List<List<Integer>> graph;
  private int[][] dp;

  private int recurse(int node, int mask) {
    if (dp[node][mask] != -1) return dp[node][mask];

    int result = 0;
    for (int next : graph.get(node)) {
      int bit = 1 << next;
      if ((mask & bit) == 0) {
        result = max(result, 1 + recurse(next, mask | bit));
      }
    }
    return dp[node][mask] = result;
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
    try (ShufflingSongs instance = new ShufflingSongs()) {
      instance.solve();
    }
  }
}
