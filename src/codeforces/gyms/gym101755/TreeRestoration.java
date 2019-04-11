package codeforces.gyms.gym101755;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class TreeRestoration implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] parents = new int[n];
    boolean[][] child = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      int count = in.ni();
      if (count == n) {
        out.println("NO");
        return;
      }
      for (int j = 0; j < count; j++) {
        int c = in.ni() - 1;
        if (i == c) {
          out.println("NO");
          return;
        }
        child[i][c] = true;
        parents[c]++;
      }
    }
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] father = new int[n];
    for (int i = 0; i < n; i++) {
      father[i] = -1;
      if (parents[i] == 0) {
        deque.add(i);
      }
    }
    if (deque.size() != 1) {
      out.println("NO");
      return;
    }
    
    int count = 1, root = deque.peek();
    while (deque.size() > 0) {
      int u = deque.pollFirst();
      for (int v = 0; v < n; v++) {
        if (child[u][v]) {
          if (father[v] != -1 && !child[father[v]][u]) {
            out.println("NO");
            return;
          }
          father[v] = u;
          if (--parents[v] == 0) {
            deque.offerLast(v);
            count++;
          }
        }
      }
    }
    if (count != n) {
      out.println("NO");
      return;
    }
    for (int i = 0; i < n; i++) {
      if (i != root) {
        for (int j = 0; j < n; j++) {
          if (child[i][j]) {
            if (!child[father[i]][j]) {
              out.println("NO");
              return;
            }
          }
        }
      }
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
      if (i != root) {
        out.printf("%d %d\n", father[i] + 1, i + 1);
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
    try (TreeRestoration instance = new TreeRestoration()) {
      instance.solve();
    }
  }
}
