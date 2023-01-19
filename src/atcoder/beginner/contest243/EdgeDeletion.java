package atcoder.beginner.contest243;

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
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class EdgeDeletion implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public EdgeDeletion() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    long[][] dist = new long[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], (long) 1e18);
    }
    List<int[]> edges = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1, w = in.ni();
      dist[u][v] = dist[v][u] = w;
      edges.add(new int[]{u, v, w});
    }
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }
    int result = 0;
    for (int[] edge : edges) {
      int a = edge[0], b = edge[1], c = edge[2];
      for (int i = 0; i < n; i++) {
        if (dist[a][i] + dist[i][b] <= c) {
          result++;
          break;
        }
      }
    }
    out.println(result);
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
    try (EdgeDeletion instance = new EdgeDeletion()) {
      instance.solve();
    }
  }
}