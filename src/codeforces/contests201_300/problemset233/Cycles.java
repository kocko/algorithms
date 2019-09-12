package codeforces.contests201_300.problemset233;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cycles implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    init();
    int n = in.ni();
    int[][] result = new int[100][100];
    int left = 1, right = 100, clique = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (comb[mid] <= n) {
        clique = Math.max(mid, clique);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    for (int i = 0; i < clique; i++) {
      for (int j = 0; j < clique; j++) {
        if (i != j) {
          result[i][j] = 1;
        }
      }
    }
    n -= comb[clique];
    int vertex = clique;
    while (n > 0) {
      int mx = 0, more;
      for (more = 2; more <= vertex; more++) {
        int c = more * (more - 1) / 2;
        if (c <= n) {
          mx = c;
        } else break;
      }
      more--;
      for (int i = 0; i < more; i++) {
        result[i][vertex] = result[vertex][i] = 1;
      }
      n -= mx;
      vertex++;
    }
    out.println(vertex);
    for (int i = 0; i < vertex; i++) {
      for (int j = 0; j < vertex; j++) {
        out.print(result[i][j]);
      }
      out.println();
    }
  }

  private int[] comb = new int[101];

  private void init() {
    for (int i = 3; i <= 100; i++) {
      comb[i] = i * (i - 1) * (i - 2) / 6;
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
    try (Cycles instance = new Cycles()) {
      instance.solve();
    }
  }
}
