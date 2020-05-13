package atcoder.beginner.contest166;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ThreeVariablesGame implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    int a = in.ni(), b = in.ni(), c = in.ni();
    x = new String[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.next();
    }
    dfs(a, b, c, 0);
    if (possible) {
      out.println("Yes");
      out.print(result.toString());
    } else {
      out.println("No");
    }
  }

  private boolean possible;
  private int n;
  private String[] x;
  private ArrayDeque<Character> path = new ArrayDeque<>();
  private StringBuilder result = new StringBuilder();

  private void dfs(int a, int b, int c, int idx) {
    if (possible) return;
    if (a < 0 || b < 0 || c < 0) {
      return;
    }
    if (idx == n) {
      possible = true;
      while (path.size() > 0) {
        result.append(path.pollFirst());
        result.append("\n");
      }
      return;
    }
    String command = x[idx];
    if ("AB".equals(command)) {
      path.addLast('A');
      dfs(a + 1, b - 1, c, idx + 1);
      if (path.size() > 0) path.pollLast();

      path.addLast('B');
      dfs(a - 1, b + 1, c, idx + 1);
      if (path.size() > 0) path.pollLast();
    } else if ("BC".equals(command)) {
      path.addLast('B');
      dfs(a, b + 1, c - 1, idx + 1);
      if (path.size() > 0) path.pollLast();

      path.addLast('C');
      dfs(a, b - 1, c + 1, idx + 1);
      if (path.size() > 0) path.pollLast();
    } else if ("AC".equals(command)) {
      path.addLast('A');
      dfs(a + 1, b, c - 1, idx + 1);
      if (path.size() > 0) path.pollLast();

      path.addLast('C');
      dfs(a - 1, b, c + 1, idx + 1);
      if (path.size() > 0) path.pollLast();
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
    try (ThreeVariablesGame instance = new ThreeVariablesGame()) {
      instance.solve();
    }
  }
}
