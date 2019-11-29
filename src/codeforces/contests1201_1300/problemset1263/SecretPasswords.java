package codeforces.contests1201_1300.problemset1263;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SecretPasswords implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class DisjointSet {
    private int[] root, size;

    private DisjointSet(int n) {
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
    DisjointSet dsu = new DisjointSet(26);
    int n = in.ni();
    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = in.next();
      int m = words[i].length();
      int u = words[i].charAt(0) - 'a';
      for (int j = 1; j < m; j++) {
        int v = words[i].charAt(j) - 'a';
        dsu.join(u, v);
      }
    }
    Set<Integer> roots = new HashSet<>();
    for (int i = 0; i < n; i++) {
      roots.add(dsu.root(words[i].charAt(0) - 'a'));
    }
    out.println(roots.size());
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
    try (SecretPasswords instance = new SecretPasswords()) {
      instance.solve();
    }
  }
}
