package codeforces.contests1301_1400.problemset1325;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EhabAndPatheticMexs implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[][] edges = new int[n][2];
    int[] degree = new int[n + 1];
    for (int idx = 1; idx < n; idx++) {
      edges[idx][0] = in.ni();
      edges[idx][1] = in.ni();
      degree[edges[idx][0]]++;
      degree[edges[idx][1]]++;
    }
    int hi = n - 2, lo = 0;
    for (int i = 1; i < n; i++) {
      if (degree[edges[i][0]] == 1 || degree[edges[i][1]] == 1) {
        out.println(lo++);
      } else {
        out.println(hi--);
      }
    }
  }

  private class Edge {
    private int idx, to;

    private Edge(int idx, int to) {
      this.idx = idx;
      this.to = to;
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
    try (EhabAndPatheticMexs instance = new EhabAndPatheticMexs()) {
      instance.solve();
    }
  }
}
