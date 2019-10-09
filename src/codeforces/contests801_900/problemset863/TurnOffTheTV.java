package codeforces.contests801_900.problemset863;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Math.min;

public class TurnOffTheTV implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    Set<Integer> coordinates = new TreeSet<>();
    int[][] tvs = new int[n][2];
    for (int i = 0; i < n; i++) {
      coordinates.add(tvs[i][0] = in.ni());
      coordinates.add(tvs[i][1] = in.ni());
      coordinates.add(tvs[i][1] + 1);
    }
    Map<Integer, Integer> map = new HashMap<>();
    int idx = 0;
    for (int next : coordinates) {
      map.put(next, idx++);
    }
    this.n = (n = coordinates.size());
    prefix = new int[n + 1];
    for (int[] tv : tvs) {
      int start = map.get(tv[0]), end = map.get(tv[1]) + 1;
      prefix[start]++;
      prefix[end]--;
    }
    for (int i = 1; i <= n; i++) {
      prefix[i] += prefix[i - 1];
    }
    sparseTable();
    for (int i = 0; i < tvs.length; i++) {
      int[] tv = tvs[i];
      int start = map.get(tv[0]), end = map.get(tv[1]);
      int j = log[end - start + 1];
      int min = min(st[start][j], st[end - (1 << j) + 1][j]);
      if (min > 1) {
        out.println(i + 1);
        return;
      }
    }
    out.println(-1);
  }

  private final int MAX_N = 600000, MAX_K = 20;
  private int n;
  private int[] log;
  private int[] prefix;
  private int[][] st;

  private void sparseTable() {
    log = new int[MAX_N + 1];
    log[1] = 0;
    for (int i = 2; i <= MAX_N; i++) {
      log[i] = log[i / 2] + 1;
    }
    st = new int[MAX_N][MAX_K];
    for (int i = 0; i < n; i++) {
      st[i][0] = prefix[i];
    }
    for (int j = 1; j <= MAX_K; j++) {
      for (int i = 0; i + (1 << j) <= n; i++) {
        st[i][j] = min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
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
    try (TurnOffTheTV instance = new TurnOffTheTV()) {
      instance.solve();
    }
  }
}
