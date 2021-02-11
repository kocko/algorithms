package codeforces.contests1201_1300.problemset1288;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MessengerSimulator implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class FenwickTree {
    private int MAX_N;
    private int[] tree;

    private FenwickTree(int n) {
      this.MAX_N = n;
      tree = new int[MAX_N + 1];
    }

    private void update(int idx, int delta) {
      for (; idx <= MAX_N; idx += (idx & -idx)) {
        tree[idx] += delta;
      }
    }

    private int query(int idx) {
      int result = 0;
      for (; idx > 0; idx -= (idx & -idx)) {
        result += tree[idx];
      }
      return result;
    }
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    FenwickTree tree = new FenwickTree(n + m + 1);
    Map<Integer, Integer> position = new HashMap<>();
    int left = n + m;
    for (int i = n; i >= 1; i--, left--) {
      position.put(i, left);
      tree.update(left, 1);
    }
    int[] friends = new int[m];
    for (int i = 0; i < m; i++) {
      friends[i] = in.ni();
    }
    int[][] result = new int[n + 1][2];
    for (int i = 1; i <= n; i++) {
      result[i][0] = result[i][1] = i;
    }
    left++;
    for (int friend : friends) {
      int right = position.get(friend);
      result[friend][0] = 1;
      result[friend][1] = Math.max(result[friend][1], tree.query(right));
      position.put(friend, left - 1);
      tree.update(--left, 1);
      tree.update(right, -1);
    }
    for (int friend = 1; friend <= n; friend++) {
      result[friend][1] = Math.max(result[friend][1], tree.query(position.get(friend)));
      out.println(result[friend][0] + " " + result[friend][1]);
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
    try (MessengerSimulator instance = new MessengerSimulator()) {
      instance.solve();
    }
  }
}
