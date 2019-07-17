package codeforces.gyms.gym102254;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FriendshipMatters implements Closeable {

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
    
    public int root(int x) {
      return x == root[x] ? x : (root[x] = root(root[x]));
    }
    
    private void join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          y = x ^ y ^ (x = y);
        }
        root[y] = x;
        size[x] += size[y];
      }
    }
  }

  public void solve() {
    int n = in.ni(), q = in.ni();
    Map<String, Integer> names = new HashMap<>();
    for (int i = 0; i < n; i++) {
      names.put(in.next(), i);
    }
    DisjointSet dsu = new DisjointSet(n);
    while (q-- > 0) {
      int type = in.ni(), a = names.get(in.next()), b = names.get(in.next());
      if (type == 1) {
        dsu.join(a, b);
      } else {
        out.println(dsu.root(a) == dsu.root(b) ? "yes" : "no");
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
    try (FriendshipMatters instance = new FriendshipMatters()) {
      instance.solve();
    }
  }
}
