package atcoder.beginner.contest157;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class FriendSuggestions implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public FriendSuggestions() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public class DisjointSet {

    private int[] root, size;

    public DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return (x == root[x]) ? x : (root[x] = root(root[x]));
    }

    private void join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          int t = x;
          x = y;
          y = t;
        }
        size[x] += size[y];
        root[y] = x;
      }
    }

  }

  public void solve() {
    int n = in.ni(), m = in.ni(), k = in.ni();
    DisjointSet dsu = new DisjointSet(n);
    List<int[]> friends = new ArrayList<>();
    int[] count = new int[n];
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      friends.add(new int[]{u, v});
      dsu.join(u, v);
      count[u]++;
      count[v]++;
    }
    List<int[]> blocked = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      blocked.add(new int[]{u, v});
    }
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[i] = dsu.size[dsu.root(i)] - 1;
    }
    for (int i = 0; i < n; i++) {
      result[i] -= count[i];
    }
    for (int[] block : blocked) {
      int u = dsu.root(block[0]), v = dsu.root(block[1]);
      if (u == v) {
        result[block[0]]--;
        result[block[1]]--;
      }
    }
    for (int i = 0; i < n; i++) {
      out.print(result[i]);
      out.print(' ');
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
    try (FriendSuggestions instance = new FriendSuggestions()) {
      instance.solve();
    }
  }
}
